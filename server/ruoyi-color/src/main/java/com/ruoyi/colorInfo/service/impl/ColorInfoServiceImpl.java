package com.ruoyi.colorInfo.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ruoyi.colorInfo.vo.ColorInfoVo;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.colorInfo.mapper.ColorInfoMapper;
import com.ruoyi.colorInfo.domain.ColorInfo;
import com.ruoyi.colorInfo.service.IColorInfoService;

/**
 * 颜色信息Service业务层处理
 * 
 * @author kai
 * @date 2023-11-14
 */
@Service
public class ColorInfoServiceImpl implements IColorInfoService 
{
    @Autowired
    private ColorInfoMapper colorInfoMapper;

    /**
     * 查询颜色信息
     * 
     * @param id 颜色信息主键
     * @return 颜色信息
     */
    @Override
    public ColorInfo selectColorInfoById(Long id)
    {
        return colorInfoMapper.selectColorInfoById(id);
    }

    /**
     * 查询颜色信息列表
     * 
     * @param colorInfo 颜色信息
     * @return 颜色信息
     */
    @Override
    public List<ColorInfoVo> selectColorInfoList(ColorInfo colorInfo)
    {
        List<ColorInfoVo>  colorInfoList;
        colorInfoList=colorInfoMapper.selectColorInfoList(colorInfo);
        colorInfoList.forEach(item -> {
            String cmyk=item.getC().toString()+","+item.getM().toString()+","+item.getY().toString()+","+item.getK().toString();
            item.setCmyk(cmyk);
            String rgb=item.getR().toString()+","+item.getG().toString()+","+item.getB();
            item.setRGB(rgb);
        });
        return colorInfoList;
    }

    /**
     * 查询颜色信息列表
     *
     * @param colorInfo 颜色信息
     * @return 颜色信息
     */
    @Override
    public List<ColorInfoVo> selectColorInfoListToShow(ColorInfo colorInfo)
    {
        List<ColorInfoVo>  colorInfoList;
        colorInfoList=colorInfoMapper.selectColorInfoList(colorInfo);
        colorInfoList.forEach(item -> {
            Long RGBArray[]= {item.getR(),item.getG(),item.getB()};
            item.setRGBArray(RGBArray);
            Long CMYKArray[]= {item.getC(),item.getM(),item.getY(),item.getK()};
            item.setCMYkArray(CMYKArray);
        });
        return colorInfoList;
    }

    /**
     * 新增颜色信息
     * 
     * @param colorInfo 颜色信息
     * @return 结果
     */
    @Override
    public int insertColorInfo(ColorInfo colorInfo)
    {
        colorInfo.setCreateTime(DateUtils.getNowDate());
        return colorInfoMapper.insertColorInfo(colorInfo);
    }

    /**
     * 修改颜色信息
     * 
     * @param colorInfo 颜色信息
     * @return 结果
     */
    @Override
    public int updateColorInfo(ColorInfo colorInfo)
    {
        colorInfo.setUpdateTime(DateUtils.getNowDate());
        return colorInfoMapper.updateColorInfo(colorInfo);
    }

    /**
     * 批量删除颜色信息
     * 
     * @param ids 需要删除的颜色信息主键
     * @return 结果
     */
    @Override
    public int deleteColorInfoByIds(Long[] ids)
    {
        return colorInfoMapper.deleteColorInfoByIds(ids);
    }

    /**
     * 删除颜色信息信息
     * 
     * @param id 颜色信息主键
     * @return 结果
     */
    @Override
    public int deleteColorInfoById(Long id)
    {
        return colorInfoMapper.deleteColorInfoById(id);
    }
}
