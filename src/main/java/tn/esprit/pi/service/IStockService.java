package tn.esprit.pi.service;


import java.util.Date;
import java.util.List;

import tn.esprit.pi.entities.Entry;
import tn.esprit.pi.entities.Product;

public interface IStockService {

	
	public List<Product> listMissigProduct();
	public long addEntry(Entry entry);
	public String affectProductToEntry(long productId, long EntryId);
	
	
}
