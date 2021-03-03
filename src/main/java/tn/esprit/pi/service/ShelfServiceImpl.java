package tn.esprit.pi.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.pi.entities.Category;
import tn.esprit.pi.entities.Shelf;
import tn.esprit.pi.entities.ShelfType;
import tn.esprit.pi.repository.CategoryRepository;
import tn.esprit.pi.repository.ShelfRepository;

@Service
public class ShelfServiceImpl implements IShelfService {

	@Autowired
	ShelfRepository shelfRepository;
	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public long addShelf(Shelf shelf) {
		shelfRepository.save(shelf);
		return shelf.getShelfId();
	}

	@Override
	public String DeleteShelfById(long shelfId) {

		Shelf shelf = shelfRepository.findById(shelfId).get();

		for (Category cat : shelf.getCategory())
			cat.setShelf(null);
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
	public void mettreAjourPositionShelById(int position, long shelfId) {
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


}
