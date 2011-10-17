package com.jasonv.vendingmachine;

import java.math.BigDecimal;
import java.util.ArrayList;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class Product 
{
	private String name = "";
	private BigDecimal costPerCan = BigDecimal.ONE;
	private int cansInTubeMax = 0;
	private int cansInTube = 0;
	private int cansPurchased = 0;
	
	public Product(
			String name, 
			BigDecimal costPerCan, 
			int cansInTubeMax,
			int cansInTube, 
			int cansPurchased) 
	{
		this.name = name;
		this.costPerCan = costPerCan;
		this.cansInTubeMax = cansInTubeMax;
		this.cansInTube = cansInTube;
		this.cansPurchased = cansPurchased;
	}

	/**
	 * Enforce the size of the tubes.
	 */
	public boolean fillTube(int cansToAdd) 
	{
		if((cansInTube + cansToAdd) > cansInTubeMax)
		{
			cansInTube = cansInTubeMax;
			return true;
		}
		else
		{
			cansInTube+=cansToAdd;
			return false;
		}
	}

	
	// =========================================
	// Getters, Setters, Increment and Decrement
	// =========================================
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getCostPerCan() {
		return costPerCan;
	}
	public void setCostPerCan(BigDecimal costPerCan) {
		this.costPerCan = costPerCan;
	}
	public int getCansInTubeMax() {
		return cansInTubeMax;
	}
	public void setCansInTubeMax(int cansInTubeMax) {
		this.cansInTubeMax = cansInTubeMax;
	}
	public int getCansInTube() {
		return cansInTube;
	}
	public void setCansInTube(int cansInTube) {
		this.cansInTube = cansInTube;
	}
	public int getCansPurchased() {
		return cansPurchased;
	}
	public void setCansPurchased(int cansPurchased) {
		this.cansPurchased = cansPurchased;
	}

	public void incrementCansPurchased() 
	{
		cansPurchased++;
	}
	

	public boolean isTubeFull() 
	{
		return cansInTube == cansInTubeMax;
	}
	
	public int getSpotsLeftInTube()
	{
		return cansInTubeMax-cansInTube;
	}

	public void decrementCansInTube() 
	{
		this.cansInTube--;
	}


}
