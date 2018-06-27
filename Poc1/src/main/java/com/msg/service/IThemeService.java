package com.msg.service;

import java.util.List;

import com.msg.dto.ThemeDto;

 

public interface IThemeService {

	List<ThemeDto> fetchAll();
	 
	ThemeDto update(ThemeDto theme);
	
	void delete(int themeid );

	
}
