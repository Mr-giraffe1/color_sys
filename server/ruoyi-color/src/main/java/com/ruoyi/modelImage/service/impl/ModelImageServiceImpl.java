package com.ruoyi.modelImage.service.impl;

import java.util.Date;
import java.util.List;

import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.modelImage.vo.ModelImageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.modelImage.mapper.ModelImageMapper;
import com.ruoyi.modelImage.domain.ModelImage;
import com.ruoyi.modelImage.service.IModelImageService;
import com.ruoyi.common.utils.uuid.IdUtils;

/**
 * 模板图片信息Service业务层处理
 * 
 * @author kai
 * @date 2023-11-14
 */
@Service
public class ModelImageServiceImpl implements IModelImageService 
{
    @Autowired
    private ModelImageMapper modelImageMapper;

    /**
     * 查询模板图片信息
     * 
     * @param id 模板图片信息主键
     * @return 模板图片信息
     */
    @Override
    public ModelImage selectModelImageById(Long id)
    {
        return modelImageMapper.selectModelImageById(id);
    }

    /**
     * 查询模板图片信息列表
     * 
     * @param modelImage 模板图片信息
     * @return 模板图片信息
     */
    @Override
    public List<ModelImageVo> selectModelImageList(ModelImage modelImage)
    {
        return modelImageMapper.selectModelImageList(modelImage);
    }

    /**
     * 新增模板图片信息
     * 
     * @param modelImage 模板图片信息
     * @return 结果
     */
    @Override
    public int insertModelImage(ModelImage modelImage)
    {
        return modelImageMapper.insertModelImage(modelImage);
    }

    /**
     * 修改模板图片信息
     * 
     * @param modelImage 模板图片信息
     * @return 结果
     */
    @Override
    public int updateModelImage(ModelImage modelImage)
    {
        return modelImageMapper.updateModelImage(modelImage);
    }

    /**
     * 批量删除模板图片信息
     * 
     * @param ids 需要删除的模板图片信息主键
     * @return 结果
     */
    @Override
    public int deleteModelImageByIds(Long[] ids)
    {
        return modelImageMapper.deleteModelImageByIds(ids);
    }

    /**
     * 删除模板图片信息信息
     * 
     * @param id 模板图片信息主键
     * @return 结果
     */
    @Override
    public int deleteModelImageById(Long id)
    {
        return modelImageMapper.deleteModelImageById(id);
    }

    @Override
    public boolean saveModel(ModelImage imageInfo) {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        imageInfo.setCreateUser(loginUser.getUserId());//无法区别那个端上传的图片
//        imageInfo.setImageAddress();
        imageInfo.setId(IdUtils.getSnowId());
        imageInfo.setCreatTime(new Date());
        if(modelImageMapper.insertModelImage(imageInfo)>0){
            return true;
        }else{
            return false;
        }

    }
}
