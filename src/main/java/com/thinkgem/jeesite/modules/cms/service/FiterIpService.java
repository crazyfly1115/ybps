/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.service;

import java.util.List;

import com.thinkgem.jeesite.common.utils.CacheUtils;
import com.thinkgem.jeesite.modules.cms.utils.CmsUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.cms.entity.FiterIp;
import com.thinkgem.jeesite.modules.cms.dao.FiterIpDao;

/**
 * IP过滤Service
 * @author zhangsy
 * @version 2019-06-27
 */
@Service
@Transactional(readOnly = true)
public class FiterIpService extends CrudService<FiterIpDao, FiterIp> {

	public FiterIp get(String id) {
		return super.get(id);
	}
	
	public List<FiterIp> findList(FiterIp fiterIp) {
		return super.findList(fiterIp);
	}
	
	public Page<FiterIp> findPage(Page<FiterIp> page, FiterIp fiterIp) {
		return super.findPage(page, fiterIp);
	}
	
	@Transactional(readOnly = false)
	public void save(FiterIp fiterIp) {
		//移除掉cms的cacha
		CacheUtils.removeAll(CmsUtils.CMS_CACHE);
		super.save(fiterIp);
	}
	
	@Transactional(readOnly = false)
	public void delete(FiterIp fiterIp) {
		super.delete(fiterIp);
	}
	
}