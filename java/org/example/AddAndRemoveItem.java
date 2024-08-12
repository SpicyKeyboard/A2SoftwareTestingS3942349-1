package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AddAndRemoveItem {

    private final WebDriver driver = new ChromeDriver();

        public void AddAndRemoveItem(String user, String pass) throws InterruptedException {
            System.setProperty("webdriver.chrome.driver","chromedriver.exe");

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

            //navigate to the dogs / cats and add one of each animal to the shopping cart
            driver.get("https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=DOGS");
            driver.findElement(By.linkText("K9-PO-02")).click();
            driver.findElement(By.linkText("Add to Cart")).click();
            driver.findElement(By.linkText("Return to Main Menu")).click();
            driver.get("https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=CATS");
            driver.findElement(By.linkText("FL-DSH-01")).click();
            driver.findElement(By.linkText("Add to Cart")).click();
            driver.findElement(By.linkText("Return to Main Menu")).click();

            //go to the shopping cart from main menu and then remove one item from shopping cart
            driver.findElement(By.name("img_cart")).click();
            driver.findElement(By.linkText("Remove")).click();

            //checkout item/s
            driver.findElement(By.linkText("Proceed to Checkout")).click();
            driver.findElement(By.name("newOrder")).click();
            driver.findElement(By.linkText("Confirm")).click();

            Thread.sleep(1000);
        }

    public WebDriver getDriver() {
        return driver;
    }
}
