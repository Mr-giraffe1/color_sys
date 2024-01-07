package com.ruoyi.fileInfo.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.net.FileNameMap;

/**
 * @Author: mingwei
 * @Date:2023/7/11
 * @Description:
 */
@Data
public class FileDTO {



	private String fileName;

	private String filePath;

}
