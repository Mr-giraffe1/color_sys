package com.ruoyi.userInfo.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户信息对象 co_user_info
 * 
 * @author kai
 * @date 2023-11-14
 */
public class UserInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户id */
    private Long id;

    /** 上次登录时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "上次登录时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date lastTime;

    /** 用户昵称 */
    @Excel(name = "用户昵称")
    private String userName;

    /** 用户密码 */
    @Excel(name = "用户密码")
    private String password;

    /** 用户积分 */
    @Excel(name = "用户积分")
    private Long credit;

    /** 邀请人 */
    @Excel(name = "邀请人")
    private Long inviteUser;

    /** 用户等级 */
    @Excel(name = "用户等级")
    private Long grade;

    /** 用户经验 */
    @Excel(name = "用户经验")
    private Long exp;

    /** 登录天数 */
    @Excel(name = "登录天数")
    private Long loginTimes;

    /** 是否删除 0:未删除1:已删除 */
    private Long isDelete;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setLastTime(Date lastTime) 
    {
        this.lastTime = lastTime;
    }

    public Date getLastTime() 
    {
        return lastTime;
    }
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
    }
    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getPassword() 
    {
        return password;
    }
    public void setCredit(Long credit) 
    {
        this.credit = credit;
    }

    public Long getCredit() 
    {
        return credit;
    }
    public void setInviteUser(Long inviteUser) 
    {
        this.inviteUser = inviteUser;
    }

    public Long getInviteUser() 
    {
        return inviteUser;
    }
    public void setGrade(Long grade) 
    {
        this.grade = grade;
    }

    public Long getGrade() 
    {
        return grade;
    }
    public void setExp(Long exp) 
    {
        this.exp = exp;
    }

    public Long getExp() 
    {
        return exp;
    }
    public void setLoginTimes(Long loginTimes) 
    {
        this.loginTimes = loginTimes;
    }

    public Long getLoginTimes() 
    {
        return loginTimes;
    }
    public void setIsDelete(Long isDelete) 
    {
        this.isDelete = isDelete;
    }

    public Long getIsDelete() 
    {
        return isDelete;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("createTime", getCreateTime())
            .append("lastTime", getLastTime())
            .append("userName", getUserName())
            .append("password", getPassword())
            .append("credit", getCredit())
            .append("inviteUser", getInviteUser())
            .append("grade", getGrade())
            .append("exp", getExp())
            .append("loginTimes", getLoginTimes())
            .append("isDelete", getIsDelete())
            .toString();
    }
}
