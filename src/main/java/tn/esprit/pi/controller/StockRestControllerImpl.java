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

import tn.esprit.pi.service.IStockService;

@RestController
public class StockRestControllerImpl {



	@Autowired
	IStockService iStockService;


	@GetMapping(value = "getListMissingProduct")
	@ResponseBody
	public List<Product> getListMissigProduct() {

		return iStockService.getListMissigProduct();
	}

	@PostMapping("/addEntry")
	@ResponseBody
	public String addEntry(@RequestBody Entry entry) {
		iStockService.addEntry(entry);
		return "stock updated with success";
	}

	@DeleteMapping("/deleteEntryById/{identry}")
	@ResponseBody
	public String deleteEntryById(@PathVariable("identry") long entryId) {
		
		
		return iStockService.deleteEntry(entryId);

	}

	@GetMapping(value = "/getAllEntry")
	@ResponseBody
	public List<Entry> getAllEntrys() {

		return iStockService.getAllEntry();
	}

	@GetMapping(value = "/getEntryById/{identry}")
	@ResponseBody
	public Entry getEntryById(@PathVariable("identry") long entryId) {

		if(iStockService.getEntryById(entryId)==null)
		{}
		
		return iStockService.getEntryById(entryId);

	}

	@GetMapping(value = "getEntryByProduct/{productId}")
	@ResponseBody
	public List<Entry> getAllEntryByProduct(@PathVariable("productId") long productId) {
		return iStockService.getEntryByProduct(productId);
	}

	@GetMapping(value = "getEntryByProvider/{providerId}")
	@ResponseBody
	public List<Entry> getAllEntryByProvider(@PathVariable("providerId") long providerId) {
		return iStockService.getEntryByProvider(providerId);
	}

	@GetMapping(value = "getNomberEntryProvider/{providerId}")
	@ResponseBody
	public int getNomberEntryProvider(@PathVariable("providerId") long providerId){

		return iStockService.getNomberProvider(providerId);
	}
	
}
