package com.ruoyi.colorInfo.service;

import java.util.List;

import com.ruoyi.colorInfo.vo.ColorInfoVo;
import com.ruoyi.colorInfo.domain.ColorInfo;

/**
 * 颜色信息Service接口
 * 
 * @author kai
 * @date 2023-11-14
 */
public interface IColorInfoService 
{
    /**
     * 查询颜色信息
     * 
     * @param id 颜色信息主键
     * @return 颜色信息
     */
    public ColorInfo selectColorInfoById(Long id);

    /**
     * 查询颜色信息列表用于展示
     *
     * @param id 颜色信息主键
     * @return 颜色信息
     */
    public List<ColorInfoVo> selectColorInfoListToShow(ColorInfo colorInfo);

    /**
     * 查询颜色信息列表
     * 
     * @param colorInfo 颜色信息
     * @return 颜色信息集合
     */
    public List<ColorInfoVo> selectColorInfoList(ColorInfo colorInfo);

    /**
     * 新增颜色信息
     * 
     * @param colorInfo 颜色信息
     * @return 结果
     */
    public int insertColorInfo(ColorInfo colorInfo);

    /**
     * 修改颜色信息
     * 
     * @param colorInfo 颜色信息
     * @return 结果
     */
    public int updateColorInfo(ColorInfo colorInfo);

    /**
     * 批量删除颜色信息
     * 
     * @param ids 需要删除的颜色信息主键集合
     * @return 结果
     */
    public int deleteColorInfoByIds(Long[] ids);

    /**
     * 删除颜色信息信息
     * 
     * @param id 颜色信息主键
     * @return 结果
     */
    public int deleteColorInfoById(Long id);
}
