package com.apptesting.steps;

import com.apptesting.base.InitialiseDriver;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.fail;

public class CommonStepdef {
    InitialiseDriver initialiseDriver = new InitialiseDriver();

    @Given("i open the {string} application")
    public void iOpenTheApplication(String apk) throws MalformedURLException {
        initialiseDriver.InitialiseDriver(apk);
    }

    @Then("i {string} two numbers {string} and {string}")
    public void iTwoNumbersAnd(String operation, String num1, String num2) {
        try {

            String sign = "com.google.android.calculator:id/op_" + operation;
            String firstNum = String.valueOf(num1);
            String secondNum = String.valueOf(num2);

            for (int i = 0; i < firstNum.length(); i++) {
                String firstNumber = "com.google.android.calculator:id/digit_" + firstNum.charAt(i);
                initialiseDriver.getDriver().findElement(By.id(firstNumber)).click();

            }
            initialiseDriver.getDriver().findElement(By.id(sign)).click();

            for (int i = 0; i < secondNum.length(); i++) {
                String firstNumber = "com.google.android.calculator:id/digit_" + secondNum.charAt(i);
                initialiseDriver.getDriver().findElement(By.id(firstNumber)).click();

            }

            initialiseDriver.getDriver().findElement(By.id("com.google.android.calculator:id/eq")).click();

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    @And("i get answer is {string}")
    public void iGetAnswerIs(String answer) {
        WebElement getAnswer = initialiseDriver.getDriver().findElement(By.id("com.google.android.calculator:id/result_final"));
        if (getAnswer.getText().equals(answer)) {
            System.out.println("Expected answer is Correct:.. " + getAnswer.getText());
        } else {
            fail("Expected answer doesnt match actual answer:.. " + "actual answer:" + getAnswer.getText());
        }

    }
}

