package com.amdocs;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {

	private String soapWSDLURL;
	private String rpnMathExpression;
	private double actualResult;
	
	@Given("I have deployed the RPNCalculator SOAP api at URL {string}")
	public void igetSoapWSDLUrl(String wsdlUrl) {
	   
	}

	@Given("the input is {string}")
	public void setInput(String string) {
	    this.rpnMathExpression = rpnMathExpression;
	}

	@When("I invoke the SOAP API")
	public void invokeRPNCalculatorSOAPAPI() {
	    RPNCalculatorService rpnWebService = new RPNCalculatorService();
	    RPNCalculator rpnCalculator = rpnWebService.getRPNCalculator();
	    
	    actualResult = rpnCalculator.evaluate( rpnMathExpression );
	}

	@Then("I expect the response as {string}")
	public void VerifyResult(String strExpectedResult) {
		double expectedResult = Double.parseDouble( strExpectedResult );
	   assertEquals ( expectedResult, actualResult, 0.001);
	}

}
