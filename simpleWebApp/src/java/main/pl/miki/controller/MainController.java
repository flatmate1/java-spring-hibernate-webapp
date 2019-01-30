package pl.miki.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pl.miki.dao.OrderDao;
import pl.miki.dao.ProductDao;
import pl.miki.entity.Product;
import pl.miki.model.CartInfo;
import pl.miki.model.CustomerInfo;
import pl.miki.model.PaginationResult;
import pl.miki.model.ProductInfo;
import pl.miki.util.Utils;
 
	@Controller
	public class MainController {
	 
	    
	    private final OrderDao orderDao;
	 
	    private final ProductDao productDao;
	    
	    @Autowired
	    public MainController(OrderDao orderDao, ProductDao productDao) {
	    	this.orderDao = orderDao;
	    	this.productDao = productDao;
	    }
	 
	    @GetMapping("/")
	    public String home() {
	        return "index";
	    }
	 
	    @RequestMapping({ "/productList" })
	    public String listProductHandler(Model model, //
	            @RequestParam(value = "name", defaultValue = "") String likeName,
	            @RequestParam(value = "page", defaultValue = "1") int page) {
	    	
	        final int maxResult = 5;
	        final int maxNavigationPage = 10;
	 
	        PaginationResult<ProductInfo> result = productDao.queryProducts(page, //
	                maxResult, maxNavigationPage, likeName);
	 
	        model.addAttribute("paginationProducts", result);
	        return "productList";
	    }
	 
	    @GetMapping({ "/buyProduct" })
	    public String listProductHandler(HttpServletRequest request, 
	    								 Model model, //
	    								 @RequestParam(value = "code", defaultValue = "") 
	     							     String code) {
	 
	        Product product = null;
	        if (code != null && code.length() > 0) {
	            product = productDao.findProduct(code);
	        }
	        if (product != null) {
	 
	            // Cart info stored in Session.
	            CartInfo cartInfo = Utils.getCartInSession(request);
	 
	            ProductInfo productInfo = new ProductInfo(product);
	 
	            cartInfo.addProduct(productInfo, 1);
	        }
	        // Redirect to shoppingCart page.
	        return "redirect:/shoppingCart";
	    }
	 
	    @GetMapping({ "/shoppingCartRemoveProduct" })
	    public String removeProductHandler(HttpServletRequest request, 
	    						Model model, //
	    						@RequestParam(value = "code", defaultValue = "") String code) {
	    	
	        Product product = null;
	        if (code != null && code.length() > 0) {
	            product = productDao.findProduct(code);
	        }
	        if (product != null) {
	 
	            // Cart Info stored in Session.
	            CartInfo cartInfo = Utils.getCartInSession(request);
	 
	            ProductInfo productInfo = new ProductInfo(product);
	 
	            cartInfo.removeProduct(productInfo);
	 
	        }
	        // Redirect to shoppingCart page.
	        return "redirect:/shoppingCart";
	    }
	 
	    // POST: Update quantity of products in cart.
	    @PostMapping(value = { "/shoppingCart" })
	    public String shoppingCartUpdateQty(HttpServletRequest request, //
	            							Model model, //
	            							@ModelAttribute("cartForm") CartInfo cartForm) {
	 
	        CartInfo cartInfo = Utils.getCartInSession(request);
	        cartInfo.updateQuantity(cartForm);
	 
	        // Redirect to shoppingCart page.
	        return "redirect:/shoppingCart";
	    }
	 
	    // GET: Show Cart
	    @GetMapping(value = { "/shoppingCart" })
	    public String shoppingCartHandler(HttpServletRequest request, 
	    						          Model model) {
	    	
	        CartInfo myCart = Utils.getCartInSession(request);
	 
	        model.addAttribute("cartForm", myCart);
	        return "shoppingCart";
	    }
	 
	    // GET: Enter customer information.
	    @GetMapping(value = { "/shoppingCartCustomer" })
	    public String shoppingCartCustomerForm(
	    									   HttpServletRequest request, 
	    									   Model model
	    									   ) {
	 
	        CartInfo cartInfo = Utils.getCartInSession(request);
	      
	        // Cart is empty.
	        if (cartInfo.isEmpty()) {
	             
	            // Redirect to shoppingCart page.
	            return "redirect:/shoppingCart";
	        }
	 
	        CustomerInfo customerInfo = cartInfo.getCustomerInfo();
	        if (customerInfo == null) {
	            customerInfo = new CustomerInfo();
	        }
	 
	        model.addAttribute("customerForm", customerInfo);
	 
	        return "shoppingCartCustomer";
	    }
	 
	    // POST: Save customer information.
	    @PostMapping(value = { "/shoppingCartCustomer" })
	    public String shoppingCartCustomerSave(
	    									   HttpServletRequest request, //
									           Model model, //
									           @ModelAttribute("customerForm") 
						    				   @Validated CustomerInfo customerForm, //
						    			       BindingResult result, //
						    				   final RedirectAttributes redirectAttributes
						    				   ) {
	  
	        // If has Errors.
	        if (result.hasErrors()) {
	            customerForm.setValid(false);
	            // Forward to reenter customer info.
	            return "shoppingCartCustomer";
	        }
	 
	        customerForm.setValid(true);
	        CartInfo cartInfo = Utils.getCartInSession(request);
	 
	        cartInfo.setCustomerInfo(customerForm);
	 
	        // Redirect to Confirmation page.
	        return "redirect:/shoppingCartConfirmation";
	    }
	 
	    // GET: Review Cart to confirm.
	    @GetMapping(value = { "/shoppingCartConfirmation" })
	    public String shoppingCartConfirmationReview(
	    		HttpServletRequest request, Model model) {
	        CartInfo cartInfo = Utils.getCartInSession(request);
	 
	        // Cart have no products.
	        if (cartInfo.isEmpty()) {
	            // Redirect to shoppingCart page.
	            return "redirect:/shoppingCart";
	        } else if (!cartInfo.isValidCustomer()) {
	            // Enter customer info.
	            return "redirect:/shoppingCartCustomer";
	        }
	 
	        return "shoppingCartConfirmation";
	    }
	 
	    // POST: Send Cart (Save).
	    @PostMapping(value = { "/shoppingCartConfirmation" })
//	    // Avoid UnexpectedRollbackException (See more explanations)
//	    @Transactional(propagation = Propagation.NEVER)
	    public String shoppingCartConfirmationSave(HttpServletRequest request, Model model) {
	        CartInfo cartInfo = Utils.getCartInSession(request);
	 
	        // Cart have no products.
	        if (cartInfo.isEmpty()) {
	            // Redirect to shoppingCart page.
	            return "redirect:/shoppingCart";
	        } else if (!cartInfo.isValidCustomer()) {
	            // Enter customer info.
	            return "redirect:/shoppingCartCustomer";
	        }
	        try {
	            orderDao.saveOrder(cartInfo);
	        } catch (Exception e) {
	            // Need: Propagation.NEVER?
	            return "shoppingCartConfirmation";
	        }
	        // Remove Cart In Session.
	        Utils.removeCartInSession(request);
	         
	        // Store Last ordered cart to Session.
	        Utils.storeLastOrderedCartInSession(request, cartInfo);
	 
	        // Redirect to successful page.
	        return "redirect:/shoppingCartFinalize";
	    }
	 
	    @GetMapping(value = { "/shoppingCartFinalize" })
	    public String shoppingCartFinalize(HttpServletRequest request, Model model) {
	 
	        CartInfo lastOrderedCart = Utils.getLastOrderedCartInSession(request);
	 
	        if (lastOrderedCart == null) {
	            return "redirect:/shoppingCart";
	        }
	 
	        return "shoppingCartFinalize";
	    }
	 
	    @GetMapping(value = { "/productImage" })
	    public void productImage(HttpServletRequest request, 
	    					     HttpServletResponse response, 
	    					     Model model,
	                             @RequestParam("code") String code) throws IOException {
	    	
	        Product product = null;
	        if (code != null) {
	            product = this.productDao.findProduct(code);
	        }
	        if (product != null && product.getImage() != null) {
	            response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
	            response.getOutputStream().write(product.getImage());
	        }
	        response.getOutputStream().close();
	    }
	     

			@GetMapping( value = { "/login" })
			public String printHello(ModelMap model) {
				return "login";
	      }
			


	   }
     