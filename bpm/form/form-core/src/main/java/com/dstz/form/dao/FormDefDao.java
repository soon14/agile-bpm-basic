package com.dstz.form.dao;

import org.mybatis.spring.annotation.MapperScan;

import com.dstz.base.dao.BaseDao;
import com.dstz.form.model.FormDef;

/**
 * 表单 DAO接口
 *
 * @author aschs
 * @email aschs@qq.com
 * @time 2018-03-19 20:30:46
 */
@MapperScan
public interface FormDefDao extends BaseDao<String, FormDef> {

}
