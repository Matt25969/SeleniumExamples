package com.qa.shopping;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.qa.util.Constants;
import com.relevantcodes.extentreports.ExtentReports;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:")
public class TestRunner {
	public static ExtentReports report;
	@BeforeClass
	public static void setup() {
		report = new ExtentReports(Constants.filepath + Constants.filename);	}
	@AfterClass
	public static void teardown() {
		report.flush();}
}

