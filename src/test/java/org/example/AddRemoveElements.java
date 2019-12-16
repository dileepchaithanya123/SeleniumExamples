package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddRemoveElements extends OpenBrowser {

    @BeforeTest
    public void setUp() {

        openFireFoxBrowser();
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
    }

    @Test
    public void verifyElementIsAdded() {

        driver.findElement(By.xpath("//*[@id=\"content\"]/div/button[text()='Add Element']")).click();

        //Explicit Wait Condition
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='elements']/button")));
        boolean status = ele.isDisplayed();
        if (status)
        {
            System.out.println("Button is added");
        }
        else
        {
            System.out.println("Button is not Added");
        }

        deleteButton();
    }

    public void deleteButton()
    {
        driver.findElement(By.xpath("//div[@id='elements']/button")).click();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        boolean status = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='elements']/button")));
        if (status)
        {
            System.out.println("Delete Button is removed");
        }
        else
        {
            System.out.println("Delete Button is not removed");
        }
    }

    @AfterTest
    void closeBrowser() {
        driver.quit();
    }

}
