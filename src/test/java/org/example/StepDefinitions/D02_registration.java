package org.example.StepDefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


public class D02_registration {



    @And("user navigate to home page")
    public void navigate_home()
    {
        String url = "https://demo.nopcommerce.com/";
        Hooks.driver.navigate() .to(url);
    }

    @And("user click on register link")
    public void register_link()
    {

       Hooks.driver.findElement(By.className("ico-register")).click();
    }

    @And("user select gender type")
    public void genderType()
    {
        Hooks.driver.findElement(By.id("gender-male"));
    }



    @And("user fills your personal details with valid data")
    public void Personal_details()
    {
        Hooks.driver.findElement(By.id("FirstName")).sendKeys("Automation");
        Hooks.driver.findElement(By.id("LastName")).sendKeys("Tester");



    }

    @And("user selects date of birth")
    public void dateOfBirth()
    {
        //select day
        WebElement birthDay = Hooks.driver.findElement(By.name("DateOfBirthDay"));
        Select selectDay = new Select(birthDay);
        selectDay.selectByIndex(3);

        //select Month
        WebElement birthMonth = Hooks.driver.findElement(By.name("DateOfBirthMonth"));
        Select selectMonth = new Select(birthMonth);
        selectMonth.selectByVisibleText("November");

        //select year
        WebElement birthYear = Hooks.driver.findElement(By.name("DateOfBirthYear"));
        Select selectYear = new Select(birthYear);
        selectYear.selectByVisibleText("1991");

    }




    @And("user fills your password with valid data")
    public void Your_Email_Password_details()

    {
        Hooks.driver.findElement(By.name("Email")).sendKeys("ehab.abdalla090@gmail.com");
        Hooks.driver.findElement(By.id("Password")).sendKeys("P@ssw0rd");
        Hooks.driver.findElement(By.id("ConfirmPassword")).sendKeys("P@ssw0rd");
    }


   @And("user clicks on register button")
           public void register_button()
   {
       Hooks.driver.findElement(By.xpath("//button[contains(@name,\"register-butt\")]")).click();
   }

   @Then("success message is displayed")
   public void success_Message()
   {
      // Assert.assertTrue(driver.findElement(By.partialLinkText("Your registration completed")).isDisplayed());
       Assert.assertTrue(Hooks.driver.findElement(By.cssSelector("div[class=\"result\"]")).isDisplayed());

       SoftAssert soft = new SoftAssert();
       soft.assertTrue(Hooks.driver.findElement(By.cssSelector("div[class=\"result\"]")).isDisplayed());
       soft.assertTrue(Hooks.driver.getCurrentUrl().contains("https://demo.nopcommerce.com/registerresult/1?returnUrl=/"));
       soft.assertTrue(Hooks.driver.findElement(By.cssSelector("a[href=\"/customer/info\"][class=\"ico-account\"]")).isDisplayed());

       soft.assertAll();

   }


}

