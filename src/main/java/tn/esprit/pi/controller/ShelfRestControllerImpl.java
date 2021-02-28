package tn.esprit.pi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.pi.entities.Shelf;
import tn.esprit.pi.service.IShelfService;

@RestController
public class ShelfRestControllerImpl {
	
	@Autowired
    IShelfService ishelfService;
	
	
	@PostMapping("/addShelf")
	@ResponseBody
	public Shelf addShelf(@RequestBody Shelf shelf)
	{
		ishelfService.addShelf(shelf);
		return shelf;
	}
	
	@DeleteMapping("/deleteShelfById/{idshelf}") 
	@ResponseBody 
	public void deleteEmployeById(@PathVariable("idshelf")long shelfId) {
		ishelfService.DeleteShelfById(shelfId);
		
	}
	
	@GetMapping(value = "/getAllShelfs")
    @ResponseBody
	public List<Shelf> getAllEmployes() {
		
		return ishelfService.getAllShelfs();
	}
	

}
