package paks.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;
import paks.entities.category;
import paks.payloads.categoryDto;
import paks.payloads.apiResponse;

import org.springframework.web.bind.annotation.RestController;
import paks.services.categoryServices;
import java.util.List;
import java.util.Map; 

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private categoryServices cs;
	 
	
	@PostMapping("/createCategory")
	public ResponseEntity<categoryDto> createCategory(@Valid @RequestBody categoryDto CategoryDto){
 
		categoryDto categoryDto=this.cs.createCategory(CategoryDto);
		return  ResponseEntity.status(HttpStatus.CREATED).body(categoryDto);
	}
	
	
	
	@PutMapping("/updateCategory/{cid}")
	public ResponseEntity<categoryDto> updateCategory(@Valid @RequestBody categoryDto CategoryDto,@PathVariable("cid") Integer cid){
		categoryDto categoryDto =this.cs.UpdateCategory(CategoryDto, cid);
		return  ResponseEntity.status(HttpStatus.CREATED).body(categoryDto);
	}
	
	
	
 @DeleteMapping("/deleteCategory/{cid}")
	public ResponseEntity<apiResponse> deleteCategory(@PathVariable("cid") Integer cid){
		this.cs.DeleteCategory(cid);
		return new ResponseEntity<apiResponse> (new apiResponse("This category is deleted suscessfully",true),HttpStatus.GONE);
 }
	
	
	 @DeleteMapping("/deleteALLCategories")
		public ResponseEntity<apiResponse> deleteALLCategories(){
			this.cs.DeleteALLCategories();
			return new ResponseEntity<apiResponse> (new apiResponse("ALL categories deleted suscessfully",true),HttpStatus.GONE);
	 }
		
	
	@GetMapping("/singleCatagory/{cid}")
	public ResponseEntity<categoryDto> getSingleCategory(@PathVariable("cid") Integer cid){
		categoryDto categoryDto= this.cs.GetCategory(cid);
		return ResponseEntity.status(HttpStatus.FOUND).body(categoryDto);
	}
	
	
	@GetMapping("/allCatagory")
	public ResponseEntity<List<categoryDto> >getAllCategory(){
		List<categoryDto>  allcategories= this.cs.getAllCategories();
		   		return ResponseEntity.status(HttpStatus.FOUND).body(allcategories);
                 }
	/*x-x-x-x-x-xx-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-xx-x-x-x-x-x-x-x--x--x-xx-x-x-x-x-x-x*/
}
