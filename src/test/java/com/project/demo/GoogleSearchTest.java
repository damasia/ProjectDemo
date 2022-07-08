package com.project.demo;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.project.pom.GooglePage;

public class GoogleSearchTest {

	private final String SEARCH = "Orange Bank";

	private WebDriver driver;

	private GooglePage googlePage;

	@Before
	public void setUp() throws InterruptedException {

		googlePage = new GooglePage(driver);
		driver = googlePage.chromeDriverConnection();
		googlePage.visit("https://www.google.com/");

	}

	@Test
	public void testMoreHundred() throws InterruptedException {

		googlePage.doSearch(SEARCH);

		Assert.assertTrue("More than 100,000 results", googlePage.getNumberResults() > 100000);

	}

	/*
	 * WARNING: this test will fail if there are less of 10000 results otherwise it
	 * will pass. Automated tests are made to pass not to fail.
	 */
	@Test
	public void testMoreTen() throws InterruptedException {

		googlePage.doSearch(SEARCH);

		int result = googlePage.getNumberResults();

		if (result < 10000)
			Assert.fail("Less than 10,000 results");

	}

	@After
	public void tearDown() {
		driver.quit();

	}

}
