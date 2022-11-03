package com.mkj.gtset.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkj.gtset.entity.Product;
import com.mkj.gtset.repository.ProductRepository;
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public Product getProductByProductName(String productName) throws Exception {
		// TODO Auto-generated method stub
		return productRepository.getProductByProductName(productName);
	}

	@Override
	public List<Product> getProductByCategory(String category) throws Exception {
		// TODO Auto-generated method stub
		return productRepository.getProductByCategory(category);
	}

	@Override
	public List<Product> getProductByCategoryAndPriceRangeAndDealerName(String category, float price1, float price2,
			String dealerName) throws Exception {
		// TODO Auto-generated method stub
		return productRepository.getProductsByCategoryAndPriceRangeAndDealerName(category, price1, price2, dealerName);
	}

	@Override
	public List<Product> getProductByCategoryAndPriceAndRating(String category, float price, float rating)throws Exception {
		// TODO Auto-generated method stub
		return productRepository.getAllProductsByCategoryAndPriceAndRating(category, price, rating);
	}

	@Override
	public List<Product> getAllProductByDealerName(String dealerName) throws Exception {
		// TODO Auto-generated method stub
		return productRepository.getAllProductByDealerName(dealerName);
	}

	@Override
	public String insertProduct(Product product) throws Exception {
		// TODO Auto-generated method stub
		Product savedProduct =productRepository.save(product); // Note : save() is already implemented by Spring Data JPA
		if (savedProduct != null) {
			return "product saved " + savedProduct.getProductCode() + " productname :- "
					+ savedProduct.getProductName();
		} else
			return null;

	}

	
	@Override
	public Product getProductByProductCode(int productCode) throws Exception {
		// TODO Auto-generated method stub
		return productRepository.getProductByProductCode(productCode);
	}

	@Override
	public List<Product> getAllProduct() throws Exception {
		// TODO Auto-generated method stub
		List<Product> allProduct = productRepository.findAll(); // Note : same as save
		return allProduct;

	}

	
}