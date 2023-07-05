package Tests;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.DriverManager;
import java.time.Duration;

public class LoginTest extends DriverManager {

    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void setUp(){
        driver = getAppiumDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test(priority = 1)
    public static void LoginFunctionTest() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(getAppiumDriver(), Duration.ofSeconds(20));
        Thread.sleep(2000);

        AppiumBy loginMenu =new AppiumBy.ByAccessibilityId("Login");

        AppiumBy passwordInputField =new AppiumBy.ByAccessibilityId("input-password");
        getAppiumDriver().findElement(loginMenu).click();

        AppiumBy usernameInputField =new AppiumBy.ByAccessibilityId("input-email");
        getAppiumDriver().findElement(usernameInputField).sendKeys("username123@gmail.com");
        getAppiumDriver().findElement(passwordInputField).sendKeys("parola123!");

        AppiumBy loginButton =new AppiumBy.ByAccessibilityId("button-LOGIN");
        getAppiumDriver().findElement(loginButton).click();

        By successfulLoginMessage=By.id("android:id/message");
        String actualText=wait.until(ExpectedConditions.visibilityOfElementLocated(successfulLoginMessage)).getText();
        System.out.println(actualText);
        Assert.assertEquals(actualText,"You are logged in!");

        By loginOkButton =By.id("android:id/button1");
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginOkButton));
        getAppiumDriver().findElement(loginOkButton).click();

        Thread.sleep(3000);
    }

    @Test(priority = 3)
    public static void Dropdown(){
        AppiumBy formsButton = (AppiumBy) AppiumBy.accessibilityId("Forms");
        getAppiumDriver().findElement(formsButton).click();
        AppiumBy dropdownButton = (AppiumBy) AppiumBy.accessibilityId("Dropdown");
        getAppiumDriver().findElement(dropdownButton).click();
        By secondOption = By.xpath("//*[@text='Appium is awesome']");
        getAppiumDriver().findElement(secondOption).click();
        By actualSelectedOption = By.xpath("//android.view.ViewGroup[@content-desc=\"Dropdown\"]/android.view.ViewGroup/android.widget.EditText");
        System.out.println("Selected option is = " + getAppiumDriver().findElement(actualSelectedOption).getText());
        getAppiumDriver().findElement(dropdownButton).click();
        String isSelected = getAppiumDriver().findElement(secondOption).getAttribute("checked");
        Assert.assertEquals(isSelected,"true");
        System.out.println("Is element selected = " + isSelected);
    }

    @Test(priority=2)
    public static void Switch(){

        AppiumBy formsButton = (AppiumBy) AppiumBy.accessibilityId("Forms");
        getAppiumDriver().findElement(formsButton).click();

        AppiumBy switchText = (AppiumBy) AppiumBy.accessibilityId("switch-text");
        String switchTextBeforeClick = getAppiumDriver().findElement(switchText).getText();
        Assert.assertEquals(switchTextBeforeClick, "Click to turn the switch ON");
        System.out.println("Switch Text Before Click= " + switchTextBeforeClick);

        AppiumBy switchButton = (AppiumBy) AppiumBy.accessibilityId("switch");
        getAppiumDriver().findElement(switchButton).click();

        String switchTextAfterClick = getAppiumDriver().findElement(switchText).getText();
        Assert.assertEquals(switchTextAfterClick, "Click to turn the switch OFF");
        System.out.println("Switch Text After Click = " + switchTextAfterClick);
    }
    @AfterTest
    public void tearDown(){
        if(driver!=null){
            getAppiumDriver().quit();
        }
    }
}

