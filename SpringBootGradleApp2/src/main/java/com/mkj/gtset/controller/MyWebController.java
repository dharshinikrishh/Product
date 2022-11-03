package com.mkj.gtset.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mkj.gtset.entity.Product;
import com.mkj.gtset.service.ProductService;

@RestController
@RequestMapping("/product")
public class MyWebController {

	@Autowired
	ProductService productService;
	
	public MyWebController() {
		System.out.println("\\n\\n\\n====>> Inside Constructor"+this);
	}
	@PostMapping("/addProduct")
	public String addProduct(@RequestBody Product p) {
		try
		{
			return productService.insertProduct(p);
		}catch(Exception e) {
			return "Contact to customer care 1800-454-345 or mail us:- care@capg.com";
		}
	}
	@GetMapping("/products")
	public List<Product> getAllProduct()
	{
		try {
			List<Product> allExtractedProducts = productService.getAllProduct();
			return allExtractedProducts;
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	@GetMapping("/product/{searchProductName}")
	public Product pro1(@PathVariable String searchProductName)throws Exception{
		return productService.getProductByProductName(searchProductName);
	}
	@GetMapping("/product/{searchProductCode}")
	public Product pro2(@PathVariable int searchProductCode)throws Exception{
		return productService.getProductByProductCode(searchProductCode);
	}
	@GetMapping("/product/{dealer}")
	public List<Product> pro3(@PathVariable String dealer) throws Exception {
		System.out.println(" --->> 1 Inside controller " + dealer);
		return productService.getAllProductByDealerName(dealer);
	}
	@GetMapping("/product/{category}")
	public List<Product> pro4(@PathVariable String category) throws Exception {
		return productService.getProductByCategory(category);
	}
	@GetMapping("/productbycategoryandpriceanddealer")
	public List<Product> productsByCategoryAndPriceRangeAndDealerName(@RequestParam String category, @RequestParam float p1,
			@RequestParam float p2, @RequestParam String dealer) throws Exception {

		return productService.getProductByCategoryAndPriceRangeAndDealerName(category, p1, p2, dealer);
	}
	@GetMapping("/productbycatgoryandpriceandrating")
	public List<Product> productsByCategoryAndPriceAndRating(@RequestParam String category, @RequestParam float price, @RequestParam float rating) throws Exception
	{
		return productService.getProductByCategoryAndPriceAndRating(category, price, rating);
		
	}
	
	
}
