package tn.esprit.pi.service;



import java.util.List;

import tn.esprit.pi.entities.Entry;
import tn.esprit.pi.entities.Product;
import tn.esprit.pi.entities.Provider;

public interface IStockService {

	
	public List<Product> getListMissigProduct();
	public long addEntry(Entry entry);
	public String deleteEntry(long entryId);
	public List<Entry> getAllEntry();
	public Entry getEntryById(long entryId);
	public List<Entry> getEntryByProduct(long productId);
	public List<Entry> getEntryByProvider(long providerId);
	public int getNomberProvider(long providerId);
	public List<Provider> getProviderByProduct(long productId);
	public void NotifyProvider (long productId);
	public int getSumOutlay ();
}
