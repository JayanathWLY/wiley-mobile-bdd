package com.example.wileymobilebdd.utils;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(
    features = "src/test/resources/feature",
    glue = "",
    tags = {"~@Ignore"},
    format = {
        "pretty",
        "html:target/cucumber-reports/cucumber-pertty",
        "json:target/cucumber-reports/CucumberTestReport",
        "return:target/cucumber-reports/return.txt"
    },
    plugin = "json:target/cucumber-reports/CucumberTestReport.json"
)
@SpringBootTest
public class CucumberTestNGRunner {

    private TestNGCucumberRunner testRunner;

    @BeforeClass(alwaysRun = true)
    public void setupTest(){
        testRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(description = "Starting Cucumber Tests", dataProvider = "feature")
    public void testCucumber(CucumberFeatureWrapper featureWrapper) {
        testRunner.runCucumber(featureWrapper.getCucumberFeature());
    }

    @AfterClass
    public void tearDown() {
        testRunner.finish();
    }

    @DataProvider(name = "feature")
    public Object[][] features() {
        return testRunner.provideFeatures();
    }
}
