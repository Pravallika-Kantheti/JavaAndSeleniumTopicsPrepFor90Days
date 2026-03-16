package com.day21;

import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v143.fetch.Fetch;
import org.openqa.selenium.devtools.v143.fetch.model.RequestPattern;
import org.openqa.selenium.devtools.v143.fetch.model.RequestStage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class SeleniumNetworkInterception {

	public static void main(String[] args) {

		WebDriver wd = new ChromeDriver();

		// access to chrome dev tools -->

		DevTools devTools = ((ChromeDriver) wd).getDevTools();
		devTools.createSession();// Madatory!!
		// we use optional to avaoid null pointer exception
		devTools.send(Fetch.enable(
				Optional.of(List
						.of(new RequestPattern(Optional.of("*"), Optional.empty(), Optional.of(RequestStage.REQUEST)))),
				Optional.empty()));
		devTools.addListener(Fetch.requestPaused(), request -> {
			System.out.println("Intercepted!!");
			System.out.println(request.getRequest().getMethod());
			System.out.println(request.getRequest().getUrl());
			String url = request.getRequest().getUrl();

			if (url.contains("verify")) {
				// intercept and mock the response
				//System.out.println("we need to mock the response");
				String jsonResponse = """
												{
						    "status": "SUCCESS",
						    "message": "Citizen registration verified successfully.",
						    "transaction_id": "MOCK TXN-TECH-WITH-PRAVA",
						    "amount_deducted": "₹00.00 (~$0.00 USD)",
						    "username": "prava",
						    "timestamp": "2026-03-16T17:44:09.195Z"
						}
												""";
				String jsonResponseBase64 = Base64.getEncoder()
						.encodeToString(jsonResponse.getBytes(StandardCharsets.UTF_8));
				devTools.send(Fetch.fulfillRequest(request.getRequestId(), 200, Optional.empty(), Optional.empty(),
						Optional.of(jsonResponseBase64), Optional.empty()));
			} else {
				devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.empty(), Optional.empty(),
						Optional.empty(), Optional.empty(), Optional.empty()));
			}
		});

		wd.get("http://mock-api.techwithjatin.com/");

		WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(30));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys("prava123");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("prava123");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("registerBtn"))).click();
		System.out.println("Entered login details and Clicked Register button successfully");

	}

}
