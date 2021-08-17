package com.facebook;

import org.testng.annotations.Test;

import com.facebook.selenium.commons.ParameterizedTest;
import com.facebook.selenium.pageobjects.LoginPage;

public class PostStatus extends ParameterizedTest{
	
	String postText= "Hello WalletHub Team";

	
	
	
	 //Main class to run test case or can run from TestNG XML
  @Test(priority = 0)
  public void postingStatus() {
	  LoginPage loginPage = new LoginPage(driver);
	  loginPage.clickonCreatePost();
	  loginPage.enterPostText(postText);
	//  loginPage.clickonPostButton();
	    
  }
  
}
