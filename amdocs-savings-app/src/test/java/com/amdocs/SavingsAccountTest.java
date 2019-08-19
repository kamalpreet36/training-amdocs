package com.amdocs;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyDouble;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


public class SavingsAccountTest {
	
	private SavingsAccount account;
	private SavingsAccount accountSpy;
	
	@Before
	public void setUp() {
		account = new SavingsAccount();
		
		//partial mocking or spying
	    accountSpy = spy ( account );
	}

	@After
	public void tearDown() {
		account = null;
		accountSpy = null;
	}
	
	@Test
	public void testWithdrawWhencurrentbalanceIs5000INR() throws InSufficientBalanceException {
		
		//Stubbing - hard coding the response of getBalance method
		doReturn ( 5000.0 ).when ( accountSpy ).getBalance();
		doNothing().when( accountSpy ).updateBalanceIntoDB( anyDouble() );
		
		double updatedBalance = accountSpy.withdraw( 1000.0 );
		double expectedBalance = 4000.0;
		
		assertEquals( expectedBalance, updatedBalance, 0.0001 );
		
		verify( accountSpy, times(1) ).getBalance();
		
		verify( accountSpy, times(1) ).updateBalanceIntoDB( anyDouble() );
	}

	@Test
	public void testWithdrawWhencurrentbalanceIs5000Insufficient() {
		
		boolean exceptionThrown = false;
		//Stubbing - hard coding the response of getBalance method
		doReturn ( 500.0 ).when ( accountSpy ).getBalance();
		doNothing().when( accountSpy ).updateBalanceIntoDB( anyDouble() );
		
		try {
			accountSpy.withdraw( 10000.0 );
		} 
		catch( InSufficientBalanceException e) {
			exceptionThrown = true;
		}
		
		boolean expectedResponse = true;
		
		assertEquals( expectedResponse, exceptionThrown);
		
		verify( accountSpy, times(1) ).getBalance();
		
		verify( accountSpy, times(0) ).updateBalanceIntoDB( anyDouble() );
	}
	
}
