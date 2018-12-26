package com.automationpractice.pages;

        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.FindBy;
        import org.openqa.selenium.support.PageFactory;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.WebDriverWait;

public class WomenPage {
    private static final String WOMEN_PAGE_URL = "http://automationpractice.com/index.php?id_category=3&controller=category";
    private WebDriver driver;
    @FindBy(xpath = "//div[@class='content_scene_cat_bg']")
    private WebElement womenImg;

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[2]/div/div[1]/div/a[1]/img")
    private WebElement blouse;

    public WomenPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);


    }
    public void waitUntilWomenImgIsLoaded(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(womenImg));
    }
    public String getURL(){
        return WOMEN_PAGE_URL;
    }
    public void blouseClick(){
        blouse.click();
    }
}
