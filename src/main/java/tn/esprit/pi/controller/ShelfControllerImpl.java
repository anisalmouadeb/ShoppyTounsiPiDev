package tn.esprit.pi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import tn.esprit.pi.entities.Shelf;
import tn.esprit.pi.service.IShelfService;

@Controller
public class ShelfControllerImpl {

	@Autowired
	IShelfService ishelfService;

	public long addShelf(Shelf shelf) {
		ishelfService.addShelf(shelf);
		return shelf.getShelfId();
	}

	public void DeleteShelfById(long shelfId) {

		ishelfService.DeleteShelfById(shelfId);

	}

	public List<Shelf> getAllEmployes() {

		return ishelfService.getAllShelfs();
	}
}
