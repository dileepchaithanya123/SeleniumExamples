package org.example;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Selenium_BrokenImage_Test {

    WebDriver driver;
    int invalidImageCount;

    @BeforeTest
    public void setUp() {

        System.setProperty("webdriver.gecko.driver", "C:\\Users\\dponnuru\\IdeaProjects\\SeleniumExamples\\src\\test\\Drivers\\Firefox\\geckodriver_71.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/broken_images");
    }

    @Test
    public void verifyBrokenImage()
    {
        invalidImageCount = 0;
        List<WebElement> imagesList = driver.findElements(By.tagName("img"));
        System.out.println("Total no. of images are " + imagesList.size());
        for (WebElement imgElement : imagesList) {
            if (imgElement != null) {
                verifyimageActive(imgElement);
            }
        }
        System.out.println("Total no. of invalid images are "	+ invalidImageCount);
    }

    public void verifyimageActive(WebElement imgElement) {
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(imgElement.getAttribute("src"));
            HttpResponse response = client.execute(request);
            // verifying response code he HttpStatus should be 200 if not,
            // increment as invalid images count
            if (response.getStatusLine().getStatusCode() != 200)
                invalidImageCount++;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }



}
