package com.automationpractice.pages;

        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.FindBy;
        import org.openqa.selenium.support.PageFactory;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.WebDriverWait;

public class BlousePage {
    private WebDriver driver;

    @FindBy(xpath = "//div[@class='box-cart-bottom']//button")
    private WebElement addToCartButton;

    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]")
    private WebElement confirmationForm;

    @FindBy(xpath = "//span[@title='Close window']")
    private WebElement closeWindowOnConfirmationForm;

    @FindBy(xpath = "//a[@title='View my shopping cart']")
    private WebElement myShoppingCartButton;

    public BlousePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
    public void waitUntilAddToCartButtonIsLoaded(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(addToCartButton));
    }

    public void addToCartButtonClick(){
        addToCartButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(confirmationForm));

    }

    public void closeWindowOnConfirmationFormClick(){
        closeWindowOnConfirmationForm.click();
    }
    public void myShoppingCartButtonClick(){
        myShoppingCartButton.click();
    }



}
