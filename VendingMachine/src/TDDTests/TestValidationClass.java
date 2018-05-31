package TDDTests;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import GlobalConstants.ConstantsClass;
import VendingMachine.MachineClass;

public class TestValidationClass {
	  private MachineClass machine;

	    @Before
	    public void setUp() {
	    	machine = new MachineClass();
	    }

	    @Test
	    public void displayShowsInsertCoinWhenEmpty() {
	        Assert.assertTrue("INSERT COIN when no coins have been inserted", machine.display().equals("INSERT COIN"));
	    }

	    @Test
	    public void acceptsQuarter() {
	    	machine.accept(ConstantsClass.QUARTER);
	        Assert.assertTrue("should display amount of quarter inserted.", machine.display().equals("0.25"));
	    }

	    @Test
	    public void acceptsDime() {
	        machine.accept(ConstantsClass.DIME);
	        Assert.assertTrue("should display amount of dime inserted.", machine.display().equals("0.10"));
	    }

	    @Test
	    public void acceptsNickel() {
	        machine.accept(ConstantsClass.NICKEL);
	        Assert.assertTrue("should display amount of nickel inserted.", machine.display().equals("0.05"));
	    }

	    @Test
	    public void acceptsMultipleValidCoins() {
	        machine.accept(ConstantsClass.QUARTER);
	        machine.accept(ConstantsClass.DIME);
	        machine.accept(ConstantsClass.NICKEL);
	        Assert.assertTrue("should display amount of cents inserted.", machine.display().equals("0.40"));
	    }

	    @Test
	    public void doesNotAcceptInvalidCoins() {
	        machine.accept(ConstantsClass.PENNY);
	        Assert.assertTrue(" INSERT COIN because there are none.", machine.display().equals("INSERT COIN"));
	    }

	    @Test
	    public void acceptsValidAndRejectsInvalidCoins() {
	        machine.accept(ConstantsClass.PENNY);
	        machine.accept(ConstantsClass.QUARTER);
	        machine.accept(ConstantsClass.PENNY);
	        machine.accept(ConstantsClass.DIME);
	        machine.accept(ConstantsClass.NICKEL);
	        Assert.assertTrue("should display amount of cents inserted.", machine.display().equals("0.40"));
	    }

	    @Test
	    public void colaIsDispensedWithCorrectAmount() {
	        machine.accept(ConstantsClass.QUARTER);
	        machine.accept(ConstantsClass.QUARTER);
	        machine.accept(ConstantsClass.QUARTER);
	        machine.accept(ConstantsClass.QUARTER);
	        machine.selectProduct(ConstantsClass.COLA);
	        Assert.assertTrue("should display THANK YOU after vending", machine.display().equals("THANK YOU"));
	        Assert.assertTrue("should display INSERT COIN after display of THANK YOU", machine.display().equals("INSERT COIN"));
	    }

	    @Test
	    public void chipsIsDispensedWithCorrectAmount() {
	        machine.accept(ConstantsClass.QUARTER);
	        machine.accept(ConstantsClass.QUARTER);
	        machine.selectProduct(ConstantsClass.CHIPS);
	        Assert.assertTrue("should display THANK YOU after vending", machine.display().equals("THANK YOU"));
	        Assert.assertTrue("should display INSERT COIN after display of THANK YOU", machine.display().equals("INSERT COIN"));
	    }

	    @Test
	    public void candyIsDispensedWithCorrectAmount() {
	        machine.accept(ConstantsClass.QUARTER);
	        machine.accept(ConstantsClass.QUARTER);
	        machine.accept(ConstantsClass.DIME);
	        machine.accept(ConstantsClass.NICKEL);
	        machine.selectProduct(ConstantsClass.CANDY);
	        Assert.assertTrue("should display THANK YOU after vending", machine.display().equals("THANK YOU"));
	        Assert.assertTrue("should display INSERT COIN after display of THANK YOU", machine.display().equals("INSERT COIN"));
	    }

	    @Test
	    public void displayIsCorrectWhenProductIsSelectedButLacksFunds() {
	        machine.accept(ConstantsClass.QUARTER);
	        machine.accept(ConstantsClass.QUARTER);
	        machine.selectProduct(ConstantsClass.CANDY);
	        Assert.assertTrue("should display PRICE after vending", machine.display().equals("PRICE 0.65"));
	    }

