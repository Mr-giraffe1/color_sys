<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="上次登录时间" prop="lastTime">
        <el-date-picker clearable
          v-model="queryParams.lastTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择上次登录时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="用户昵称" prop="userName">
        <el-input
          v-model="queryParams.userName"
          placeholder="请输入用户昵称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="用户密码" prop="password">
        <el-input
          v-model="queryParams.password"
          placeholder="请输入用户密码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="用户积分" prop="credit">
        <el-input
          v-model="queryParams.credit"
          placeholder="请输入用户积分"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="邀请人" prop="inviteUser">
        <el-input
          v-model="queryParams.inviteUser"
          placeholder="请输入邀请人"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="用户等级" prop="grade">
        <el-input
          v-model="queryParams.grade"
          placeholder="请输入用户等级"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="用户经验" prop="exp">
        <el-input
          v-model="queryParams.exp"
          placeholder="请输入用户经验"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="登录天数" prop="loginTimes">
        <el-input
          v-model="queryParams.loginTimes"
          placeholder="请输入登录天数"
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
          v-hasPermi="['userInfo:userInfo:add']"
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
          v-hasPermi="['userInfo:userInfo:edit']"
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
          v-hasPermi="['userInfo:userInfo:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['userInfo:userInfo:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="userInfoList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="用户id" align="center" prop="id" />
      <el-table-column label="上次登录时间" align="center" prop="lastTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.lastTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="用户昵称" align="center" prop="userName" />
      <el-table-column label="用户密码" align="center" prop="password" />
      <el-table-column label="用户积分" align="center" prop="credit" />
      <el-table-column label="邀请人" align="center" prop="inviteUser" />
      <el-table-column label="用户等级" align="center" prop="grade" />
      <el-table-column label="用户经验" align="center" prop="exp" />
      <el-table-column label="登录天数" align="center" prop="loginTimes" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['userInfo:userInfo:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['userInfo:userInfo:remove']"
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

    <!-- 添加或修改用户信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="上次登录时间" prop="lastTime">
          <el-date-picker clearable
            v-model="form.lastTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择上次登录时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="用户昵称" prop="userName">
          <el-input v-model="form.userName" placeholder="请输入用户昵称" />
        </el-form-item>
        <el-form-item label="用户密码" prop="password">
          <el-input v-model="form.password" placeholder="请输入用户密码" />
        </el-form-item>
        <el-form-item label="用户积分" prop="credit">
          <el-input v-model="form.credit" placeholder="请输入用户积分" />
        </el-form-item>
        <el-form-item label="邀请人" prop="inviteUser">
          <el-input v-model="form.inviteUser" placeholder="请输入邀请人" />
        </el-form-item>
        <el-form-item label="用户等级" prop="grade">
          <el-input v-model="form.grade" placeholder="请输入用户等级" />
        </el-form-item>
        <el-form-item label="用户经验" prop="exp">
          <el-input v-model="form.exp" placeholder="请输入用户经验" />
        </el-form-item>
        <el-form-item label="登录天数" prop="loginTimes">
          <el-input v-model="form.loginTimes" placeholder="请输入登录天数" />
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
import { listUserInfo, getUserInfo, delUserInfo, addUserInfo, updateUserInfo } from "@/api/userInfo/userInfo";

export default {
  name: "UserInfo",
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
      // 用户信息表格数据
      userInfoList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        lastTime: null,
        userName: null,
        password: null,
        credit: null,
        inviteUser: null,
        grade: null,
        exp: null,
        loginTimes: null,
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
  },
  methods: {
    /** 查询用户信息列表 */
    getList() {
      this.loading = true;
      listUserInfo(this.queryParams).then(response => {
        this.userInfoList = response.rows;
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
        id: null,
        createTime: null,
        lastTime: null,
        userName: null,
        password: null,
        credit: null,
        inviteUser: null,
        grade: null,
        exp: null,
        loginTimes: null,
        isDelete: null
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
      this.title = "添加用户信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getUserInfo(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改用户信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateUserInfo(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addUserInfo(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除用户信息编号为"' + ids + '"的数据项？').then(function() {
        return delUserInfo(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('userInfo/userInfo/export', {
        ...this.queryParams
      }, `userInfo_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
