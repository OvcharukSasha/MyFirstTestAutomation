package com.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    private WebDriver driver;
    private static final String HOME_PAGE_URL="http://automationpractice.com/index.php";



    @FindBy(xpath = "//*[@id=\"header_logo\"]/a/img")
    private WebElement logoImg;

    @FindBy(xpath = "//img[@class='logo img-responsive']")
    private List<WebElement> logoImgs;

    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[1]/a")
    private WebElement womenCategoryButton;

public HomePage(WebDriver driver){

    this.driver=driver;
    PageFactory.initElements(this.driver, this);

}
    public WebElement getLogoImg() {
        return logoImg;
    }


    public String  getURL() {
        return HOME_PAGE_URL;
    }





    public boolean logoIsPresent(){
        return logoImgs.size()>0;
    }

    public boolean logoIsDisplayed(){
    return logoImg.isDisplayed();
    }
    public void womenCategoryButtonClick(){
    womenCategoryButton.click();
    }
}
