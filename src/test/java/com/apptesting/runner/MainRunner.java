package com.apptesting.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C:\\Users\\Administrator\\IdeaProjects\\AndroidAppTesting\\src\\test\\java\\com\\apptesting\\feature\\Calculator.feature",
//        plugin = "pretty",
        tags = "@test",
        glue = "com.apptesting.steps"
)
public class MainRunner {
}
