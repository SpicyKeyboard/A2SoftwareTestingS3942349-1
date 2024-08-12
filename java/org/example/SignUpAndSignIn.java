package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SignUpAndSignIn {

    private WebDriver driver = new ChromeDriver();

    public void SignUpAndSignIn(String user, String pass) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");

        //this line below waits for up to 20 seconds for pages to load
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //set website
        driver.get("https://petstore.octoperf.com/");

        //click enter store button
        driver.findElement(By.linkText("Enter the Store")).click();

        //navigate to register button
        driver.findElement(By.linkText("Sign In")).click();
        driver.findElement(By.linkText("Register Now!")).click();
        //input details into table fields
        driver.findElement(By.name("username")).sendKeys(user);
        driver.findElement(By.name("password")).sendKeys(pass);
        driver.findElement(By.name("repeatedPassword")).sendKeys(pass);
        driver.findElement(By.name("account.firstName")).sendKeys("fname");
        driver.findElement(By.name("account.lastName")).sendKeys("lname");
        driver.findElement(By.name("account.email")).sendKeys("email@email.com");
        driver.findElement(By.name("account.phone")).sendKeys("1111");
        driver.findElement(By.name("account.address1")).sendKeys("address");
        driver.findElement(By.name("account.city")).sendKeys("city");
        driver.findElement(By.name("account.state")).sendKeys("state");
        driver.findElement(By.name("account.zip")).sendKeys("1000");
        driver.findElement(By.name("account.country")).sendKeys("country");
        //complete account creation
        driver.findElement(By.name("newAccount")).click();

        //sign in to new account
        driver.findElement(By.linkText("Sign In")).click();
        driver.findElement(By.name("username")).sendKeys(user);
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(pass);
        driver.findElement(By.name("signon")).click();

        Thread.sleep(1000);
    }

    public WebDriver getDriver() {
        return driver;
    }
}
