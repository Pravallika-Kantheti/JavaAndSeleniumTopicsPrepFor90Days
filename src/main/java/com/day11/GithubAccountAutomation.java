package com.day11;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GithubAccountAutomation {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");

		WebDriver wd = new ChromeDriver(options);
		wd.get("https://github.com/signup");

		WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(10));// when you use WebDriverWait you will get
																			// timeout exception
		By emailTextBoxLocator = By.id("email");
		WebElement emailTextBox = wait.until(ExpectedConditions.visibilityOfElementLocated(emailTextBoxLocator));
		emailTextBox.sendKeys("158R1A04A9@gmail.com");

		By passwordTextBoxLocator = By.id("password");
		wait.until(ExpectedConditions.visibilityOfElementLocated(passwordTextBoxLocator)).sendKeys("prava!234!");

		By usernameTextBoxLocator = By.id("login");
		WebElement usernameTextBox = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameTextBoxLocator));
		usernameTextBox.sendKeys("pravallikaK");

		By countryDropdownLocator = By.xpath("//button[contains(@id, \"select-panel\") and @type=\"button\"]");
		WebElement countryDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(countryDropdownLocator));
		countryDropdown.click();
		
		By countrySearchTextBoxLocator = By.xpath("//input[contains(@id, \"select-panel\") and @name=\"filter\"]");
		WebElement countrySearchTextBox = wait.until(ExpectedConditions.visibilityOfElementLocated(countrySearchTextBoxLocator));
		countrySearchTextBox.sendKeys("Albania");
		
		By countrySelectionButtonLocator = By.xpath("//span[contains(text(), \"Albania\")]/..");//we will not click on span so use parent locator to click on button with help of /..
		WebElement countrySelectionButton = wait.until(ExpectedConditions.visibilityOfElementLocated(countrySelectionButtonLocator));
		countrySearchTextBox.click();
		

	}

}
