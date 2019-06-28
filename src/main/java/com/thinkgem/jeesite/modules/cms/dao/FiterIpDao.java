/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.cms.entity.FiterIp;

/**
 * IP过滤DAO接口
 * @author zhangsy
 * @version 2019-06-27
 */
@MyBatisDao
public interface FiterIpDao extends CrudDao<FiterIp> {
	
}