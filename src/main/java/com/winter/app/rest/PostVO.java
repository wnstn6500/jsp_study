package com.winter.app.rest;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PostVO {

	private Long userId;
	private Long id;
	private String title;
	private String body;
	
}
