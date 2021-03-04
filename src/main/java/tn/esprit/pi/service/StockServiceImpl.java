package tn.esprit.pi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import tn.esprit.pi.entities.Entry;
import tn.esprit.pi.entities.Product;

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

	@Override
	public String deleteEntry(long entryId) {
		Entry entry = entryRepository.findById(entryId).get();

		entryRepository.delete(entry);
		return "delete succes";
	}

	@Override
	public List<Entry> getAllEntry() {

		return (List<Entry>) entryRepository.findAll();
	}

	@Override
	public Entry getEntryById(long entryId) {
	return	entryRepository.findById(entryId).get();
	}

	@Override
	public List<Entry> getEntryByProduct(long productId) {
	return entryRepository.getEntryByProduct(productId);
	}

	@Override
	public List<Entry> getEntryByProvider(long providerId) {
		return entryRepository.getEntryByProvider(providerId);
	}

	

}
