package com.ruoyi.web.controller.modelImage;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.modelImage.domain.ModelImage;
import com.ruoyi.modelImage.service.IModelImageService;
import com.ruoyi.modelImage.vo.ModelImageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 模板图片信息Controller
 * 
 * @author kai
 * @date 2023-11-14
 */
@RestController
@RequestMapping("/modelImage/modelImage")
public class ModelImageController extends BaseController
{
    @Autowired
    private IModelImageService modelImageService;

    /**
     * 查询模板图片信息列表
     */
    @PreAuthorize("@ss.hasPermi('modelImage:modelImage:list')")
    @GetMapping("/list")
    public TableDataInfo list(ModelImage modelImage)
    {
        startPage();
        List<ModelImageVo> list = modelImageService.selectModelImageList(modelImage);
        return getDataTable(list);
    }

    /**
     * 导出模板图片信息列表
     */
    @PreAuthorize("@ss.hasPermi('modelImage:modelImage:export')")
    @Log(title = "模板图片信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ModelImage modelImage)
    {
//        List<ModelImage> list = modelImageService.selectModelImageList(modelImage);
//        ExcelUtil<ModelImage> util = new ExcelUtil<ModelImage>(ModelImage.class);
//        util.exportExcel(response, list, "模板图片信息数据");
    }

    /**
     * 获取模板图片信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('modelImage:modelImage:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(modelImageService.selectModelImageById(id));
    }

    /**
     * 新增模板图片信息
     */
    @PreAuthorize("@ss.hasPermi('modelImage:modelImage:add')")
    @Log(title = "模板图片信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ModelImage modelImage)
    {
        return toAjax(modelImageService.insertModelImage(modelImage));
    }

    /**
     * 修改模板图片信息
     */
    @PreAuthorize("@ss.hasPermi('modelImage:modelImage:edit')")
    @Log(title = "模板图片信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ModelImage modelImage)
    {
        return toAjax(modelImageService.updateModelImage(modelImage));
    }

    /**
     * 删除模板图片信息
     */
    @PreAuthorize("@ss.hasPermi('modelImage:modelImage:remove')")
    @Log(title = "模板图片信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(modelImageService.deleteModelImageByIds(ids));
    }

    /**
            * 储存模板信息
     */
    @PreAuthorize("@ss.hasPermi('modelImage:modelImage:remove')")
    @Log(title = "模板图片信息", businessType = BusinessType.DELETE)
    @PostMapping("saveModel")
    public boolean saveModel(@RequestBody ModelImage imageInfo)
    {
        return modelImageService.saveModel(imageInfo);
    }
}
