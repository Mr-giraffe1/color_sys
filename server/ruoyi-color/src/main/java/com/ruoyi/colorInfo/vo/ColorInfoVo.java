package com.ruoyi.colorInfo.vo;

import com.ruoyi.colorInfo.domain.ColorInfo;
import com.ruoyi.common.annotation.Excel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ColorInfoVo extends ColorInfo {

    //    CMYK值
    @Excel(name = "CMYK")
    private String cmyk;
    //    RGB值
    @Excel(name = "RGB")
    private String RGB;

    //    CMYK值数组
    @Excel(name = "CMYK")
    private Long[] CMYkArray;

    //    RGB值数组
    @Excel(name = "RGB")
    private Long[] RGBArray;
}
