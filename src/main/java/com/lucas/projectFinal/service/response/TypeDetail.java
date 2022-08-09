package com.lucas.projectFinal.service.response;

public class TypeDetail {
	
	private String name;
	
	@Deprecated
	public TypeDetail() {}

	public TypeDetail(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}