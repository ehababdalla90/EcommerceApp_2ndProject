package org.example.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class D03_ChangeCurrency {
    @Given("user navigate to home")
    public void navigate_home()
    {
        String url = "https://demo.nopcommerce.com/";
        Hooks.driver.navigate() .to(url);
    }
    @And("logged user choose Euro from dropdown menu")
    public void changeCurrency()
    {
        WebElement webElement = Hooks.driver.findElement(By.id("customerCurrency"));
        Select selectCurrency = new Select(webElement);
        selectCurrency.selectByVisibleText("Euro");

    }
    @And("loop in all products that has Euro sign")
    public void loopProductWithEuroSign()
    {
        int count = Hooks.driver.findElements(By.className("priceactual-price")).size();
        for (int x = 0;x<count;x++)
        {
            String text = Hooks.driver.findElements(By.className("priceactual-price")).get(x).getText();
            Assert.assertTrue(text.contains("€"));
        }
    }



}
