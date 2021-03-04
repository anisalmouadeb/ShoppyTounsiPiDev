package tn.esprit.pi.service;



import java.util.List;

import org.springframework.data.repository.query.Param;

import tn.esprit.pi.entities.Entry;
import tn.esprit.pi.entities.Product;

public interface IStockService {

	
	public List<Product> listMissigProduct();
	public long addEntry(Entry entry);
	public String affectProductToEntry(long productId, long EntryId);
	public String deleteEntry(long entryId);
	public List<Entry> getAllEntry();
	public Entry getEntryById(long entryId);
	public List<Entry> getEntryByProduct(long productId);
	public List<Entry> getEntryByProvider(long providerId);
}
