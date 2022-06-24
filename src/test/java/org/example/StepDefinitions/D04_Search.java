package org.example.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.testng.Assert;

public class D04_Search {
    @Given("user navigates to the website")
    public void navigateLoginPage() {
        String url = "https://demo.nopcommerce.com/";
        Hooks.driver.navigate().to(url);
    }


    @And("^user search on \"(.*)\" in search box text field$")
    public void userSearchOnSearchBoxTextField(String product) {
        Hooks.driver.findElement(By.id("small-searchterms")).sendKeys(product);
        Hooks.driver.findElement(By.cssSelector("button[class=\"button-1 search-box-button\"]")).click();

    }

    @And("^user could find relative \"(.*)\" results$")
    public void findRelativeProducts(String product) {
        int count = Hooks.driver.findElements(By.className("product-title")).size();
        System.out.println(count);
        for (int x = 0; x < count; x++) {
            String text = Hooks.driver.findElements(By.className("product-title")).get(x).getText();
            Assert.assertTrue(text.contains(product));
        }

    }

//        @And("^user could search by using productSku \"(.*)\" result$")
//        public void searchByUsingSku(String productSku) {
//            int numOfProducts = Hooks.driver.findElements(By.className("product-title")).size();
//            System.out.println(numOfProducts);
//            Assert.assertEquals(numOfProducts,1);
//            String url = "https://demo.nopcommerce.com/search";
//            System.out.println(Hooks.driver.getCurrentUrl());
//            Assert.assertTrue(Hooks.driver.getCurrentUrl().contains(url));
//            ArrayList<String> productResults = new ArrayList();
//            for (int x=0 ; x<numOfProducts;x++)
//            {
//                System.out.println(Hooks.driver.findElements(By.className("product-title")).get(x).getText());
//                productResults.add(Hooks.driver.findElements(By.className("product-title")).get(x).getText());
//
//            }
//            System.out.println(productResults);
//
////            Hooks.driver.findElement(By.className("product-title")).click();
////            String actual = Hooks.driver.findElement(By.cssSelector("div[class=\"sku\"]span[class=\"value\"]")).getText();
////            Assert.assertTrue(actual.contains(productSku),"Right product founded");
//
//
//            }
        }






