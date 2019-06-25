/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.cms.entity.CmsBook;
import com.thinkgem.jeesite.modules.cms.service.CmsBookService;

/**
 * 新书推荐Controller
 * @author zhangsy
 * @version 2019-06-15
 */
@Controller
@RequestMapping(value = "${adminPath}/cms/cmsBook")
public class CmsBookController extends BaseController {

	@Autowired
	private CmsBookService cmsBookService;
	
	@ModelAttribute
	public CmsBook get(@RequestParam(required=false) String id) {
		CmsBook entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = cmsBookService.get(id);
		}
		if (entity == null){
			entity = new CmsBook();
		}
		return entity;
	}
	
	@RequiresPermissions("cms:cmsBook:view")
	@RequestMapping(value = {"list", ""})
	public String list(CmsBook cmsBook, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<CmsBook> page = cmsBookService.findPage(new Page<CmsBook>(request, response), cmsBook); 
		model.addAttribute("page", page);
		return "modules/cms/cmsBookList";
	}

	@RequiresPermissions("cms:cmsBook:view")
	@RequestMapping(value = "form")
	public String form(CmsBook cmsBook, Model model) {
		model.addAttribute("cmsBook", cmsBook);
		return "modules/cms/cmsBookForm";
	}

	@RequiresPermissions("cms:cmsBook:edit")
	@RequestMapping(value = "save")
	public String save(CmsBook cmsBook, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, cmsBook)){
			return form(cmsBook, model);
		}
		cmsBookService.save(cmsBook);
		addMessage(redirectAttributes, "保存推荐成功");
		return "redirect:"+Global.getAdminPath()+"/cms/cmsBook/?repage";
	}
	
	@RequiresPermissions("cms:cmsBook:edit")
	@RequestMapping(value = "delete")
	public String delete(CmsBook cmsBook, RedirectAttributes redirectAttributes) {
		cmsBookService.delete(cmsBook);
		addMessage(redirectAttributes, "删除推荐成功");
		return "redirect:"+Global.getAdminPath()+"/cms/cmsBook/?repage";
	}

}