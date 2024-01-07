<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="C" prop="c">
        <el-input
          v-model="queryParams.c"
          placeholder="请输入C"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="M" prop="m">
        <el-input
          v-model="queryParams.m"
          placeholder="请输入M"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="Y" prop="y">
        <el-input
          v-model="queryParams.y"
          placeholder="请输入Y"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="K" prop="k">
        <el-input
          v-model="queryParams.k"
          placeholder="请输入K"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="R" prop="r">
        <el-input
          v-model="queryParams.r"
          placeholder="请输入R"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="G" prop="g">
        <el-input
          v-model="queryParams.g"
          placeholder="请输入G"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="B" prop="b">
        <el-input
          v-model="queryParams.b"
          placeholder="请输入B"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="16进制" prop="hex">
        <el-input
          v-model="queryParams.hex"
          placeholder="请输入16进制表达式"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="颜色名" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入颜色名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="拼音" prop="pinyin">
        <el-input
          v-model="queryParams.pinyin"
          placeholder="请输入拼音"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['colorInfo:colorInfo:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['colorInfo:colorInfo:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['colorInfo:colorInfo:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['colorInfo:colorInfo:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="colorInfoList" @selection-change="handleSelectionChange" row-key="info">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="GRB" align="center" prop="rgb" />
      <el-table-column label="CMYK" align="center" prop="cmyk" />
      <el-table-column label="16进制" align="center" prop="hex" />
      <el-table-column label="颜色名" align="center" prop="name" />
      <el-table-column label="拼音" align="center" prop="pinyin" />
      <el-table-column label="色系" align="center" prop="sys" />
      <el-table-column label="图片展示" align="center" prop="image" width="100">
        <template slot-scope="scope">
          <div class="color-box" :style="{ backgroundColor: scope.row.hex }"></div>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['colorInfo:colorInfo:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['colorInfo:colorInfo:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改颜色信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="C" prop="c">
          <el-input v-model="form.c" placeholder="请输入C" />
        </el-form-item>
        <el-form-item label="M" prop="m">
          <el-input v-model="form.m" placeholder="请输入M" />
        </el-form-item>
        <el-form-item label="Y" prop="y">
          <el-input v-model="form.y" placeholder="请输入Y" />
        </el-form-item>
        <el-form-item label="K" prop="k">
          <el-input v-model="form.k" placeholder="请输入K" />
        </el-form-item>
        <el-form-item label="R" prop="r">
          <el-input v-model="form.r" type="number" @blur="getCMYK" placeholder="请输入R" />
        </el-form-item>
        <el-form-item label="G" prop="g">
          <el-input v-model="form.g" type="number" @blur="getCMYK" placeholder="请输入G" />
        </el-form-item>
        <el-form-item label="B" prop="b">
          <el-input v-model="form.b" type="number" @blur="getCMYK" placeholder="请输入B" />
        </el-form-item>
        <el-form-item label="16进制表达式" prop="hex">
          <el-input v-model="form.hex" placeholder="请输入16进制表达式" />
        </el-form-item>
        <el-form-item label="颜色名" prop="name">
          <el-input v-model="form.name" @blur="getPinyin" placeholder="请输入颜色名" />
        </el-form-item>
        <el-form-item label="拼音" prop="pinyin">
          <el-input v-model="form.pinyin" placeholder="请输入拼音" />
        </el-form-item>
        
        
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listColorInfo, getColorInfo, delColorInfo, addColorInfo, updateColorInfo, listToShow } from "@/api/colorInfo/colorInfo";
import { pinyin } from 'pinyin-pro';
export default {
  name: "ColorInfo",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 颜色信息表格数据
      colorInfoList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        c: null,
        m: null,
        y: null,
        k: null,
        r: null,
        g: null,
        b: null,
        hex: null,
        name: null,
        pinyin: null,
        sys: null,
        image: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
    listToShow().then(res=>{
      console.log(res)
      debugger
    })
  },
  methods: {
    getCMYK(){
      if(this.form.r&&this.form.g&&this.form.b){
        const cmyk=this.rgbToCmyk(this.form.r,this.form.g,this.form.b)
  
        this.form.c=cmyk.c;
        this.form.m=cmyk.m;
        this.form.y=cmyk.y;
        this.form.k=cmyk.k;
        debugger
      }
      
    },
    //RGB转CMYK值
    rgbToCmyk(r, g, b) {
      r /= 255;
      g /= 255;
      b /= 255;
      const k = 1 - Math.max(r, g, b);
      const c = (1 - r - k) / (1 - k);
      const m = (1 - g - k) / (1 - k);
      const y = (1 - b - k) / (1 - k);

      return { c, m, y, k };
    },
    //通过中文名自动获取获取拼音
    getPinyin(){
      this.form.pinyin= pinyin((this.form.name), { toneType: 'none' });
    },
    /** 查询颜色信息列表 */
    getList() {
      this.loading = true;
      listColorInfo(this.queryParams).then(response => {
        console.log(response)
        console.log(this.queryParams)
        this.colorInfoList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        c: null,
        m: null,
        y: null,
        k: null,
        r: null,
        g: null,
        b: null,
        hex: null,
        name: null,
        pinyin: null,
        remark: null,
        sys: null,
        image: null,
        id: null,
        createTime: null,
        updateTime: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加颜色信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getColorInfo(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改颜色信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateColorInfo(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addColorInfo(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除颜色信息编号为"' + ids + '"的数据项？').then(function() {
        return delColorInfo(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('colorInfo/colorInfo/export', {
        ...this.queryParams
      }, `colorInfo_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>

<style scoped>
.color-box {
  width: 100px;
  height: 100px;
  margin: 10px;
  display: inline-block;
  text-align: center;
  line-height: 100px;
  color: white;
}
</style>
