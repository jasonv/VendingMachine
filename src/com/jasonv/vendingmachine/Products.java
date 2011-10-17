package com.jasonv.vendingmachine;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Products 
{
	ArrayList<Product> products;
	
	public Products()
	{
		String[] productNames = {"Coke","Pepsi","DrPepper"};
		products = new ArrayList<Product>();
		for(String productName:productNames)
		{
			products.add(
					new Product(
							productName,
							new BigDecimal("0.50")
							,10 
							,0
							,0
							)
					);
		}
	}
	
	public ArrayList<Product> toList() {
		return products;
	}

	public int size()
	{
		return products.size();
	}
	
	public Product get(String name)
	{
		for(Product product:products)
		{
			if(product.getName().equals(name))
			{
				return product;
			}
		}
		return null;
	}
	
	public Product get(int index)
	{
		return products.get(index);
	}
	
	
}
