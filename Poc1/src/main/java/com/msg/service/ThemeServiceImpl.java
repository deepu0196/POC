package com.msg.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msg.dao.entity.Theme;
import com.msg.dao.repository.ThemeRepository;
import com.msg.dto.ThemeDto;
 
@Service("themeService")
public class ThemeServiceImpl implements IThemeService{

	@Autowired
	private ThemeRepository themeRepository;

	@Override
	public List<ThemeDto> fetchAll() {
		List<Theme> themeList = themeRepository.findAll();
		return themeAssembler(themeList);
			 
	}
	

	private List<ThemeDto> themeAssembler(List<Theme> themeList){
		List<ThemeDto> themes = new ArrayList<>();
		themeList.forEach( theme -> {
			ThemeDto themeDto = new ThemeDto();
			themeDto.setThemeid(theme.getThemeid());
			themeDto.setThemetype(theme.getThemetype());
			themeDto.setThemedesc(theme.getThemedesc());
			
		 
			themes.add(themeDto);
		});
		
		return themes;
	}
	
	 

	@Override
	public ThemeDto update(ThemeDto themeDto) {
		Theme themeupdate = themeRepository.getOne(themeDto.getThemeid());
		 themeupdate.setThemetype(themeDto.getThemetype());
		 themeupdate.setThemedesc(themeDto.getThemedesc());
		 
		 themeupdate = themeRepository.save(themeupdate);
		 return themeDto;
	 
	}
	
 
	@Override
	public void delete(int themeid) {
		
		Theme theme = themeRepository.getOne(themeid);
		themeRepository.delete(theme);	
	
		 
	}

	 
	
	
}
