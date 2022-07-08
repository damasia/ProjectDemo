package com.project.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class GooglePage extends Base {

	private By rejectButton = By.id("W0wltc");

	private By searchBox = By.name("q");

	private By results = By.id("result-stats");

	public GooglePage(WebDriver driver) {
		super(driver);
	}

	public void doSearch(String search) {
		/*
		 * if cookies screen displays we reject all for this purpose
		 */
		if (isDisplayed(rejectButton)) {
			click(rejectButton);
		}

		clear(searchBox);
		type(search, searchBox);
		submit(searchBox);

		try {
			wait(10, results);

		} catch (NoSuchElementException nse) {
			System.out.println("There is no results");
		}

	}

	public int getNumberResults() {

		try {
			String text = getText(results);

			System.out.println("El resultado fue: " + text);

			/*
			 * we get the number of results
			 */
			String[] words = text.split(" ");

			String numberResults = words[1];

			int result = Integer.parseInt(numberResults.replaceAll(",", ""));

			System.out.println(result);

			return result;

		} catch (NoSuchElementException nse) {
			return 0;
		}

	}

}
