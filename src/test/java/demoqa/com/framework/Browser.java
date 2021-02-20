package demoqa.com.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {
    WebDriver driver;

    public WebDriver setUp(String browser) {

        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "gecko":
                System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            default:
                System.out.println("No suitable driver found");
                break;

        }

        return driver;
    }
}
