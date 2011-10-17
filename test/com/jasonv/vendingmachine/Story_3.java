package com.jasonv.vendingmachine;

import com.jasonv.vendingmachine.VendingMachine;

import junit.framework.TestCase;

/**
 * 3)
 * 
 * As a user of the vending machine I need to be able to purchase a product by
 * pressing the appropriate button for that product. Done when pressing a product
 * button dispenses the appropriate can and updates the user balance.
 */
public class Story_3 extends TestCase {

	public void test_simple()
	{
		VendingMachine vm = new VendingMachine();
		vm.stock("Coke",10);
		vm.setCost("Coke","0.50");
		vm.insertMoney("0.50");
		vm.purchase("Coke");
		assertEquals(1,vm.takeCan());
		vm.returnChange();
		assertEquals("[Quarters=0, Dimes=0, Nickels=0]",vm.getChangeReturnString());
	}
	
	public void test_should_return_to_insert_coins()
	{
		VendingMachine vm = new VendingMachine();
		vm.stock("Coke",10);
		vm.insertMoney("0.50");
		vm.purchase("Coke");
		assertEquals(1,vm.getProduct("Coke").getCansPurchased());
		assertEquals("[Quarters=0, Dimes=0, Nickels=0]",vm.getChangeReturnString());
		assertEquals(9,vm.getProduct("Coke").getCansInTube());
		assertEquals("INSERT COINS",vm.getMessage());
		
	}
	
	public void test_should_show_remainder()
	{
		VendingMachine vm = new VendingMachine();
		vm.stock("Coke",10);
		vm.insertMoney("0.10");
		vm.purchase("Coke");
		assertEquals(0,vm.getProduct("Coke").getCansPurchased());
		assertEquals("[Quarters=0, Dimes=0, Nickels=0]",vm.getChangeReturnString());
		assertEquals(10,vm.getProduct("Coke").getCansInTube());
		assertEquals("$0.40",vm.getMessage());
		
	}
	
	public void test_should_return_to_insert_coins_with_change()
	{
		VendingMachine vm = new VendingMachine();
		vm.stock("Coke",10);
		vm.insertMoney("0.75");
		vm.purchase("Coke");
		assertEquals(1,vm.getProduct("Coke").getCansPurchased());
		assertEquals("[Quarters=1, Dimes=0, Nickels=0]",vm.getChangeReturnString());
		assertEquals(9,vm.getProduct("Coke").getCansInTube());
		assertEquals("INSERT COINS",vm.getMessage());
		
	}
}
