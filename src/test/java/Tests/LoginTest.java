package Tests;

import Pages.FormsPage;
import Pages.LoginPage;
import Pages.SwipePage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import utilities.DriverManager;
import java.time.Duration;
import java.util.Collections;

public class LoginTest extends DriverManager {

    AndroidDriver driver;
    WebDriverWait wait;
    static LoginPage loginPage=new LoginPage();
    static FormsPage formsPage=new FormsPage();
    static SwipePage swipePage=new SwipePage();

    @BeforeTest
    public void setUp(){

        driver = getAppiumDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test
    public static void LoginFunctionTest() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(getAppiumDriver(), Duration.ofSeconds(20));
        Thread.sleep(2000);

        getAppiumDriver().findElement(loginPage.loginMenu).click();

        getAppiumDriver().findElement(loginPage.usernameInputField).sendKeys("username123@gmail.com");
        getAppiumDriver().findElement(loginPage.passwordInputField).sendKeys("parola123!");

        getAppiumDriver().findElement(loginPage.loginButton).click();

        String actualText=wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.successfulLoginMessage)).getText();
        System.out.println(actualText);
        Assert.assertEquals(actualText,"You are logged in!");

        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.loginOkButton));
        getAppiumDriver().findElement(loginPage.loginOkButton).click();

        Thread.sleep(3000);
    }

    @Test
    public static void Dropdown(){

        getAppiumDriver().findElement(formsPage.formsButton).click();

        getAppiumDriver().findElement(formsPage.dropdownButton).click();

        getAppiumDriver().findElement(formsPage.secondOption).click();

        System.out.println("Selected option is = " + getAppiumDriver().findElement(formsPage.actualSelectedOption).getText());
        getAppiumDriver().findElement(formsPage.dropdownButton).click();

        String isSelected = getAppiumDriver().findElement(formsPage.secondOption).getAttribute("checked");

        Assert.assertEquals(isSelected,"true");
        System.out.println("Is element selected = " + isSelected);
    }

    @Test
    public static void Switch(){

        getAppiumDriver().findElement(formsPage.formsButton).click();

        String switchTextBeforeClick = getAppiumDriver().findElement(formsPage.switchText).getText();
        getAppiumDriver().findElement(formsPage.formsButton).click();

        Assert.assertEquals(switchTextBeforeClick, "Click to turn the switch ON");
        System.out.println("Switch Text Before Click= " + switchTextBeforeClick);

        getAppiumDriver().findElement(formsPage.switchButton).click();
        String switchTextAfterClick = getAppiumDriver().findElement(formsPage.switchText).getText();

        Assert.assertEquals(switchTextAfterClick, "Click to turn the switch OFF");
        System.out.println("Switch Text After Click = " + switchTextAfterClick);
    }

    @Test
    public void ScrollDown(){

        getAppiumDriver().findElement(swipePage.swipeMenu).click();

        Dimension size=getAppiumDriver().manage().window().getSize();

        int startX=size.getWidth()/2;
        int endX=startX;

        int startY= (int) (size.getHeight()*0.8);
        int endY= (int) (size.getHeight()*0.1);

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");

        Sequence sequence = new Sequence(finger1, 0)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(200)))
                .addAction(finger1.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), endX, endY))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        getAppiumDriver().perform(Collections.singletonList(sequence));
    }

    @Test
    public void ScrollToRight(){

        getAppiumDriver().findElement(swipePage.swipeMenu).click();

        Dimension size=getAppiumDriver().manage().window().getSize();

        int startX=size.getWidth()/2;
        int endX=startX;

        int startY= (int) (size.getHeight()*0.8);
        int endY= (int) (size.getHeight()*0.1);

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");

        Sequence sequence = new Sequence(finger1, 0)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(200)))
                .addAction(finger1.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), endX, endY))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        getAppiumDriver().perform(Collections.singletonList(sequence));
    }

    @AfterTest
    public void tearDown(){

        if(driver!=null){
            getAppiumDriver().quit();
        }
    }
}

