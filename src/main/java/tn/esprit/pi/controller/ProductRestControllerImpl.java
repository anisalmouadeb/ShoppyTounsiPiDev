package tn.esprit.pi.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.pi.entities.Product;
import tn.esprit.pi.service.ProductService;

@RestController
public class ProductRestControllerImpl {
	
	
	@Autowired
	ProductService productService;

	@PostMapping("/addProduct")
	public ResponseEntity<Object> addProduct(@RequestBody Product product) {
		boolean c = CheckingTunisianproducts(String.valueOf(product.getCode()));
		if (c == true) {
			this.productService.addProduct(product);
			return new ResponseEntity<>("Product add successfully",HttpStatus.OK);
		} else {
			return new ResponseEntity<>("The product is not added because it is not Tunisian made",HttpStatus.NO_CONTENT);
		}

	}

	public boolean CheckingTunisianproducts(String code) {
		String Str = new String();
		Str = code;
		Str = Str.substring(0, 3);
		return Str.equals("619");
	}

	@PutMapping("/updateProduct")
	public  ResponseEntity<String> updateProduct(@RequestBody Product product) {

		boolean c = CheckingTunisianproducts(String.valueOf(product.getCode()));
		if (c == true) {
			this.productService.updateProduct(product);
			return ResponseEntity.ok("Product update successfully");
		} else {
			return ResponseEntity.ok("The product is not updated because it is not Tunisian made");
		}
	}

	@GetMapping("/allProducts")
	public List<Product> allProducts() {
		return this.productService.getAllProducts();
	}

	@DeleteMapping("/deleteProduct")
	public void deleteProduct(@PathVariable("productId") Long productId) {
		this.productService.DeleteProductById(productId);
	}
	
	@RequestMapping(value="/addImage",method=RequestMethod.POST,consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Object> uploadFile (@RequestParam("multipartFile") MultipartFile multipartFile,@RequestParam("productId") Long productId) throws IOException
	{
		File convertImage = new File("C:\\test\\"+multipartFile.getOriginalFilename());
		convertImage.createNewFile();
		FileOutputStream fout =new FileOutputStream(convertImage);
		fout.write(multipartFile.getBytes());
		fout.close();
		this.productService.updateProductWithImage(multipartFile.getOriginalFilename(), productId);
		return new ResponseEntity<>("Image is uploaded successfuly  "+multipartFile.getOriginalFilename(),HttpStatus.OK);
	}

}