	    @Test
	    public void displayIsCorrectWhenProductIsSelectedButLacksFundsAndMoreCoinsAreInserted() {
	        machine.accept(ConstantsClass.QUARTER);
	        machine.accept(ConstantsClass.QUARTER);
	        machine.selectProduct(ConstantsClass.CANDY);
	        Assert.assertTrue("should display PRICE after vending", machine.display().equals("PRICE 0.65"));
	        machine.accept(ConstantsClass.DIME);
	        machine.accept(ConstantsClass.NICKEL);
	        Assert.assertTrue("should display THANK YOU after vending", machine.display().equals("THANK YOU"));
	        Assert.assertTrue("should display INSERT COIN after display of PRICE", machine.display().equals("INSERT COIN"));
	    }

	    @Test
	    public void retrieveChangeAfterColaPurchase() {
	        machine.accept(ConstantsClass.QUARTER);
	        machine.accept(ConstantsClass.QUARTER);
	        machine.accept(ConstantsClass.QUARTER);
	        machine.accept(ConstantsClass.QUARTER);
	        machine.accept(ConstantsClass.DIME);
	        machine.selectProduct(ConstantsClass.COLA);
	        Assert.assertTrue("should display THANK YOU after vending", machine.display().equals("THANK YOU"));
	        Assert.assertTrue("should display INSERT COIN after display of THANK YOU", machine.display().equals("INSERT COIN"));
	        Assert.assertTrue("should return proper change", machine.retrieveChange().equals("0.10"));
	    }

	    @Test
	    public void retrieveChangeAfterChipsPurchase() {
	        machine.accept(ConstantsClass.QUARTER);
	        machine.accept(ConstantsClass.QUARTER);
	        machine.accept(ConstantsClass.QUARTER);
	        machine.accept(ConstantsClass.DIME);
	        machine.selectProduct(ConstantsClass.CHIPS);
	        Assert.assertTrue("should display THANK YOU after vending", machine.display().equals("THANK YOU"));
	        Assert.assertTrue("should display INSERT COIN after display of THANK YOU", machine.display().equals("INSERT COIN"));
	        Assert.assertTrue("should return proper change", machine.retrieveChange().equals("0.35"));
	    }

	    @Test
	    public void retrieveChangeAfterCandyPurchase() {
	        machine.accept(ConstantsClass.NICKEL);
	        machine.accept(ConstantsClass.QUARTER);
	        machine.accept(ConstantsClass.NICKEL);
	        machine.accept(ConstantsClass.QUARTER);
	        machine.accept(ConstantsClass.DIME);
	        machine.accept(ConstantsClass.DIME);
	        machine.selectProduct(ConstantsClass.CANDY);
	        Assert.assertTrue("should display THANK YOU after vending", machine.display().equals("THANK YOU"));
	        Assert.assertTrue("should display INSERT COIN after display of THANK YOU", machine.display().equals("INSERT COIN"));
	        Assert.assertTrue("should return proper change", machine.retrieveChange().equals("0.15"));
	    }

	    @Test
	    public void coinsAreReturned() {
	        machine.accept(ConstantsClass.NICKEL);
	        machine.accept(ConstantsClass.QUARTER);
	        machine.accept(ConstantsClass.NICKEL);
	        machine.accept(ConstantsClass.QUARTER);
	        machine.accept(ConstantsClass.DIME);
	        machine.accept(ConstantsClass.DIME);
	        Assert.assertTrue("should display amount of change inserted.", machine.display().equals("0.80"));
	        machine.returnCoins();
	        Assert.assertTrue("should display INSERT COIN after coins are returned", machine.display().equals("INSERT COIN"));
	    }

	    @Test
	    public void coinsAreReturnedAfterProductIsSelected() {
	        machine.accept(ConstantsClass.NICKEL);
	        machine.selectProduct(ConstantsClass.CANDY);
	        Assert.assertTrue("should display PRICE after vending", machine.display().equals("PRICE 0.65"));
	        machine.returnCoins();
	        Assert.assertTrue("should display INSERT COIN after coins are returned", machine.display().equals("INSERT COIN"));
	    }

	    

	  

	    @Test
	    public void machineDisplaysExactChangeOnly() {
	       MachineClass machine = new MachineClass(true);
	        Assert.assertTrue(" EXACT CHANGE ONLY since machine has no change to return", machine.display().equals("EXACT CHANGE ONLY"));
	    }

}
