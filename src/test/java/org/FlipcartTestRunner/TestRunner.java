package org.FlipcartTestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features= "src//test//resources//Features",
                 glue="com.Flipkart.StepDefinition",
                 monochrome= true,
                 dryRun=false,
                 tags="@smoke",
                 plugin= "html:target/report.html"
                )

public class TestRunner {

}
