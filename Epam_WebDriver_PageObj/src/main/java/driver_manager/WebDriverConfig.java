package driver_manager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import sun.plugin2.util.BrowserType;

public class WebDriverConfig {
    public static ChromeOptions configChrome(){
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        options.setCapability(CapabilityType.BROWSER_NAME, BrowserType.DEFAULT);
        options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

        return options;
    }
}
