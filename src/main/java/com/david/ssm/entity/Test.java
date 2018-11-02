package com.david.ssm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 *
 * @author david
 * @since 2018-11-02
 */
@Data
@TableName(value = "test")//指定表名
public class Test extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String title;
}
