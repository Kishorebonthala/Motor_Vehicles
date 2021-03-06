package com.selenium.pageobjects.vehicleinformation;

import com.scenarios.helpers.SysUtils;
import com.scenarios.model.Vehicle;
import com.selenium.pageobjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

import java.util.HashMap;
import java.util.Map;

public class VehicleDetailsView extends BasePage {

    private By listSummaryIdentifier = By.cssSelector("ul.list-summary");
    private By listSummaryItemIdentifier = By.cssSelector("li.list-summary-item");

    public VehicleDetailsView(WebDriver driver, Wait<WebDriver> waitItem) {
        super(driver, waitItem);
        SysUtils.log("Loading " + this.getClass().getName());
    }

    public VehicleDetailsView waitForLoad() {

        waitExplicit(By.cssSelector("h1.heading-large"), "Is this the vehicle you are looking for?");

        SysUtils.log("Waited for loading of " + this.getClass().getName());
        return this;
    }

    public Vehicle extractVehicleDetails() {

        Map<String, String> vehicle = new HashMap<>();

        extractVehicleDetailItem(vehicle, "Registration number");
        extractVehicleDetailItem(vehicle, "Make");
        extractVehicleDetailItem(vehicle, "Colour");
        return new Vehicle(vehicle);
    }

    private void extractVehicleDetailItem(Map<String, String> vehicle, final String itemText) {

        final String keyName = getKeyName(itemText);
        SysUtils.log("Retrieving car details : " + itemText);
        driver.findElement(listSummaryIdentifier)
              .findElements(listSummaryItemIdentifier)
              .stream()
              .filter(item -> item.findElements(By.cssSelector("span")).get(0).getText().contains(itemText))
              .findFirst()
              .ifPresent(found -> vehicle.put(keyName, found.findElements(By.cssSelector("span")).get(1).getText()));
    }

    private String getKeyName(final String itemText) {

        if (itemText.equals("Registration number")) {
            return "Registration number";
        } else if (itemText.equals("Make")) {
            return "make";
        } else if (itemText.equals("Colour")) {
            return "colour";
        }
        return "";
    }
}