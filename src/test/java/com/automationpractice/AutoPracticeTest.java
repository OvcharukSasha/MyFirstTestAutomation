package com.automationpractice;

import com.automationpractice.pages.*;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.is;


    public class AutoPracticeTest {
    private WebDriver driver;



    @Before
    public void SetUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @After
    public void Close() {
        driver.close();
        // driver.quit();
    }

    @Test
    public void verifyThatWeCanOpenAutoPracticeWebPage() {

        HomePage homePage = new HomePage(driver);
driver.get(homePage.getURL());
        String actualURL = driver.getCurrentUrl();
        Assert.assertThat("This is not a" + homePage.getURL(), actualURL, is(homePage.getURL()));
    }

    @Test
    public void verifyThatLogoOnHomePageIsPresent() {
        HomePage homePage = new HomePage(driver);
        driver.get(homePage.getURL());
        boolean isPresent = homePage.logoIsPresent();
        if (isPresent) {
            Assert.assertThat(homePage.logoIsDisplayed(), is(true));
        } else {
            throw new NoSuchElementException("There is not such element");
        }
    }

    @Test
    public void verifyThatWeCanChooseWomenCategory() {
        SignIn signIn=new SignIn(driver);
        HomePage homePage = new HomePage(driver);
        WomenPage womenPage = new WomenPage(driver);
        driver.get(homePage.getURL());
        signIn.signInExistedProfile();

        homePage.womenCategoryButtonClick();
        womenPage.waitUntilWomenImgIsLoaded();
        Assert.assertEquals(womenPage.getURL(), driver.getCurrentUrl());
    }

    @Test
    public void AddItemToBucket() {
        WomenPage womenPage = new WomenPage(driver);
        BlousePage blousePage = new BlousePage(driver);
        OrderPage orderPage = new OrderPage(driver);
        driver.get(womenPage.getURL());

        womenPage.blouseClick();

        blousePage.waitUntilAddToCartButtonIsLoaded();
        blousePage.addToCartButtonClick();

        blousePage.closeWindowOnConfirmationFormClick();
        blousePage.myShoppingCartButtonClick();


        orderPage.waitUntilDescriptionsAboutProductsAreLoaded();


        boolean Is_inCart = false;
        for (String descriptionText : orderPage.getDescriptionsText()) {
            System.out.println(descriptionText+" == "+"Blouse");
            if (descriptionText.equals("Blouse")) {
                Is_inCart = true;
                break;
            }

        }
        Assert.assertEquals(true, Is_inCart);
    }




}



