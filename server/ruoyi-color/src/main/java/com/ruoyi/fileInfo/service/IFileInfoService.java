package com.ruoyi.fileInfo.service;

import io.minio.errors.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import com.ruoyi.fileInfo.dto.FileDTO;

/**
 * 上传文件信息 服务类
 *
 * @author wzz
 * @since 2023-07-04
 */
public interface IFileInfoService {

	/**
	 * 文件上传
	 *
	 * @return
	 */
	public Map<String, String> upload(MultipartFile file);
	Map<String,String> download(MultipartFile file);

}
