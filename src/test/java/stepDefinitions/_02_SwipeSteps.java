package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.SwipePage;
import utilities.PageActionsHelper;

import java.time.Duration;
import java.util.List;

import static utilities.DriverManager.getAppiumDriver;

public class _02_SwipeSteps {

    WebDriverWait wait = new WebDriverWait(getAppiumDriver(), Duration.ofSeconds(20));
    SwipePage swipePage = new SwipePage();
    PageActionsHelper pageActionsHelper = new PageActionsHelper();

    @When("Navigate To Swipe Page")
    public void navigateToSwipePage() {
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
        if (getAppiumDriver().findElement(By.xpath("//*[@text='You found me!!!']")).isDisplayed()) {
            System.out.println("I found you!");
        }
    }

    @And("Scroll Right")
    public void scrollRight() {
        List<WebElement> listOfbuttons = getAppiumDriver().findElements(swipePage.allButtons);
        for (int i = 0; i < listOfbuttons.size(); i++) {
            pageActionsHelper.performScroll("right");
        }
    }

    @Then("Last Element Should Be Visible")
    public void lastElementShouldBeVisible() {
        Assert.assertTrue(getAppiumDriver().findElement(swipePage.lastElement).isDisplayed());
    }
}
