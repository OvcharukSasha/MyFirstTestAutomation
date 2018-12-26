package com.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignIn {
    private WebDriver driver;
    private  final String PASSWORD="Sashaooo";
    private final String EMAIL="Sashaooo@gmail.com";


    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
    private WebElement signInButton;

    public SignIn(WebDriver driver){
        System.out.println(driver.getCurrentUrl());
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public void signInExistedProfile(){
        signInButton.click();
        System.out.println("click");
LoginPage loginPage=new LoginPage(driver);
loginPage.emailInputSendKeys(EMAIL);
loginPage.passwordInputSendKeys(PASSWORD);
loginPage.submitSignInButtonClick();


    }
}
