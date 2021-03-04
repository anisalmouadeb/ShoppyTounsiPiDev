package tn.esprit.pi.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.pi.entities.Category;
import tn.esprit.pi.service.ICategoryService;

@RestController
public class CategoryRestController {
	
	
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
	public void deleteCategory(@RequestParam("categoryId") Long categoryId )
	{
		this.categoryService.DeleteCategoryById(categoryId);
	}

}
