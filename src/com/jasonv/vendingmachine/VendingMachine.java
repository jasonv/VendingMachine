package com.jasonv.vendingmachine;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.TreeMap;

public class VendingMachine {

	// Display
	private static final String START_UP_MESSAGE = "INSERT COINS";
	private String message = START_UP_MESSAGE;

	// Inventory
	private Products products = new Products();
	int cansDespensed = 0;
	
	// Money
	private BigDecimal balance = BigDecimal.ZERO;
	private BigDecimal changeReturn = BigDecimal.ZERO;
	
	public VendingMachine() {};

	// ================
	// Simple Accessors
	// ================

	public String getMessage() 
	{
		return message ;
	}

	public Product getProduct(int index) {
		return products.get(index);
	}
	
	public Products getProducts() {
		return products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

	public Product getProduct(String name) {
		return products.get(name);
	}
	
	public BigDecimal getBalance() {
		return balance;
	}
	public String getBalanceString() {
		return String.format("%1.2f",balance.doubleValue()) ;
	}
	
	public void setCost(String name,String cost) 
	{
		getProduct(name).setCostPerCan(new BigDecimal(cost));
	}
	public void setCost(String name, BigDecimal cost) 
	{
		getProduct(name).setCostPerCan(cost);
	}

	public String getChangeReturnString()
	{
		return new Change(this.changeReturn).toString();
	}
	public Change getChangeReturn()
	{
		return new Change(this.changeReturn);
	}
	// =======
	// Actions
	// =======
	
	
	/**
	 * Load product.
	 */
	public void stock(String name, int cansToAdd) 
	{	
		Product p = products.get(name);
		p.fillTube(cansToAdd);
		p.setCansPurchased(0);
		if(p.isTubeFull())
		{
			message=String.format("The %s tube is full.\n%d cans available.", name,p.getCansInTube());
		}
		else
		{
			message=String.format("%d %s loaded.\n%d spots left.",cansToAdd,name,p.getSpotsLeftInTube());			
		}
	}

	/**
	 * Get the amount required to pay for the product when the balance is too low.
	 */
	public String getAmountRequired(String name) {
		BigDecimal cost = getProduct(name).getCostPerCan();
		BigDecimal amountRequired = cost.subtract(balance);
		return String.format("%1.2f",amountRequired.doubleValue()) ;
	}

	/**
	 * Put money in the slot.
	 */
	public void insertMoney(String amount) 
	{
		this.balance=this.balance.add(new BigDecimal(amount));
		message="$" + getBalanceString();
	}


	/**
	 * Get money out of the coin return.
	 */
	public void returnChange() 
	{
		this.changeReturn=this.changeReturn.add(getBalance());
		this.balance = BigDecimal.ZERO;
		this.message=START_UP_MESSAGE;
	}

	/**
	 * Press a button for a product.
	 */
	public boolean purchase(String productName) 
	{
		Product p = products.get(productName);
		if(p.getCostPerCan().compareTo(this.balance)<=0)
		{
			this.balance=this.balance.subtract(p.getCostPerCan());
			p.decrementCansInTube();
			p.incrementCansPurchased();
			returnChange();
			cansDespensed++;	
			this.message = START_UP_MESSAGE;
			return true;
		}
		else
		{
			this.message = "$"+this.getAmountRequired(productName);
			return false;
		}
	}

	/**
	 * Remove can from pickup area.
	 */
	public int takeCan() 
	{
		int cans = cansDespensed;
		this.cansDespensed = 0;
		return cans;
	}
	
}
