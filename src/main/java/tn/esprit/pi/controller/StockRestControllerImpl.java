package tn.esprit.pi.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



import tn.esprit.pi.entities.Entry;
import tn.esprit.pi.entities.Product;
import tn.esprit.pi.entities.Shelf;
import tn.esprit.pi.service.IStockService;

@RestController
public class StockRestControllerImpl {

	@Autowired
	IStockService iStockService;

	@GetMapping(value = "listMissingProduct")
	@ResponseBody
	public List<Product> getAllEmployeByEntreprise() {

		return iStockService.listMissigProduct();
	}
	
	@PostMapping("/addEntry")
	@ResponseBody
	public Entry addShelf(@RequestBody Entry entry) {
		iStockService.addEntry(entry);
		return entry;
	}
	
	
	@PutMapping(value = "/affecterentryAProduct/{idprod}/{identry}") 
	public String affecterDepartementAEntreprise(@PathVariable("idprod")long productId, @PathVariable("identry")long entryId) {
	return	iStockService.affectProductToEntry(productId, entryId);
	}
	
	@DeleteMapping("/deleteEntryById/{identry}")
	@ResponseBody
	public String deleteEmployeById(@PathVariable("identry") long entryId) {
		return iStockService.deleteEntry(entryId);

	}
	@GetMapping(value = "/getAllEntry")
	@ResponseBody
	public List<Entry> getAllEmployes() {

		return iStockService.getAllEntry();
	}
	
	
	@GetMapping(value = "/getEntryById/{identry}")
	@ResponseBody
	public Entry getAllEntryById(@PathVariable("identry") long entryId) 
{

		return iStockService.getEntryById(entryId);	
	
}
	@GetMapping(value = "getEntryByProduct/{productId}")  
	@ResponseBody
	public List<Entry> getEntryByProduct(@PathVariable("productId") long productId) {
		return iStockService.getEntryByProduct(productId);
	}
	@GetMapping(value = "getEntryByProvider/{providerId}")  
	@ResponseBody
	public List<Entry> getEntryByProvider(@PathVariable("providerId") long providerId) {
		return iStockService.getEntryByProvider(providerId);
	}
	
}
