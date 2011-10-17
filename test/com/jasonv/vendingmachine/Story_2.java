package com.jasonv.vendingmachine;

import java.math.BigDecimal;

import com.jasonv.vendingmachine.VendingMachine;

import junit.framework.TestCase;

/**
 * 2)
 * 
 * As a user of the vending machine I need a way to insert money. Done when the
 * machine will update balance correctly with value of money inserted.
 */
public class Story_2 extends TestCase {

	public void test_simple()
	{
		VendingMachine vm = new VendingMachine();
		assertEquals("0.00",vm.getBalanceString());
		vm.insertMoney("0.25");
		assertEquals("0.25",vm.getBalanceString());
	}
	
	public void test_should_say_amount_inserted()
	{
		VendingMachine vm = new VendingMachine();
		vm.insertMoney("0.50");
		assertEquals("$0.50",vm.getMessage());
		
	}
}
