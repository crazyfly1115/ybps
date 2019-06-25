/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 新书推荐Entity
 * @author zhangsy
 * @version 2019-06-15
 */
public class CmsBook extends DataEntity<CmsBook> {
	
	private static final long serialVersionUID = 1L;
	private String categoryId;		// 栏目编号
	private String title;		// 标题
	private String image;		// 文章图片
	private String author;		// 作者
	private String puhlishHouse;		// 出版社
	private String publishYear;		// 出版时间
	private String library;		// 馆藏地
	private String indexNo;		// 索引号
	private String keywords;		// 关键字
	private String description;		// 描述、摘要
	private String weight;		// 权重，越大越靠前
	private Date weightDate;		// 权重期限
	private Integer hits;		// 点击数
	private String customContentView;		// 自定义内容视图
	private String viewConfig;		// 视图配置
	
	public CmsBook() {
		super();
	}

	public CmsBook(String id){
		super(id);
	}

	@Length(min=1, max=64, message="栏目编号长度必须介于 1 和 64 之间")
	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	
	@Length(min=1, max=255, message="标题长度必须介于 1 和 255 之间")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@Length(min=0, max=255, message="文章图片长度必须介于 0 和 255 之间")
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	@Length(min=0, max=255, message="作者长度必须介于 0 和 255 之间")
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	@Length(min=0, max=50, message="出版社长度必须介于 0 和 50 之间")
	public String getPuhlishHouse() {
		return puhlishHouse;
	}

	public void setPuhlishHouse(String puhlishHouse) {
		this.puhlishHouse = puhlishHouse;
	}
	
	@Length(min=0, max=255, message="出版时间长度必须介于 0 和 255 之间")
	public String getPublishYear() {
		return publishYear;
	}

	public void setPublishYear(String publishYear) {
		this.publishYear = publishYear;
	}
	
	@Length(min=0, max=255, message="馆藏地长度必须介于 0 和 255 之间")
	public String getLibrary() {
		return library;
	}

	public void setLibrary(String library) {
		this.library = library;
	}
	
	@Length(min=0, max=255, message="索引号长度必须介于 0 和 255 之间")
	public String getIndexNo() {
		return indexNo;
	}

	public void setIndexNo(String indexNo) {
		this.indexNo = indexNo;
	}
	
	@Length(min=0, max=255, message="关键字长度必须介于 0 和 255 之间")
	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	
	@Length(min=0, max=255, message="描述、摘要长度必须介于 0 和 255 之间")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Length(min=0, max=11, message="权重，越大越靠前长度必须介于 0 和 11 之间")
	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getWeightDate() {
		return weightDate;
	}

	public void setWeightDate(Date weightDate) {
		this.weightDate = weightDate;
	}
	
	public Integer getHits() {
		return hits;
	}

	public void setHits(Integer hits) {
		this.hits = hits;
	}
	
	@Length(min=0, max=255, message="自定义内容视图长度必须介于 0 和 255 之间")
	public String getCustomContentView() {
		return customContentView;
	}

	public void setCustomContentView(String customContentView) {
		this.customContentView = customContentView;
	}
	
	public String getViewConfig() {
		return viewConfig;
	}

	public void setViewConfig(String viewConfig) {
		this.viewConfig = viewConfig;
	}
	
}