/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.cms.entity.CmsBook;
import com.thinkgem.jeesite.modules.cms.dao.CmsBookDao;

/**
 * 新书推荐Service
 * @author zhangsy
 * @version 2019-06-15
 */
@Service
@Transactional(readOnly = true)
public class CmsBookService extends CrudService<CmsBookDao, CmsBook> {

	public CmsBook get(String id) {
		return super.get(id);
	}
	
	public List<CmsBook> findList(CmsBook cmsBook) {
		return super.findList(cmsBook);
	}
	
	public Page<CmsBook> findPage(Page<CmsBook> page, CmsBook cmsBook) {
		return super.findPage(page, cmsBook);
	}
	
	@Transactional(readOnly = false)
	public void save(CmsBook cmsBook) {
		super.save(cmsBook);
	}
	
	@Transactional(readOnly = false)
	public void delete(CmsBook cmsBook) {
		super.delete(cmsBook);
	}
	
}