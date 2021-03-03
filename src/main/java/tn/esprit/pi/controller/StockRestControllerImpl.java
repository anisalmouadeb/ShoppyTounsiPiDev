package tn.esprit.pi.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sun.el.parser.ParseException;

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
	
	
	@PutMapping(value = "/affecterentryAProduct/{identry}/{idprod}") 
	public String affecterDepartementAEntreprise(@PathVariable("identry")long productId, @PathVariable("idprod")long entryId) {
	return	iStockService.affectProductToEntry(productId, entryId);
	}
	
	
	
}
