package stepDefinitions;

import pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static utilities.DriverManager.getAppiumDriver;

public class _01_LoginSteps {
    WebDriverWait wait = new WebDriverWait(getAppiumDriver(), Duration.ofSeconds(20));
    LoginPage loginPage = new LoginPage();

    @Given("Open Application")
    public void openApplication(){
        getAppiumDriver();
    }

    @When("Navigate To Login Page")
    public void navigateToLoginPage() {
        getAppiumDriver().findElement(loginPage.loginMenu).click();
    }

    @And("Enter Valid Credentials And Click Login Button")
    public void enterValidCredentialsAndClickLoginButton() {
        getAppiumDriver().findElement(loginPage.usernameInputField).sendKeys("username123@gmail.com");
        getAppiumDriver().findElement(loginPage.passwordInputField).sendKeys("parola123!");
        getAppiumDriver().findElement(loginPage.loginButton).click();
    }

    @Then("User Should Login Successfully")
    public void userShouldLoginSuccessfully() {
        String actualText = wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.successfulLoginMessage)).getText();
        System.out.println("Login message = " + actualText);
        Assert.assertEquals(actualText, "You are logged in!");
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.loginOkButton));
        getAppiumDriver().findElement(loginPage.loginOkButton).click();
    }
}
