package pl.miki.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.miki.dao.ProductDao;
import pl.miki.entity.Product;
import pl.miki.model.PaginationResult;
import pl.miki.model.ProductInfo;




@Service(value="productService")
public class ProductServiceImpl implements ProductService {

	private final ProductDao productDao;

	public ProductServiceImpl(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	@Transactional
	public List<Product> getAllProducts() {
		return productDao.getAllProducts();
	}

	@Transactional
	public Product getProductById(String productId) {
		return productDao.getProductById(productId);
	}

	@Transactional
	public void deleteProduct(String productId) {
		productDao.deleteProduct(productId);
	}
	@Transactional
	public void addProduct(Product product){
		productDao.addProduct(product);
	}
	@Transactional
	public void editProduct(Product product){
		productDao.editProduct(product);
	}

	@Transactional
	public ProductInfo findProductInfo(String code) {
		return productDao.findProductInfo(code);
	}

	@Transactional
	public PaginationResult<ProductInfo> queryProducts(int page, int maxResult, int maxNavigationPage) {
		return productDao.queryProducts(page, maxResult, maxNavigationPage);
	}

	@Transactional
	public PaginationResult<ProductInfo> queryProducts(int page, int maxResult, int maxNavigationPage,
			String likeName) {
		// TODO Auto-generated method stub
		return productDao.queryProducts(page, maxResult, maxNavigationPage, likeName);
	}

	@Transactional
	public void save(ProductInfo productInfo) {
		productDao.save(productInfo);
	}

	@Override
	public Product findProduct(String code) {
		return productDao.findProduct(code);
	}

}
