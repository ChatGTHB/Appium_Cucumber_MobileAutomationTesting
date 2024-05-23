package pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverManager;

public class SwipePage extends DriverManager {
    public AppiumBy swipeMenu = (AppiumBy) AppiumBy.accessibilityId("Swipe");
    public By swipePageText = By.xpath("//*[@text='Swipe horizontal']");
    public AppiumBy logo = (AppiumBy) AppiumBy.accessibilityId("WebdriverIO logo");
    public By allButtons = By.xpath("//android.view.ViewGroup[@content-desc=\"Carousel\"]/android.view.ViewGroup/android.view.ViewGroup");
    public By lastElement = By.xpath("//*[@text='COMPATIBLE']");
    public SwipePage() {
        PageFactory.initElements(getAppiumDriver(), this);
    }
}
