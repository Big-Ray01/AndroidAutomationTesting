package com.apptesting.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/com/apptesting/feature/Calculator.feature",
        tags = "@test",
        glue = "com.apptesting.steps",
        plugin = { "pretty", "html: ExecutionReport/cucumber-reports.html"}

)
public class MainRunner {
}
