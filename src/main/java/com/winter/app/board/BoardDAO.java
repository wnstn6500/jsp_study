package com.winter.app.board;

public interface BoardDAO {

	// detail
	public BoardVO detail(BoardVO boardVO)throws Exception;
	
	//insert
	public int insert(BoardVO boardVO) throws Exception;
	
	//update
	public int upadate(BoardVO boardVO) throws Exception;
	
	//delete
	public int delete(BoardVO boardVO) throws Exception;
}
