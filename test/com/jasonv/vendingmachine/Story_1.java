package com.jasonv.vendingmachine;

import com.jasonv.vendingmachine.VendingMachine;

import junit.framework.TestCase;

/**
 * 	1)
 * As an employee of a soda company I would like to be able to stock it with
 * product. Done when I can stock the machine with product.
 **/
public class Story_1 extends TestCase
{
	public void test_simple()
	{
		VendingMachine vm = new VendingMachine();

		assertEquals(0,vm.getProduct("Coke").getCansInTube());
		vm.stock("Coke",10);
		assertEquals(10,vm.getProduct("Coke").getCansInTube());

		assertEquals(0,vm.getProduct("Pepsi").getCansInTube());
		vm.stock("Pepsi",10);
		assertEquals(10,vm.getProduct("Pepsi").getCansInTube());
		
		assertEquals(0,vm.getProduct("DrPepper").getCansInTube());
		vm.stock("DrPepper",10);
		assertEquals(10,vm.getProduct("DrPepper").getCansInTube());

	}
	
	public void test_should_say_one_coke_can_load_nine_spots_left()
	{
		VendingMachine vm = new VendingMachine();
		vm.stock("Coke",1);
		assertEquals("1 Coke loaded.\n9 spots left.",vm.getMessage());
	}

	public void test_should_say_full()
	{
		VendingMachine vm = new VendingMachine();
		vm.stock("Coke",10);
		assertEquals("The Coke tube is full.\n10 cans available.",vm.getMessage());
	}

	public void test_should_say_full_2()
	{
		VendingMachine vm = new VendingMachine();
		vm.stock("Coke",100);
		assertEquals("The Coke tube is full.\n10 cans available.",vm.getMessage());
	}

	public void test_should_say_full_3()
	{
		VendingMachine vm = new VendingMachine();
		vm.stock("Coke",1);
		vm.stock("Coke",1);
		vm.stock("Coke",1);
		vm.stock("Coke",1);
		vm.stock("Coke",1);
		vm.stock("Coke",1);
		vm.stock("Coke",1);
		vm.stock("Coke",1);
		vm.stock("Coke",1);
		vm.stock("Coke",1);
		assertEquals("The Coke tube is full.\n10 cans available.",vm.getMessage());
	}
	
}
