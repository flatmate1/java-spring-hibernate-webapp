package pl.miki.dao;

import java.util.List;

import pl.miki.entity.Product;
import pl.miki.model.PaginationResult;
import pl.miki.model.ProductInfo;

public interface ProductDao {

		List<Product> getAllProducts();

		Product getProductById(String productId);

		void deleteProduct(String productId);

		void addProduct(Product product);
		
		void editProduct(Product product);
		
		public Product findProduct(String code);
	    
	    public ProductInfo findProductInfo(String code) ;
	  
	    
	    public PaginationResult<ProductInfo> queryProducts(int page,
	                       int maxResult, int maxNavigationPage  );
	    
	    public PaginationResult<ProductInfo> queryProducts(int page, int maxResult,
	                       int maxNavigationPage, String likeName);
	 
	    public void save(ProductInfo productInfo);
	    
	}