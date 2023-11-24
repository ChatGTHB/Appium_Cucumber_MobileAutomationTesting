package stepDefinitions;

import pages.DragPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.PageActionsHelper;

import java.time.Duration;

import static utilities.DriverManager.getAppiumDriver;

public class _04_DragSteps {
    WebDriverWait wait = new WebDriverWait(getAppiumDriver(), Duration.ofSeconds(20));
    DragPage dragPage = new DragPage();
    PageActionsHelper pageActionsHelper = new PageActionsHelper();

    @When("Navigate To Drag Page")
    public void navigateToDragPage() {
        getAppiumDriver().findElement(dragPage.dragMenu).click();
    }

    @When("User Completes Drag And Drop")
    public void userCompletesDragAndDrop() {
        pageActionsHelper.dragAndDrop();
    }

    @Then("Success Message Should Display")
    public void successMessageShouldDisplay() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(dragPage.successMessage));
        getAppiumDriver().findElement(dragPage.retryButton).click();
        Thread.sleep(3000);
    }
}
