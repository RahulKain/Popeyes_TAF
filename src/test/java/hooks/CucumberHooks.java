package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.ConfigReader;

import java.time.Duration;
import java.util.Properties;

public class CucumberHooks {

    public static WebDriver driver;

    @Before
    public void setUp() {

        Properties config = ConfigReader.loadProperties("src/test/resources/config/config.properties");
        // Initialize WebDriver here, e.g., using ChromeDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(config.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
