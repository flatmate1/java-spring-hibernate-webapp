package pl.miki.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pl.miki.entity.Product;
import pl.miki.service.ProductService;

@Controller
public class ProductController {
	
	private final ProductService productService;
	
	private ModelAndView mav;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
    @GetMapping("/productdetail/{code}")
    public ModelAndView productDetail(@PathVariable String code) throws IOException {
    	
    	mav = new ModelAndView("product-detail");
        Product product = productService.findProduct(code);
        mav.addObject(product);
        

        return mav;
    }
}
