package paks.services.implementation;

import java.util.List;
import java.util.Locale.Category;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import paks.entities.category;
import paks.exceptions.ResourceNotFoundException;
import paks.payloads.categoryDto;
import paks.repository.categortyRepository;
import paks.services.categoryServices;
import org.modelmapper.ModelMapper;

@Service
public class categoryServicesImpl implements categoryServices{
	
	
     @Autowired
	private categortyRepository cr;
     
     @Autowired
     private  ModelMapper ModelMapper;
	
	@Override
	public categoryDto createCategory(categoryDto CategoryDto) {
		category createcategory = this.ModelMapper.map(CategoryDto, category.class);
		category created=	this.cr.save(createcategory);
		return this.ModelMapper.map(created, categoryDto.class);
	}

	@Override
	public categoryDto UpdateCategory(categoryDto CategoryDto, Integer CategoryId) {
		category updatecategory=   this.ModelMapper.map(CategoryDto, category.class);
		category catupd = this.cr.findById(CategoryId).orElseThrow(()->new ResourceNotFoundException("Category","category Id",CategoryId));
		
		catupd.setCatagoryTitle(CategoryDto.getCatagoryTitle());
		catupd.setCatagoryDescription(CategoryDto.getCatagoryDescription());
		
		catupd=	this.cr.save(catupd);
		return this.ModelMapper.map(catupd, categoryDto.class);
	}

	@Override
	public void DeleteCategory(Integer CategoryId) {
this.cr.deleteById(CategoryId);		
System.out.print("Suscessfully deleted catagpry by id"+CategoryId);
	}

	@Override
	public categoryDto GetCategory(Integer CategoryId) {
 
	category c=	this.cr.findById(CategoryId).orElseThrow(()->new ResourceNotFoundException("Category","category Id",CategoryId));
		
		return this.ModelMapper.map(c, categoryDto.class);
	}

	@Override
	public List<categoryDto> getAllCategories() {
  
		List<category >c= this.cr.findAll();
		 
		List<categoryDto> AllCategories=	c.stream().map((cat)->this.ModelMapper.map(cat, categoryDto.class)).collect(Collectors.toList());
		 
		for(categoryDto cc:AllCategories) {
			System.out.println("-------2------>live form servece implemtation "+cc.getCatagoryDescription()+cc.getCatagoryTitle());
		}
		
		return AllCategories;
	}

	@Override
	public void DeleteALLCategories() {
		this.cr.deleteAll();
		
		 System.out.println("Deleted all categories");

	}

}
