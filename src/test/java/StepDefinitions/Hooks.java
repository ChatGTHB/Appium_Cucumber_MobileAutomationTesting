package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.DriverManager;

import static utilities.DriverManager.getAppiumDriver;

public class Hooks {
    @Before
    public void before(){
        System.out.println("Scenario started");
    }

    @After
    public void after(){
        System.out.println("Scenario finished");
        DriverManager.closeApplication();
    }

}
