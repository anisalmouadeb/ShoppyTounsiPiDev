package tn.esprit.pi.service;

import java.util.List;

import tn.esprit.pi.entities.Shelf;

public interface IShelfService {
	
	public long addShelf(Shelf shelf);

	public void DeleteShelfById(long shelfId);

	public List<Shelf> getAllShelfs();
}
