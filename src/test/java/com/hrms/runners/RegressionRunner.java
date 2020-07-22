package com.hrms.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
/**first we have to specify the annotated keywords */
@RunWith(Cucumber.class)
@CucumberOptions(

		features = "src/test/resources/features/",
		/**here we sepcify the path for the feature file*/

		glue = "com/hrms.steps",
		/**here we locate the location of of the steps classes( java files)*/

		dryRun = true,
		/** if true, it will scan for errore before opening the browser*/

		monochrome = true,//makes the report readable
		strict = true,//if true and one case fails, it fail the entire build
		tags = "@regression",// here we specify which exact tests we want to run

		plugin = { "pretty",//prints the gerkin words in the conceol
				"html:target/cucumber-default-report",//creates basic html report in specific location
				"json:target/cucumber.json",// complete our report and makes it beautiful with more details
				"rerun:target/failed.txt"
				}

)

public class RegressionRunner {

}
