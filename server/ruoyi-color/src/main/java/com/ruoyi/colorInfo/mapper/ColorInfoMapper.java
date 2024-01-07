package com.ruoyi.colorInfo.mapper;

import java.util.List;
import com.ruoyi.colorInfo.domain.ColorInfo;
import com.ruoyi.colorInfo.vo.ColorInfoVo;

/**
 * 颜色信息Mapper接口
 * 
 * @author kai
 * @date 2023-11-14
 */
public interface ColorInfoMapper 
{
    /**
     * 查询颜色信息
     * 
     * @param id 颜色信息主键
     * @return 颜色信息
     */
    public ColorInfo selectColorInfoById(Long id);

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
     * 删除颜色信息
     * 
     * @param id 颜色信息主键
     * @return 结果
     */
    public int deleteColorInfoById(Long id);

    /**
     * 批量删除颜色信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteColorInfoByIds(Long[] ids);
}
