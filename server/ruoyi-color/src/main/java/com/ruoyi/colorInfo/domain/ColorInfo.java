package com.ruoyi.colorInfo.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 颜色信息对象 co_color_data
 * 
 * @author kai
 * @date 2023-11-14
 */
public class ColorInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** C */
    @Excel(name = "C")
    private Long c;

    /** M */
    @Excel(name = "M")
    private Long m;

    /** Y */
    @Excel(name = "Y")
    private Long y;

    /** K */
    @Excel(name = "K")
    private Long k;

    /** R */
    @Excel(name = "R")
    private Long r;

    /** G */
    @Excel(name = "G")
    private Long g;

    /** B */
    @Excel(name = "B")
    private Long b;

    /** 16进制表达式 */
    @Excel(name = "16进制表达式")
    private String hex;

    /** 颜色名 */
    @Excel(name = "颜色名")
    private String name;

    /** 拼音 */
    @Excel(name = "拼音")
    private String pinyin;

    /** 色系 */
    @Excel(name = "色系")
    private String sys;

    /** 图片展示 */
    @Excel(name = "图片展示")
    private String image;

    /** id值 */
    private Long id;

    public void setC(Long c) 
    {
        this.c = c;
    }

    public Long getC() 
    {
        return c;
    }
    public void setM(Long m) 
    {
        this.m = m;
    }

    public Long getM() 
    {
        return m;
    }
    public void setY(Long y) 
    {
        this.y = y;
    }

    public Long getY() 
    {
        return y;
    }
    public void setK(Long k) 
    {
        this.k = k;
    }

    public Long getK() 
    {
        return k;
    }
    public void setR(Long r) 
    {
        this.r = r;
    }

    public Long getR() 
    {
        return r;
    }
    public void setG(Long g) 
    {
        this.g = g;
    }

    public Long getG() 
    {
        return g;
    }
    public void setB(Long b) 
    {
        this.b = b;
    }

    public Long getB() 
    {
        return b;
    }
    public void setHex(String hex) 
    {
        this.hex = hex;
    }

    public String getHex() 
    {
        return hex;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setPinyin(String pinyin) 
    {
        this.pinyin = pinyin;
    }

    public String getPinyin() 
    {
        return pinyin;
    }
    public void setSys(String sys) 
    {
        this.sys = sys;
    }

    public String getSys() 
    {
        return sys;
    }
    public void setImage(String image) 
    {
        this.image = image;
    }

    public String getImage() 
    {
        return image;
    }
    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("c", getC())
            .append("m", getM())
            .append("y", getY())
            .append("k", getK())
            .append("r", getR())
            .append("g", getG())
            .append("b", getB())
            .append("hex", getHex())
            .append("name", getName())
            .append("pinyin", getPinyin())
            .append("remark", getRemark())
            .append("sys", getSys())
            .append("image", getImage())
            .append("id", getId())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
