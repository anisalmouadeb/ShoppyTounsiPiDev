package tn.esprit.pi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import tn.esprit.pi.entities.Entry;
import tn.esprit.pi.entities.Product;
import tn.esprit.pi.entities.Provider;
import tn.esprit.pi.repository.EntryRepository;
import tn.esprit.pi.repository.ProductRepository;
import tn.esprit.pi.repository.ProviderRepository;

@Service
public class StockServiceImpl implements IStockService {
	@Autowired
	ProductRepository productRepository;
	@Autowired
	EntryRepository entryRepository;
	@Autowired
	ProviderRepository providerRepository;

	@Override
	public List<Product> getListMissigProduct() {

		return productRepository.listMissingProduct();
	}

	@Override
	public long addEntry(Entry entry) {
		Provider provider = providerRepository.findById(entry.getProvider().getProviderId()).get();
		Product product = productRepository.findById(entry.getProduct().getProductId()).get();
		entry.setProvider(provider);
		entry.setProduct(product);
		entryRepository.save(entry);
		return entry.getEntryId();
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
		return entryRepository.findById(entryId).get();
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
