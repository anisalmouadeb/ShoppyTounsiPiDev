package tn.esprit.pi.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import tn.esprit.pi.entities.Category;
import tn.esprit.pi.entities.Entry;
import tn.esprit.pi.entities.Product;
import tn.esprit.pi.entities.Shelf;
import tn.esprit.pi.repository.EntryRepository;
import tn.esprit.pi.repository.ProductRepository;

@Service
public class StockServiceImpl implements IStockService {

	@Autowired
	ProductRepository productRepository;
	@Autowired
	EntryRepository entryRepository;

	@Override
	public List<Product> listMissigProduct() {

		return productRepository.listMissingProduct();
	}

	@Override
	public long addEntry(Entry entry) {
	   entryRepository.save(entry);
		return entry.getEntryId();
	}

	@Override
	public String affectProductToEntry(long productId, long entryId) {
		Product product = productRepository.findById(productId).get();
		Entry entry = entryRepository.findById(entryId).get();

		if (entry.getProduct() == null) {
			entry.setProduct(product);
			entryRepository.save(entry);
			return "affecter";
		}
		return "impossible d'affecter";
	
	}

}
