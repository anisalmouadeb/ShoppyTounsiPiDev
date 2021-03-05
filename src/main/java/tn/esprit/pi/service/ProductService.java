package tn.esprit.pi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.pi.entities.Product;
import tn.esprit.pi.repository.ProductRepository;

@Service
public class ProductService implements IProductService{

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public long addProduct(Product product) {
		
		return this.productRepository.save(product).getProductId();
		 
	}

	@Override
	public void DeleteProductById(long productId) {
		Product product = this.productRepository.findById(productId).get();
		this.productRepository.delete(product);
		
	}

	@Override
	public List<Product> getAllProducts() {
		
		return  (List<Product>) this.productRepository.findAll();
	}
	@Override
	public Product updateProduct(Product product)
	{
		return this.productRepository.save(product);
		
	}

	@Override
	public Product getProductById(Long productId) {
		
		return this.productRepository.findById(productId).get();
	}

	@Override
	public void updateProductWithImage(String Image, Long ProductId) {
		// TODO Auto-generated method stub
		
	}
	
	

}
