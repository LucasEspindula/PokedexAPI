package com.lucas.projectFinal.service.response;

public class TypesResponse {
	
	private TypeDetail type;
	
	@Deprecated
	public TypesResponse() {}

	public TypesResponse(String typeName) {
		this.type = new TypeDetail(typeName);
	}

	public TypeDetail getType() {
		return type;
	}
}