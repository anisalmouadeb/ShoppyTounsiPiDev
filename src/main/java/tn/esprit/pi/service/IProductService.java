package tn.esprit.pi.service;

import java.util.List;

import tn.esprit.pi.entities.Product;


public interface IProductService {
	public long addProduct(Product product);

	public void DeleteProductById(long productId);

	public List<Product> getAllProducts();
	
	public Product updateProduct(Product product);
	
	public Product getProductById(Long productId);
	
	public void updateProductWithImage(String Image,Long ProductId);
}
