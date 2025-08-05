package com.winter.app.board;

import java.util.List;

public interface BoardService {

	//list
	public List<BoardVO> list()throws Exception;
	
	//insert
	public int insert(BoardVO boardVO) throws Exception;
	
	public int update(BoardVO boardVO) throws Exception;
	
	public BoardVO detail(BoardVO boardVO) throws Exception;
	
	public int delete(BoardVO boardVO) throws Exception;
}
