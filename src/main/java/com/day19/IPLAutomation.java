package com.day19;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IPLAutomation {

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");

		WebDriver wd = new ChromeDriver(options);
		wd.get("https://www.iplt20.com/points-table/men/2025");

		WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(30));
		// step1: find the entire table
		By tableLocator = By.className("ih-td-tab");
		WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(tableLocator));

		// step2: Locate the tbody with the chaining of webelement
		By tbodyLocator = By.id("pointsdata");
		WebElement tbody = table.findElement(tbodyLocator);

		// step3: find all the table rows

		By tableRowLocator = By.tagName("tr");
		List<WebElement> tableRowList = tbody.findElements(tableRowLocator);
		// System.out.println("No of rows in the table present:" + tableRowList.size());

		List<Team> teamList = new ArrayList<Team>();
		for (WebElement row : tableRowList) {
			List<WebElement> tableRowDataList = row.findElements(By.tagName("td"));
//				for(WebElement data:tableRowDataList) {
////					System.out.print(data.getText());
////					System.out.println("");
//				}
			double nrr = Double.parseDouble(tableRowDataList.get(7).getText());
			int points = Integer.parseInt(tableRowDataList.get(10).getText());
			Team team = new Team(tableRowDataList.get(0).getText(), tableRowDataList.get(2).getText(), nrr, points);
			teamList.add(team);
		}

//		for (Team data : teamList) {
//			System.out.println(data);
//		}

		// Stream 101
		// Transformation

//		teamList.stream().forEach(i -> System.out.println(i));
//
//		teamList.stream().map(i -> i.getTeamName())// transformation Stream<Team> to Stream<String>
//				.forEach(i -> System.out.println(i));
//
//		teamList.stream().map(i -> i.getPoints())// transformation Stream<Team> to Stream<Integer>
//				.forEach(i -> System.out.println(i));

		// Filteration
//		teamList.stream()
//		.filter(i -> i.getPoints() == 19) //Stream<Team>
//		.map(i -> i.getTeamName())//Stream<Team> to Stream<String>
//		.forEach(i -> System.out.println(i));

		// find the max of points
		int maxPoints = teamList.stream().mapToInt(i -> i.getPoints()).max().orElse(0);

		System.out.println("Highest points in the table: " + maxPoints);

		teamList.stream().filter(i -> i.getPoints() == maxPoints) // Stream<Team>
				.map(i -> i.getTeamName())// Stream<Team> to Stream<String>
				.forEach(i -> System.out.println("Teams with highest points in the table:" +i));
		
		//You are supposed to print the max NRR of teams who has highest points
		Team maxTeamNrr = teamList.stream()
		.filter(i -> i.getPoints() == maxPoints)
		.max(Comparator.comparingDouble(i -> i.getNrr()))
		.orElse(null);
		System.out.println("Team with max NRR who has highest points: "+maxTeamNrr);

	}

}
