package org.example.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.testng.Assert;

public class D01_Login {
    @Given("user navigate to log in page")
    public void navigateLoginPage()
    {
        String url = "https://demo.nopcommerce.com/login?returnUrl=%2F/";
        Hooks.driver.navigate() .to(url);
    }
    @And ("get current url")
    public void getCurrentUrl()
    {
        String currentUrl = Hooks.driver.getCurrentUrl();
        Assert.assertEquals(currentUrl,"https://demo.nopcommerce.com/login?returnUrl=%2F/");
    }

    @And("user click on log in link")
    public void loginLink()
    {

        Hooks.driver.findElement(By.className("ico-login")).click();
    }
    @And("user fills email with valid data")
    public void Personal_Email()
    {
        Hooks.driver.findElement(By.name("Email")).sendKeys("ehab.abdalla090@gmail.com");

    }
    @And("user fills  password with valid data")
    public void Your_Password_details()

    {
        Hooks.driver.findElement(By.id("Password")).sendKeys("P@ssw0rd");

    }

    @And("user clicks on log in button")
    public void LoginButton() throws InterruptedException {
        Hooks.driver.findElement(By.cssSelector("button[class=\"button-1 login-button\"]")).click();
        Hooks.driver.getCurrentUrl();
        System.out.println("current url :"+Hooks.driver.getCurrentUrl());
        Thread.sleep(4000);
    }

//    @And("assert my account is displayed")
//    public void assertMyAccountIsDisplayed()
//    {
//        Hooks.driver.getCurrentUrl();
//        System.out.println("current url :"+Hooks.driver.getCurrentUrl());
//
////        boolean isMyAccountIsDisplayed = Hooks.driver.findElement(By.className("ico-account")).isDisplayed();
////        Assert.assertTrue(isMyAccountIsDisplayed);
//    }

}
