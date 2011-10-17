package com.jasonv.vendingmachine;

import junit.framework.TestCase;

public class Display extends TestCase 
{
	public void test_should_say_insert_coins()
	{
		VendingMachine vm = new VendingMachine();
		vm.getMessage();
		assertEquals("INSERT COINS",vm.getMessage());
	}
}
