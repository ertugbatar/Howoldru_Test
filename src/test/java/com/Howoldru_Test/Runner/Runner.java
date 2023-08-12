package com.Howoldru_Test.Runner;

import com.Howoldru_Test.utilities.Driver;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/default-cucumber-reports",
                "json:target/cucumber.json"
        },

        features = "src/test/resources/features",
        tags = "",
        glue = "com/Howoldru_Test/stepDefs",
        dryRun = false
)
public class Runner {

        @Before()
        public void setUp() {
                 Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);}
        @After()
        public void tearDown() {Driver.getDriver().quit();}
}
