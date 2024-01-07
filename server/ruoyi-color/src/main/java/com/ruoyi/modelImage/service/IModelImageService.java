package com.ruoyi.modelImage.service;

import java.util.List;
import com.ruoyi.modelImage.domain.ModelImage;
import com.ruoyi.modelImage.vo.ModelImageVo;

/**
 * 模板图片信息Service接口
 * 
 * @author kai
 * @date 2023-11-14
 */
public interface IModelImageService 
{
    /**
     * 查询模板图片信息
     * 
     * @param id 模板图片信息主键
     * @return 模板图片信息
     */
    public ModelImage selectModelImageById(Long id);

    /**
     * 查询模板图片信息列表
     * 
     * @param modelImage 模板图片信息
     * @return 模板图片信息集合
     */
    public List<ModelImageVo> selectModelImageList(ModelImage modelImage);

    /**
     * 新增模板图片信息
     * 
     * @param modelImage 模板图片信息
     * @return 结果
     */
    public int insertModelImage(ModelImage modelImage);

    /**
     * 修改模板图片信息
     * 
     * @param modelImage 模板图片信息
     * @return 结果
     */
    public int updateModelImage(ModelImage modelImage);

    /**
     * 批量删除模板图片信息
     * 
     * @param ids 需要删除的模板图片信息主键集合
     * @return 结果
     */
    public int deleteModelImageByIds(Long[] ids);

    /**
     * 删除模板图片信息信息
     * 
     * @param id 模板图片信息主键
     * @return 结果
     */
    public int deleteModelImageById(Long id);


    /**
     * 保存模板图片信息信息
     *
     * @param imageInfo 模板图片信息
     * @return 是否保存成功
     */
    public boolean saveModel(ModelImage imageInfo);


}
