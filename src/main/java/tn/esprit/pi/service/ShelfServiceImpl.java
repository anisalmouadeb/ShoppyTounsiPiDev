package tn.esprit.pi.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.pi.entities.Category;
import tn.esprit.pi.entities.Product;
import tn.esprit.pi.entities.Shelf;
import tn.esprit.pi.entities.ShelfRating;
import tn.esprit.pi.entities.ShelfType;
import tn.esprit.pi.entities.User;
import tn.esprit.pi.repository.CategoryRepository;
import tn.esprit.pi.repository.ShelfRatingRepository;
import tn.esprit.pi.repository.UserRepository;
import tn.esprit.pi.repository.ShelfRepository;

@Service
public class ShelfServiceImpl implements IShelfService {

	@Autowired
	ShelfRepository shelfRepository;
	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	ShelfRatingRepository shelfRatingRepository;
	@Autowired
	UserRepository UserRepository;

	@Override
	public long addShelf(Shelf shelf) {

		List<Shelf> shelfs = new ArrayList<>();
		shelfs = (List<Shelf>) shelfRepository.findAll();

		for (Shelf s : shelfs) {
			if (s.getPromo() == true) {
				return 0;
			}
		}
		shelfRepository.save(shelf);
		return shelf.getShelfId();
	}

	@Override
	public String DeleteShelfById(long shelfId) {

		Shelf shelf = shelfRepository.findById(shelfId).get();

		for (Category cat : shelf.getCategory()) {

			for (Product p : cat.getProduct()) {
				p.setInPromo(false);
				p.setPriceV(p.getPriceV() + (p.getPriceV() * shelf.getReduction()) / 100);

			}
			cat.setShelf(null);

		}

		shelfRepository.delete(shelf);
		return "supprimer avec succ";
	}

	@Override
	public List<Shelf> getAllShelfs() {

		return (List<Shelf>) shelfRepository.findAll();
	}

	@Override
	public int getNombreShelf() {
		return shelfRepository.countshelf();

	}

	@Override
	public List<Shelf> getShelfByType(ShelfType type) {
		return shelfRepository.findAllByType(type);
	}

	@Override
	public void updatePositionShelById(int position, long shelfId) {
		Shelf shelf = shelfRepository.findById(shelfId).get();
		shelf.setPosition(position);
		shelfRepository.save(shelf);
	}

	@Override
	public String affecterCategoryShelf(long categoryId, long shelfId) {
		Shelf shelf = shelfRepository.findById(shelfId).get();
		Category category = categoryRepository.findById(categoryId).get();

		if (shelf.getType() == category.getType()) {
			category.setShelf(shelf);
			if (shelf.getPromo() == true) {
				for (Product p : category.getProduct()) {
					p.setInPromo(true);
					p.setPriceV(p.getPriceV() - (p.getPriceV() * shelf.getReduction()) / 100);
				}
			}
			categoryRepository.save(category);
			return "affecter";
		}
		return "impossible d'affecter";
	}

	@Override
	public List<String> getAllCategoriesNameByShelfId(long shelfId) {
		Shelf shelf = shelfRepository.findById(shelfId).get();
		List<String> catNames = new ArrayList<>();
		for (Category cat : shelf.getCategory()) {
			catNames.add(cat.getName());
		}

		return catNames;
	}

	@Override
	public Shelf updateShelf(Shelf shelf) {
		shelfRepository.save(shelf);
		return shelf;
	}

	@Override
	public List<Category> getAllCategoryByShelfJPQL(long Shelfid) {
		return shelfRepository.getAllCategoryByShelfJPQL(Shelfid);
	}

	@Override
	public List<String> getAllProductByShelfJPQL(long Shelfid) {

		return shelfRepository.getAllProductByShelfJPQL(Shelfid);
	}

	@Override
	public Shelf getShelfById(long Shelfid) {
		return shelfRepository.findById(Shelfid).get();
	}

	@Override
	public ShelfRating saveOrUpdateRating(long userId, long Shelfid, int rating) {
		Shelf shelf = shelfRepository.findById(Shelfid).get();
		User user = UserRepository.findById(userId).get();
		List<ShelfRating> reviews = shelfRatingRepository.findByShelf(shelf);
		ShelfRating review = new ShelfRating();

		if (reviews == null) {
			review.setRating(rating);
			review.setShelf(shelf);
			review.setUser(user);
			shelfRatingRepository.save(review);
		} else {
			for (ShelfRating r : reviews) {
				if (r.getUser().getUserId() == userId) {
					r.setRating(rating);
					shelfRatingRepository.save(r);
					updateRatingById(shelf.getShelfId());
					return r;
				}
			}
			review.setRating(rating);
			review.setShelf(shelf);
			review.setUser(user);
			shelfRatingRepository.save(review);
			updateRatingById(shelf.getShelfId());
		}

		return review;
	}

	@Override
	public String daffecterCategoryShelf(long categoryId, long shelfId) {

		Shelf shelf = shelfRepository.findById(shelfId).get();
		Category category = categoryRepository.findById(categoryId).get();
		category.setShelf(null);
		categoryRepository.save(category);
		return "daffecter";
	}

	public void updateRatingById(long shelfId) {
		Shelf shelf = shelfRepository.findById(shelfId).get();
		shelf.setRating(shelfRatingRepository.sumshelfRate(shelfId) / shelfRatingRepository.countshelfRate(shelfId));
		shelfRepository.save(shelf);
	}

	@Override
	public void deleteRating(long ratingId) {

		ShelfRating r = shelfRatingRepository.findById(ratingId).get();
		Shelf shelf = r.getShelf();
		r.setShelf(null);
		r.setUser(null);
		shelfRatingRepository.deleteById(ratingId);
		updateRatingById(shelf.getShelfId());

	}

	@Override
	public ShelfRating getRatingbyId(long rating_id) {

		return shelfRatingRepository.findById(rating_id).get();

	}

	@Override
	public List<ShelfRating> getAllRating() {

		return (List<ShelfRating>) shelfRatingRepository.findAll();

	}

	@Override
	public List<User> getUSersByShelf(long shelfId) {
		List<User> l2 = new ArrayList<>();
		;
		Shelf shelf = shelfRepository.findById(shelfId).get();
		List<ShelfRating> l1 = getAllRating();

		List<ShelfRating> l3 = new ArrayList<>();
		;
		for (ShelfRating s : l1) {
			if (s.getShelf() == shelf) {
				l3.add(s);
			}
		}

		for (ShelfRating s : l3) {
			l2.add(s.getUser());
		}
		System.out.println("anis");
		return l2;

	}
}
