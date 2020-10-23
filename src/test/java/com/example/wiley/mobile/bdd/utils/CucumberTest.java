package com.example.wiley.mobile.bdd.utils;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.wiley.mobile.bdd.util.DemoApplication;

@CucumberOptions(
    features = "src/test/resources/feature/",
    glue = "com.example.wiley.mobile.bdd.steps",
    tags = {"~@Ignore"},
    format = {
        "pretty",
        "html:target/cucumber-reports/cucumber-pertty",
        "json:target/cucumber-reports/CucumberTestReport"
    }
)
@SpringBootTest(classes = DemoApplication.class)
public class CucumberTest extends AbstractTestNGSpringContextTests {

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
