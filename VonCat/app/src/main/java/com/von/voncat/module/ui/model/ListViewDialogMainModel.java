package com.von.voncat.module.ui.model;

import android.app.Dialog;

public class ListViewDialogMainModel {
	private String name;
	private Dialog dialog;
	private String description;
	private String icon_img;

	public ListViewDialogMainModel() {
		// TODO Auto-generated constructor stub
	}

	public ListViewDialogMainModel(String name, Dialog dialog,
			String description, String icon_img) {
		super();
		this.name = name;
		this.dialog = dialog;
		this.description = description;
		this.icon_img = icon_img;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Dialog getDialog() {
		return dialog;
	}

	public void setDialog(Dialog dialog) {
		this.dialog = dialog;
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
