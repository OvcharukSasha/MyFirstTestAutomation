package com.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class OrderPage {
    private WebDriver driver;
    @FindBy(xpath = "//tbody//td[@class='cart_description']//p[@class='product-name']/a")
    private List<WebElement>  descriptionsAboutProduct;



    public OrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);


    }
    public List<String> getDescriptionsText(){
        List<String> descriptions=new ArrayList<String>();
        for(WebElement descriptionElement: descriptionsAboutProduct){
            descriptions.add(descriptionElement.getText());
        }
        return descriptions;
    }

    public void waitUntilDescriptionsAboutProductsAreLoaded(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(descriptionsAboutProduct.get(0)));
    }

}
