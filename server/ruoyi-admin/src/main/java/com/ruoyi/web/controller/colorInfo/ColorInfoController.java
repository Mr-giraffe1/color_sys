package com.ruoyi.web.controller.colorInfo;

import com.ruoyi.colorInfo.domain.ColorInfo;
import com.ruoyi.colorInfo.service.IColorInfoService;
import com.ruoyi.colorInfo.vo.ColorInfoVo;
import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 颜色信息Controller
 * 
 * @author kai
 * @date 2023-11-14
 */
@RestController
@RequestMapping("/colorInfo/colorInfo")
public class ColorInfoController extends BaseController
{
    @Autowired
    private IColorInfoService colorInfoService;

    /**
     * 查询颜色信息列表用于表格展示
     */
    @PreAuthorize("@ss.hasPermi('colorInfo:colorInfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(ColorInfo colorInfo)
    {
        startPage();
        List<ColorInfoVo> list = colorInfoService.selectColorInfoList(colorInfo);
        return getDataTable(list);
    }

    /**
     * 查询颜色信息列表用于网页展示
     */
    @Anonymous
    @PostMapping("/listToShow")
    public TableDataInfo listToShow(ColorInfo colorInfo)
    {

        List<ColorInfoVo> list = colorInfoService.selectColorInfoListToShow(colorInfo);
        return getDataTable(list);
    }

    /**
     * 导出颜色信息列表
     */
    @PreAuthorize("@ss.hasPermi('colorInfo:colorInfo:export')")
    @Log(title = "颜色信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ColorInfo colorInfo)
    {
        List<ColorInfoVo> list = colorInfoService.selectColorInfoList(colorInfo);
        ExcelUtil<ColorInfo> util = new ExcelUtil<ColorInfo>(ColorInfo.class);
//        util.exportExcel(response, list., "颜色信息数据");
    }

    /**
     * 获取颜色信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('colorInfo:colorInfo:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(colorInfoService.selectColorInfoById(id));
    }

    /**
     * 新增颜色信息
     */
    @PreAuthorize("@ss.hasPermi('colorInfo:colorInfo:add')")
    @Log(title = "颜色信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ColorInfo colorInfo)
    {
        return toAjax(colorInfoService.insertColorInfo(colorInfo));
    }

    /**
     * 修改颜色信息
     */
    @PreAuthorize("@ss.hasPermi('colorInfo:colorInfo:edit')")
    @Log(title = "颜色信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ColorInfo colorInfo)
    {
        return toAjax(colorInfoService.updateColorInfo(colorInfo));
    }

    /**
     * 删除颜色信息
     */
    @PreAuthorize("@ss.hasPermi('colorInfo:colorInfo:remove')")
    @Log(title = "颜色信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(colorInfoService.deleteColorInfoByIds(ids));
    }
}
