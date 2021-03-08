package tn.esprit.pi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.pi.entities.Category;
import tn.esprit.pi.service.ICategoryService;

@RestController
public class CategoryRestControllerImlp {
	
	@Autowired
	ICategoryService categoryService;
	
	@PostMapping("/addCategory")
	public Category addCategory(@RequestBody Category category )
	{
		return  categoryService.addCategory(category);
	}
	@PutMapping("/updateCategory")
	public Category updateCategory(@RequestBody Category category)
	{
		return this.categoryService.updateCategory(category);
	}
	@DeleteMapping("/deleteCategory")
	public void deleteCategory(@PathVariable("categoryId") Long categoryId )
	{
		this.categoryService.DeleteCategoryById(categoryId);
	}
	
	@GetMapping("/getAllCategory")
	public List<Category> getAllCategory()
	{
		
		return this.categoryService.getAllCategory();
	}

}
