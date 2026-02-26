package com.day15;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TakingScreenshot {

	public static void main(String[] args) throws IOException {
		// for taking screenshot using WebDriver - selenium WebDriver and commons-io
		// dependencies ae needed

		WebDriver wd = new ChromeDriver();
		wd.get("https://www.google.com");
		// use TakesScreenshot interface and typecaste the Webdriver
		TakesScreenshot screenshot = (TakesScreenshot) wd;
		File myFile = screenshot.getScreenshotAs(OutputType.FILE);

		// File acts as a pointer to the myFile stored in RAM (file may or may not exist
		// physically)
		// - we need to save the file under some location to view image - so
		// commons-io(FileUtils) comes into picture

		// id we have Util class then all the methods and variables are staic- we are
		// not creatung object of it
		File outputFile = new File("screenshot.png");
		FileUtils.copyFile(myFile, outputFile);
		
		//second question - Execute only few tests from 1000 test suite
		
		//$ mvn test -Dbrowser=chrome -DisLambdaTest=false -DisHeadless=false -Dgroups=login-X
		//test - it will run all the test under src/testt/java - mvn test - maven-surefire-plugin
	}

}
