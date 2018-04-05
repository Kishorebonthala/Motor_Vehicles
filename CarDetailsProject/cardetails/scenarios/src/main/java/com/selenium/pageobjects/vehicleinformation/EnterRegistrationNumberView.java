package com.selenium.pageobjects.vehicleinformation;

import com.scenarios.helpers.SysUtils;
import com.selenium.pageobjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;


public class EnterRegistrationNumberView extends BasePage {

    private By registrationNumberInput = By.cssSelector("input#Vrm");
    private By continueBtn = By.cssSelector("button[name='Continue']");

    public EnterRegistrationNumberView(WebDriver driver, Wait<WebDriver> waitItem){
        super(driver, waitItem);
        SysUtils.log("Loading " + this.getClass().getName());
    }

    public EnterRegistrationNumberView waitForLoad(){
        waitExplicit(By.cssSelector("h1.heading-large"), "Enter the registration number of the vehicle");
        SysUtils.log("Waited for loading of  " + this.getClass().getName());
        return this;
    }

    public void searchRegistrationNumber(String registrationNumber){
        SysUtils.log("Searching Vehicle registration Number " + registrationNumber);
        driver.findElement(registrationNumberInput).sendKeys(registrationNumber);
        driver.findElement(continueBtn).click();
    }

}
