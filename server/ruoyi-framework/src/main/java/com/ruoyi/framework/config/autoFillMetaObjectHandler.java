package com.ruoyi.framework.config;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class autoFillMetaObjectHandler implements MetaObjectHandler  {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "createTime", Date.class, new Date());
        this.strictInsertFill(metaObject, "createBy", String.class, "system"); // 可以根据实际情况设置创建人的默认值
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        // 如果有更新时间和更新人的需求，也可以在这里进行处理
    }
}
