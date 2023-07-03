package Tests;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class LoginTest {
    static AppiumBy loginMenu =new AppiumBy.ByAccessibilityId("Login");
    static AppiumBy usernameInputField =new AppiumBy.ByAccessibilityId("input-email");
    static AppiumBy passwordInputField =new AppiumBy.ByAccessibilityId("input-password");
    static AppiumBy loginButton =new AppiumBy.ByAccessibilityId("button-LOGIN");
    static By loginOkButton =new By.ById("android:id/button1");

    @Test
    public static void LoginFunctionTest() throws InterruptedException {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setPlatformVersion("11.0");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setDeviceName("Emulator");
        options.setAppPackage("com.wdiodemoapp");
        options.setAppActivity("com.wdiodemoapp.MainActivity");

        try {
            AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            Thread.sleep(2000);
            driver.findElement(loginMenu).click();
            driver.findElement(usernameInputField).sendKeys("username123@gmail.com");
            driver.findElement(passwordInputField).sendKeys("parola123!");
            driver.findElement(loginButton).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(loginOkButton));
            driver.findElement(loginOkButton).click();
            Thread.sleep(3000);
            driver.quit();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }
}

