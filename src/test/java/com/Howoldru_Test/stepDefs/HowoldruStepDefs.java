package com.Howoldru_Test.stepDefs;

import com.Howoldru_Test.PageObject.BasePage;
import com.Howoldru_Test.utilities.ConfigurationReader;
import com.Howoldru_Test.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import static com.Howoldru_Test.utilities.Driver.getDriver;

public class HowoldruStepDefs {


    BasePage basePage = new BasePage();

    @Given("I am on the age estimation website")
    public void i_am_on_the_age_estimation_website() throws InterruptedException {
        String url = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(url);
        getDriver().manage().window().maximize();
        Thread.sleep(3000);

    }

    @When("I enter my name as {string}")
    public void i_enter_my_name_as(String name) throws InterruptedException {
        basePage.inputName.sendKeys(name);
    }

    @When("I enter my birthday as {string}")
    public void i_enter_my_birthday_as(String Birthday) throws InterruptedException {
        basePage.inputBirthday.sendKeys(Birthday);
        Thread.sleep(2000);
    }

    @And("I click the {string} button")
    public void iClickTheButton(String arg0) {
        BasePage.submitButton.click();
    }


    @Then("I should see an estimated age of {string} displayed on the screen")
    public void i_should_see_an_estimated_age_of_displayed_on_the_screen(String string) throws InterruptedException {

        WebElement TextMessage = getDriver().findElement(By.id("resultAge"));
        Thread.sleep(3000);
        String actualTextMessage = TextMessage.getText();
        String ExpectedAge = "34";

        if (actualTextMessage.equals(ExpectedAge)){
            System.out.println("Test passed! Your age is 34");
        }else{
            System.out.println("Test failed!");
        }
    }



    @Then("I should see an error message indicating the correct date format")
    public void iShouldSeeAnErrorMessageIndicatingTheCorrectDateFormat() {
        WebElement errorBirthdayMessage = getDriver().findElement(By.xpath("//span[@id='help_birthday']"));
        String expectedText1 = "you are too old to use it";
        String actualText1 =errorBirthdayMessage.getText();

        if (actualText1.equals(expectedText1)){
            System.out.println("Test passed! you are too old to use it");
        }else{
            System.out.println("Test failed!");
        }

    }

    @Then("I should see an error message indicating that the birthdate is in the future")
    public void iShouldSeeAnErrorMessageIndicatingThatTheBirthdateIsInTheFuture() throws InterruptedException {

        WebElement errorBirthdayMessage = getDriver().findElement(By.xpath("//span[@id='help_birthday']"));
        String expectedText1 = "your birthday must be in the past";
        String actualText1 =errorBirthdayMessage.getText();

        if (actualText1.equals(expectedText1)){
            System.out.println("Test passed! your birthday must be in the past");
        }else{
            System.out.println("Test failed!");
        }
    }


}



