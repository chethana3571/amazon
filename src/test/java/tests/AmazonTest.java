package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;

public class AmazonTest {
    public static void main(String[] args) {
        String[] browsers = {"chrome", "firefox", "edge"};  // lowercase names
        for (String browser : browsers) {
            try {
                DesiredCapabilities cap = new DesiredCapabilities();
                cap.setBrowserName(browser);

                WebDriver driver = new RemoteWebDriver(
                        new URL("http://localhost:4444/wd/hub"), cap
                );

                driver.get("https://www.amazon.com");
                System.out.println("Title on " + browser + ": " + driver.getTitle());

                driver.findElement(By.id("twotabsearchtextbox"))
                        .sendKeys("Selenium WebDriver");
                driver.findElement(By.id("nav-search-submit-button")).click();

                System.out.println("Search done on " + browser);

                driver.quit();
            } catch (Exception e) {
                System.out.println("Error on browser " + browser + ": " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
