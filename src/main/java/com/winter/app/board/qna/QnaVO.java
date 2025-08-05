package com.winter.app.board.qna;

import com.winter.app.board.BoardVO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class QnaVO extends BoardVO{

	private Long boardRef;
	private Long boardStep;
	private Long boardDepth;
	
	//seter
	//public void set변수명(타입 변수명){}
	
	//getter
	//public 해당데이터타입 get변수명(){}
	public Long getBoardRef() {
		if(this.boardStep==null) {
			this.boardRef=0L;
			
		}
		
		return this.boardRef;
	}
	
	public Long getBoardStep() {
		if(this.boardStep==null) {
			this.boardRef=0L;
			
		}
		return this.boardStep;
	}
	
	public Long getBoardDepth() {
		if(this.boardDepth==null) {
			this.boardDepth=0L;
			
		}
		return this.boardDepth;
	}
}
