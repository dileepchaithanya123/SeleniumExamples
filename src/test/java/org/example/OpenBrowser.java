package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class  OpenBrowser {
     WebDriver driver;

     public void openFireFoxBrowser() {
         System.setProperty("webdriver.gecko.driver", "C:\\Users\\dponnuru\\IdeaProjects\\SeleniumExamples\\src\\test\\Drivers\\Firefox\\geckodriver_71.exe");
         driver = new FirefoxDriver();
         driver.manage().window().maximize();
     }

     public void openChromeBrowser() {

         System.setProperty("webdriver.gecko.driver", "C:\\Users\\dponnuru\\IdeaProjects\\SeleniumExamples\\src\\test\\Drivers\\Chrome\\chromedriver_78.exe");
         driver = new ChromeDriver();
         driver.manage().window().maximize();

     }
}
