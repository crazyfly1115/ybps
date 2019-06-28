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
import com.thinkgem.jeesite.modules.cms.entity.FiterIp;
import com.thinkgem.jeesite.modules.cms.service.FiterIpService;

/**
 * IP过滤Controller
 * @author zhangsy
 * @version 2019-06-27
 */
@Controller
@RequestMapping(value = "${adminPath}/cms/fiterIp")
public class FiterIpController extends BaseController {

	@Autowired
	private FiterIpService fiterIpService;
	
	@ModelAttribute
	public FiterIp get(@RequestParam(required=false) String id) {
		FiterIp entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = fiterIpService.get(id);
		}
		if (entity == null){
			entity = new FiterIp();
		}
		return entity;
	}
	
	@RequiresPermissions("cms:fiterIp:view")
	@RequestMapping(value = {"list", ""})
	public String list(FiterIp fiterIp, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<FiterIp> page = fiterIpService.findPage(new Page<FiterIp>(request, response), fiterIp); 
		model.addAttribute("page", page);
		return "modules/cms/fiterIpList";
	}

	@RequiresPermissions("cms:fiterIp:view")
	@RequestMapping(value = "form")
	public String form(FiterIp fiterIp, Model model) {
		model.addAttribute("fiterIp", fiterIp);
		return "modules/cms/fiterIpForm";
	}

	@RequiresPermissions("cms:fiterIp:edit")
	@RequestMapping(value = "save")
	public String save(FiterIp fiterIp, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, fiterIp)){
			return form(fiterIp, model);
		}
		fiterIpService.save(fiterIp);
		addMessage(redirectAttributes, "保存IP过滤成功");
		return "redirect:"+Global.getAdminPath()+"/cms/fiterIp/?repage";
	}
	
	@RequiresPermissions("cms:fiterIp:edit")
	@RequestMapping(value = "delete")
	public String delete(FiterIp fiterIp, RedirectAttributes redirectAttributes) {
		fiterIpService.delete(fiterIp);
		addMessage(redirectAttributes, "删除IP过滤成功");
		return "redirect:"+Global.getAdminPath()+"/cms/fiterIp/?repage";
	}

}