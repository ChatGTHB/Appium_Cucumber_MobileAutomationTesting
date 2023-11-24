package stepDefinitions;

import io.cucumber.java.*;
import utilities.DriverManager;

public class Hooks {
    @Before
    public void before() {
        System.out.println("Scenario started");
    }

    @After
    public void after() {
        System.out.println("Scenario finished");
        DriverManager.closeApplication();
    }
}
