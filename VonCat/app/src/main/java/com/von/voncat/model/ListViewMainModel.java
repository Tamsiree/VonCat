package com.von.voncat.model;

public class ListViewMainModel {
	private String name;
	private Class activityClass;
	private String description;
	private String icon_img;

	public ListViewMainModel() {
		// TODO Auto-generated constructor stub
	}

	public ListViewMainModel(String name, Class activityClass,
			String description, String icon_img) {
		super();
		this.name = name;
		this.activityClass = activityClass;
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
