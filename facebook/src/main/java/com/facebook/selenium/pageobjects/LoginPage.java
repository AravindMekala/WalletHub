package com.facebook.selenium.pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.facebook.selenium.commons.PageObject;




public class LoginPage  extends PageObject{
	private static Logger log = LoggerFactory.getLogger(LoginPage.class);
	

	@FindBy(xpath = "//input[@id='email']")
		private WebElement inputEmail;
	 
	 @FindBy(xpath = "//input[@id='pass']")
		private WebElement inputPassword;
	 
	 @FindBy(xpath = "//button[@name='login']")
		private WebElement loginButton;
	 
	 @FindBy(xpath = "//div/span[@class='a8c37x1j ni8dbmo4 stjgntxs l9j0dhe7']")
		private WebElement createPost;
	 
	 @FindBy(xpath = "//div/div[@class='_1mf _1mj']")
		private WebElement writePost;
	 
	 @FindBy(xpath = "//div[@class='ihqw7lf3 discj3wi l9j0dhe7']/div[2]/div")
		private WebElement postButton;
	 
	 public LoginPage(WebDriver driver) {
			super(driver);
		}
	 
	 /**
		 * Enters the user name into the input field.
		 * @param userName
		 */
	 public void enterEmail(String userName) {
			//this.inputEmail.clear();
			this.inputEmail.sendKeys(userName);
		}

		/**
		 * Enters the password into the input field.
		 * @param password
		 */
		public void enterPassword(String password) {
			this.inputPassword.clear();
			this.inputPassword.sendKeys(password);
		}
		
		public void submit() {
			loginButton.click();
	       	}
		
		public void clickonCreatePost() {
			new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(createPost));
			createPost.click();
		}
		
		public void enterPostText(String postText) {
			writePost.sendKeys(postText);
		}
		public void clickonPostButton() {
			postButton.click();
			log.info("Posted ");

		}
		
		}

