package paks.services;

import java.util.List;

import org.springframework.stereotype.Service;

import paks.payloads.categoryDto;
 
public interface categoryServices {

	
public	categoryDto createCategory( categoryDto categoryDto) ;

public	categoryDto UpdateCategory(categoryDto categoryDto ,Integer CategoryId);

public	void DeleteCategory(Integer CategoryId);

public	void DeleteALLCategories();


public categoryDto GetCategory(Integer CategoryId);

public List<categoryDto> getAllCategories();
}
