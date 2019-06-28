/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * IP过滤Entity
 * @author zhangsy
 * @version 2019-06-27
 */
public class FiterIp extends DataEntity<FiterIp> {
	
	private static final long serialVersionUID = 1L;
	private String startIp;		// 起始IP
	private String endIp;		// 结束IP
	
	public FiterIp() {
		super();
	}

	public FiterIp(String id){
		super(id);
	}

	@Length(min=0, max=255, message="起始IP长度必须介于 0 和 255 之间")
	public String getStartIp() {
		return startIp;
	}

	public void setStartIp(String startIp) {
		this.startIp = startIp;
	}
	
	@Length(min=0, max=255, message="结束IP长度必须介于 0 和 255 之间")
	public String getEndIp() {
		return endIp;
	}

	public void setEndIp(String endIp) {
		this.endIp = endIp;
	}
	
}