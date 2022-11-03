package com.mkj.gtset.service;

import java.util.List;

import com.mkj.gtset.entity.Product;

public interface ProductService {

	public Product getProductByProductName(String productName) throws Exception;
	public List<Product> getProductByCategory(String category) throws Exception;
	public List<Product> getProductByCategoryAndPriceRangeAndDealerName(String category, float price1, float price2, String dealerName) throws Exception;
	public List<Product> getProductByCategoryAndPriceAndRating(String category, float price, float rating) throws Exception;
	public List<Product> getAllProductByDealerName(String dealerName) throws Exception;
	public String insertProduct(Product product) throws Exception;
	public List<Product> getAllProduct() throws Exception;
	public Product getProductByProductCode(int productCode) throws Exception;
	

}
