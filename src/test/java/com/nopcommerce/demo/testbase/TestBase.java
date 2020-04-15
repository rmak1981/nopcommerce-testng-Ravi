package com.nopcommerce.demo.testbase;

import com.nopcommerce.demo.basepage.BasePage;
import com.nopcommerce.demo.browserselector.BrowserSelector;
import com.nopcommerce.demo.loadproperty.LoadProperty;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase extends BasePage {

    //object creation
    BrowserSelector browserSelector = new BrowserSelector();// object created for browser selector
    LoadProperty loadProperty = new LoadProperty(); // make object for loadproperty

    String baseURL = loadProperty.getProperty("baseURL");// initialize loadproperty object for baseurl
    String browser = loadProperty.getProperty("browser");// initialize laodproperty object for baseurl


    //open browser
    @BeforeMethod(groups = {"Regression","Sanity","Smoke"})
    public void openBrowser() {
        browserSelector.selectBrowser(browser);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseURL);
    }

    //close browser
    @AfterMethod(groups = {"Regression","Sanity","Smoke"})
    public void closeBrowser() {
        driver.quit();
    }

}
