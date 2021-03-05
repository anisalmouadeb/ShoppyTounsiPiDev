package tn.esprit.pi.service;

import java.util.List;



import tn.esprit.pi.entities.Category;
import tn.esprit.pi.entities.Product;
import tn.esprit.pi.entities.Shelf;
import tn.esprit.pi.entities.ShelfType;

public interface IShelfService {
	
	public long addShelf(Shelf shelf);
	
	public Shelf updateShelf(Shelf shelf);

	public String DeleteShelfById(long shelfId);

	public List<Shelf> getAllShelfs();
	
	public int getNombreShelf() ;
	
	public List<Shelf> getShelfByType(ShelfType type);
	
	public void updatePositionShelById(int position, long shelfId);
	
	public String affecterCategoryShelf(long categoryId, long shelfId);
	
	public List<String> getAllCategoriesNameByShelfId(long shelfId);
	
	 public List<Category> getAllCategoryByShelfJPQL(long Shelfid);
	 
	 public List<Product> getAllProductByShelfJPQL(long Shelfid);
	
}
