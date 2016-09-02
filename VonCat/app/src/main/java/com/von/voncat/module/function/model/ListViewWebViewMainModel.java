package com.von.voncat.module.function.model;

public class ListViewWebViewMainModel {
	private String name;
	private Class activityClass;
	private String url;
	private String description;
	private String icon_img;

	public ListViewWebViewMainModel() {
		// TODO Auto-generated constructor stub
	}

	public ListViewWebViewMainModel(String name, Class activityClass,
			String url, String description, String icon_img) {
		super();
		this.name = name;
		this.activityClass = activityClass;
		this.url = url;
		this.description = description;
		this.icon_img = icon_img;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Class getActivityClass() {
		return activityClass;
	}

	public void setActivityClass(Class activityClass) {
		this.activityClass = activityClass;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIcon_img() {
		return icon_img;
	}

	public void setIcon_img(String icon_img) {
		this.icon_img = icon_img;
	}

}
