package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SearchProducts {

    private WebDriver driver = new ChromeDriver();

    public void SearchProducts(String user, String pass) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");


        //this line below waits for up to 20 seconds for pages to load
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //set website
        driver.get("https://petstore.octoperf.com/");

        //click enter store button
        driver.findElement(By.linkText("Enter the Store")).click();

        //sign in to the website
        driver.findElement(By.linkText("Sign In")).click();
        driver.findElement(By.name("username")).sendKeys(user);
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(pass);
        driver.findElement(By.name("signon")).click();

        driver.findElement(By.name("keyword")).sendKeys("not-on-product-list");
        driver.findElement(By.name("searchProducts")).click();
        driver.findElement(By.name("keyword")).clear();
        driver.findElement(By.name("keyword")).sendKeys("dog");
        driver.findElement(By.name("searchProducts")).click();
        driver.findElement(By.linkText("Friendly dog from England")).click();
        driver.findElement(By.linkText("Add to Cart")).click();

        driver.findElement(By.linkText("Return to Main Menu")).click();
        driver.findElement(By.name("img_cart")).click();

        Thread.sleep(1000);
    }

    public WebDriver getDriver() {
        return driver;
    }
}
