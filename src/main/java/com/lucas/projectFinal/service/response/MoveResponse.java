package com.lucas.projectFinal.service.response;

public class MoveResponse {
	
	private MoveDetail move;
	
	@Deprecated
	public MoveResponse() {}

	public MoveResponse(String moveName) {
		this.move = new MoveDetail(moveName);
	}

	public MoveDetail getMove() {
		return move;
	}
}