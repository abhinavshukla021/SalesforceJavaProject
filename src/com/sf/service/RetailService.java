package com.sf.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sf.beans.Product;
import com.sf.exception.NoDataException;

public interface RetailService {
	public Map<String, Map<String, String>> fetchAllSpecification();

	public List<Product> fetchAllProduct() throws NoDataException;

	public Set<Product> search(String queryString, List<Product> products) throws NoDataException,  com.sf.exception.InvalidInputParameterException;

	public void sortByCategory(List<Product> products);

	public List<Product> specialSort(List<Product> products);

	public void filterInvalidProducts(List<Product> products);
}
