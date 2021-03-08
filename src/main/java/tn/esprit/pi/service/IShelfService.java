package tn.esprit.pi.service;

import java.util.List;

import tn.esprit.pi.entities.Category;
import tn.esprit.pi.entities.Product;
import tn.esprit.pi.entities.Shelf;
import tn.esprit.pi.entities.ShelfRating;
import tn.esprit.pi.entities.ShelfType;
import tn.esprit.pi.entities.User;

public interface IShelfService {

	public long addShelf(Shelf shelf);

	public Shelf updateShelf(Shelf shelf);

	public String DeleteShelfById(long shelfId);

	public List<Shelf> getAllShelfs();

	public Shelf getShelfById(long shelf);

	public int getNombreShelf();

	public List<Shelf> getShelfByType(ShelfType type);

	public void updatePositionShelById(int position, long shelfId);

	public String affecterCategoryShelf(long categoryId, long shelfId);

	public String daffecterCategoryShelf(long categoryId, long shelfId);

	public List<String> getAllCategoriesNameByShelfId(long shelfId);

	public List<Category> getAllCategoryByShelfJPQL(long Shelfid);

	public List<String> getAllProductByShelfJPQL(long Shelfid);

	public ShelfRating saveOrUpdateRating(long userId, long Shelfid, int rating);
	
	public void deleteRating(long ratingId);
	
	  public ShelfRating getRatingbyId(long rating_id);
	  
	  public List<ShelfRating> getAllRating();

	  public List<User> getUSersByShelf(long shelfId);
}
