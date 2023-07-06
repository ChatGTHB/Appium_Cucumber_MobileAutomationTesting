package StepDefinitions;

import Pages.SwipePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.PageActionsHelper;

import java.time.Duration;

import static utilities.DriverManager.getAppiumDriver;

public class _02_SwipeSteps {
    WebDriverWait wait = new WebDriverWait(getAppiumDriver(), Duration.ofSeconds(20));
    SwipePage swipePage = new SwipePage();
    PageActionsHelper pageActionsHelper = new PageActionsHelper();

    @When("Navigate To Swipe Page")
    public void navigateToSwipePage(){
        getAppiumDriver().findElement(swipePage.swipeMenu).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(swipePage.swipePageText));
    }

    @And("Scroll Down")
    public void scrollDown() {
        pageActionsHelper.performScroll("down");
    }

    @Then("Logo Should Be Visible")
    public void logoShouldBeVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(swipePage.logo));
        Assert.assertTrue(getAppiumDriver().findElement(swipePage.logo).isDisplayed());
        if(getAppiumDriver().findElement(By.xpath("//*[@text='You found me!!!']")).isDisplayed()){
            System.out.println("I found you!");
        }
    }
}

