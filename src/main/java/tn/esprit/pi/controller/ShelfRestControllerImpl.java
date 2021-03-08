package tn.esprit.pi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.pi.entities.Category;
import tn.esprit.pi.entities.Product;
import tn.esprit.pi.entities.Shelf;
import tn.esprit.pi.entities.ShelfRating;
import tn.esprit.pi.entities.ShelfType;
import tn.esprit.pi.entities.User;
import tn.esprit.pi.service.IShelfService;

@RestController
public class ShelfRestControllerImpl {

	@Autowired
	IShelfService ishelfService;

	// {"shelfId":1,"shelfname":"name222", "dateCreation":"2021-02-27",
	// "position":3,"type":"NORMAL","image":"iamg22"}
	@PostMapping("/addShelf")
	@ResponseBody
	public ResponseEntity<String> addShelf(@Valid @RequestBody Shelf shelf) {
		ishelfService.addShelf(shelf);
		return ResponseEntity.ok("Shalf added");
	}

	// {"shelfId":1,"shelfname":"name222", "dateCreation":"2021-02-27",
	// "position":3,"type":"NORMAL","image":"iamg22"}
	@PutMapping("/updateShelf")
	@ResponseBody
	public ResponseEntity<String> updateShelf(@RequestBody Shelf shelf) {
		ishelfService.updateShelf(shelf);
		return ResponseEntity.ok("Shalf updated");
	}

	@DeleteMapping("/deleteShelfById/{idshelf}")
	@ResponseBody
	public String deleteEmployeById(@PathVariable("idshelf") long shelfId) {
		return ishelfService.DeleteShelfById(shelfId);

	}

	@GetMapping(value = "/getAllShelfs")
	@ResponseBody
	public List<Shelf> getAllShelfss() {

		return ishelfService.getAllShelfs();
	}

	@GetMapping(value = "/getShelfById/{idshelf}")
	@ResponseBody
	public Shelf getShelfById(@PathVariable("idshelf") long shelfId) {

		return ishelfService.getShelfById(shelfId);
	}

	@GetMapping(value = "getNombreShelf")
	@ResponseBody
	public int getNombreEmployeJPQL() {

		return ishelfService.getNombreShelf();
	}

	@GetMapping("/getShelfByType/{type}")
	@ResponseBody
	public List<Shelf> getShelfByType(@PathVariable("type") ShelfType type) {
		return ishelfService.getShelfByType(type);

	}

	@PutMapping(value = "/updatePosition/{id}/{newposition}")
	@ResponseBody
	public void updatePositionById(@PathVariable("newposition") int position, @PathVariable("id") long shelfId) {
		ishelfService.updatePositionShelById(position, shelfId);

	}

	@PutMapping(value = "/affecterCategoryAShelf/{idcategory}/{idshelf}")
	public String affecterCategoryAShelf(@PathVariable("idcategory") long categoryId,
			@PathVariable("idshelf") long shelfId) {
		return ishelfService.affecterCategoryShelf(categoryId, shelfId);
	}

	@GetMapping(value = "getAllCategoriesNameByShelfId/{idshelf}")
	@ResponseBody
	public List<String> getAllCategoriesNameByShelfId(@PathVariable("idshelf") int shelfId) {
		return ishelfService.getAllCategoriesNameByShelfId(shelfId);
	}

	@GetMapping(value = "getAllCategoriesByShelfId/{idshelf}")
	@ResponseBody
	public List<Category> getAllCategoriesByShelfId(@PathVariable("idshelf") int shelfId) {
		return ishelfService.getAllCategoryByShelfJPQL(shelfId);
	}


	@GetMapping(value = "getAllProductsByShelfId/{idshelf}")
	@ResponseBody
	public List<String> getAllProductsByShelfId(@PathVariable("idshelf") int shelfId) {
		return ishelfService.getAllProductByShelfJPQL(shelfId);
	}

	@PostMapping("addShelfRating/{userId}/{shelfId}/{rating}")
	public ShelfRating saveRating(@PathVariable("userId") int userId, @PathVariable("shelfId") int shelfId,
			@PathVariable("rating") int rating) {

		return ishelfService.saveOrUpdateRating(userId, shelfId, rating);

	}
	@PutMapping(value = "/daffecterCategoryAShelf/{idcategory}/{idshelf}")
	public String daffecterCategoryAShelf(@PathVariable("idcategory") long categoryId,
			@PathVariable("idshelf") long shelfId) {
		return ishelfService.daffecterCategoryShelf(categoryId, shelfId);
	}

	 @DeleteMapping("/deleteShelfRating/{ratingId}")
	    public void deleteRating(@PathVariable("ratingId") int ratingId) {	                       
		 ishelfService.deleteRating(ratingId);
	    }	
	 
	 
	 @GetMapping(value = "getAllRating")
		@ResponseBody
		public  List<ShelfRating> getAllRating() {
			return ishelfService.getAllRating();
		}
	 @GetMapping(value = "getRatingbyId/{idrating}")
		@ResponseBody
		public ShelfRating getRatingbyId(@PathVariable("idrating") long ratingId) {
			return ishelfService.getRatingbyId(ratingId);
		}
	 @GetMapping(value = "getUSersByShelf/{idshelf}")
		@ResponseBody
		public List<User> getUSersByShelf(@PathVariable("idshelf") long idshelf) {
			return ishelfService.getUSersByShelf(idshelf);
		}
	 
	 
}
