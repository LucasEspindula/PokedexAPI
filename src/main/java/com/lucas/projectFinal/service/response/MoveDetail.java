package com.lucas.projectFinal.service.response;

public class MoveDetail {
	
	private String name;
	
	@Deprecated
	public MoveDetail() {}

	public MoveDetail(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}