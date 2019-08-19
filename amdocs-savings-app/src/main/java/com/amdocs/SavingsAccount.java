package com.amdocs;

public class SavingsAccount {

	public double getBalance() {
		System.out.println("Assume balance is retrieved from database");
		return 7000.0;
	}
	
	public double withdraw ( double amountToBeWithdrawn ) throws InSufficientBalanceException {
		System.out.println("Inside Withdraw method");
		
		double currentBalance = getBalance();
		
		if( amountToBeWithdrawn < currentBalance )
			currentBalance = currentBalance - amountToBeWithdrawn;
		else
			throw new InSufficientBalanceException();
				
		updateBalanceIntoDB( currentBalance );
		
		return currentBalance;
	}
	
	
	public void updateBalanceIntoDB ( double currentBalance ) {
		System.out.println("Assume here balance is updated into database ");
	}
}
