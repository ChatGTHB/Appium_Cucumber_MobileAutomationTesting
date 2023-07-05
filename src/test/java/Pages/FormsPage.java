package Pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverManager;

public class FormsPage extends DriverManager {
    public FormsPage(){
        PageFactory.initElements(getAppiumDriver(),this);
    }

    // Dropdown Locators
    public AppiumBy formsButton = (AppiumBy) AppiumBy.accessibilityId("Forms");
    public AppiumBy dropdownButton = (AppiumBy) AppiumBy.accessibilityId("Dropdown");
    public By secondOption = By.xpath("//*[@text='Appium is awesome']");
    public By actualSelectedOption = By.xpath("//android.view.ViewGroup[@content-desc=\"Dropdown\"]/android.view.ViewGroup/android.widget.EditText");


    // Switch Locators
    public AppiumBy switchText = (AppiumBy) AppiumBy.accessibilityId("switch-text");
    public AppiumBy switchButton = (AppiumBy) AppiumBy.accessibilityId("switch");

}
