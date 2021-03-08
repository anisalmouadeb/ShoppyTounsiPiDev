package tn.esprit.pi.service;

import java.util.List;

import tn.esprit.pi.entities.Category;

public interface ICategoryService {
	
	public Category addCategory(Category category);

	public void DeleteCategoryById(long categoryId);

	public List<Category> getAllCategory();
	
	public Category updateCategory(Category category);

}
