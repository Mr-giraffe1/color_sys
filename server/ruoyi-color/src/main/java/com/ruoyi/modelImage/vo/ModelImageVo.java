package com.ruoyi.modelImage.vo;

import com.ruoyi.modelImage.domain.ModelImage;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ModelImageVo extends ModelImage {

    //创建人name
    private String UserName;
}
