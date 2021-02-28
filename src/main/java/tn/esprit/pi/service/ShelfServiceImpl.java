package tn.esprit.pi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.pi.entities.Shelf;
import tn.esprit.pi.repository.ShelfRepository;

@Service
public class ShelfServiceImpl implements IShelfService {

	@Autowired
	ShelfRepository shelfRepository;

	@Override
	public long addShelf(Shelf shelf) {
		shelfRepository.save(shelf);
		return shelf.getShelfId();
	}

	@Override
	public void DeleteShelfById(long shelfId) {

		Shelf shelf = shelfRepository.findById(shelfId).get();
		shelfRepository.delete(shelf);
	}

	@Override
	public List<Shelf> getAllShelfs() {

		return (List<Shelf>) shelfRepository.findAll();
	}

}
