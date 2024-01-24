package com.ruoyi.web.controller.fileInfo;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.fileInfo.dto.FileDTO;
import com.ruoyi.fileInfo.service.IFileInfoService;
import io.minio.errors.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

/**
 * 上传文件信息 控制器
 *
 * @author kai
 * @since 2023-07-04
 */
@RestController
@RequestMapping("fileInfo/fileInfo")
public class FileInfoController extends BaseController {

	@Autowired
	private IFileInfoService fileInfoService;

	/**
	 * 文件上传
	 */
	@PostMapping("/upload")
	@ApiOperation(value = "文件上传", notes = "文件上传")
	public Map<String, String> upload(@RequestParam("file") MultipartFile file) {
		return fileInfoService.upload(file);

	}

}
