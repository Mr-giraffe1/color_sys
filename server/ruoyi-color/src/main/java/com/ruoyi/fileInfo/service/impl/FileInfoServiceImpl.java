package com.ruoyi.fileInfo.service.impl;

import io.minio.*;
import io.minio.errors.*;
import com.ruoyi.fileInfo.service.IFileInfoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.ruoyi.fileInfo.dto.FileDTO;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.TreeMap;

/**
 * 上传文件信息 服务实现类
 *
 * @author kai
 * @since 2023-07-04
 */
@Service
public class FileInfoServiceImpl implements IFileInfoService {

	@Value("${oss.endpoint}")
	private String minioEndpoint;

	@Value("${oss.access-key}")
	private String accessKey;

	@Value("${oss.secret-key}")
	private String secretKey;

	@Value("${oss.bucket-name}")
	private String defaultBucketName;




	@Override
	public Map<String, String> upload(MultipartFile file) {
		Map<String, String> fileMap = new TreeMap<>();
		try {
			MinioClient minioClient =
					MinioClient.builder()
							.endpoint(minioEndpoint)
							.credentials(accessKey, secretKey)
							.build();

			String bucketName = defaultBucketName;

			// 创建BucketExistsArgs实例
			BucketExistsArgs existsArgs = BucketExistsArgs.builder()
					.bucket(bucketName)
					.build();

			// 检查桶是否存在，不存在则创建
			boolean bucketExists = minioClient.bucketExists(existsArgs);
			if (!bucketExists) {
				// 创建MakeBucketArgs实例
				MakeBucketArgs makeArgs = MakeBucketArgs.builder()
						.bucket(bucketName)
						.build();
				minioClient.makeBucket(makeArgs);
			}

			// 生成对象名称，可以使用UUID或其他唯一标识符
			String objectName = file.getOriginalFilename();

			// 上传对象
			minioClient.putObject(PutObjectArgs.builder()
					.bucket(bucketName)
					.object(objectName)
					.stream(file.getInputStream(), file.getSize(), -1)
					.contentType(file.getContentType())
					.build());
			String objectUrl = minioEndpoint + "/" + defaultBucketName + "/" + objectName;
			fileMap.put("filePath",objectUrl);
			fileMap.put("fileName",objectName);
			System.out.println("Object uploaded successfully to MinIO");
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}

		return fileMap;
	}

	@Override
	public Map<String, String> download(MultipartFile file) {
		return null;
	}
}
