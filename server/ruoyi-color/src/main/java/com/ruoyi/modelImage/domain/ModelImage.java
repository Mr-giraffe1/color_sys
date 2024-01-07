package com.ruoyi.modelImage.domain;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 模板图片信息对象 co_model_image
 * 
 * @author kai
 * @date 2023-11-14
 */
@Data
public class ModelImage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 图片id */
    private Long id;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    @TableField(fill = FieldFill.INSERT)
    private Date creatTime;

    /** 图片地址 */
    @Excel(name = "图片地址")
    private String imageAddress;

    /** 创建人 */
    @Excel(name = "创建人")
    private Long createUser;

    /** 是否删除 0:未删除 1:已删除 */
    @Excel(name = "是否删除 0:未删除 1:已删除")
    private Integer isDelete;

    /** 审核状态0:待审核1:审核通过 */
    @Excel(name = "审核状态0:待审核1:审核通过")
    private Integer auditStatus;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCreatTime(Date creatTime)
    {
        this.creatTime = creatTime;
    }

    public Date getCreatTime()
    {
        return creatTime;
    }
    public void setImageAddress(String imageAddress)
    {
        this.imageAddress = imageAddress;
    }

    public String getImageAddress() 
    {
        return imageAddress;
    }
    public void setCreateUser(Long createUser) 
    {
        this.createUser = createUser;
    }

    public Long getCreateUser() 
    {
        return createUser;
    }
    public void setIsDelete(Integer isDelete) 
    {
        this.isDelete = isDelete;
    }

    public Integer getIsDelete() 
    {
        return isDelete;
    }
    public void setAuditStatus(Integer auditStatus) 
    {
        this.auditStatus = auditStatus;
    }

    public Integer getAuditStatus() 
    {
        return auditStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("creatTime", getCreatTime())
            .append("imageAddress", getImageAddress())
            .append("createUser", getCreateUser())
            .append("isDelete", getIsDelete())
            .append("auditStatus", getAuditStatus())
            .toString();
    }
}
