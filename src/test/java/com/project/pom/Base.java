package com.project.pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

	private WebDriver driver;

	public Base(WebDriver driver) {
		this.driver = driver;

	}

	public WebDriver chromeDriverConnection() {
		String os = System.getProperty("os.name").toLowerCase();

		System.out.println("Java Application project path:" + os);

		if (os.contains("mac")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/src/test/resources/chromedriver");
		} else {
			System.setProperty("webdriver.chrome.driver", "\\src\\test\\resources\\chromedrive.exe");
		}

		driver = new ChromeDriver();

		return driver;

	}

	public WebElement findElement(By locator) {
		return driver.findElement(locator);
	}

	public List<WebElement> findElements(By locator) {
		return driver.findElements(locator);
	}

	public String getText(WebElement element) {
		return element.getText();
	}

	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}

	public void type(String inputText, By locator) {
		driver.findElement(locator).sendKeys(inputText);
	}

	public void click(By locator) {
		driver.findElement(locator).click();
	}

	public void clear(By locator) {
		driver.findElement(locator).clear();
	}

	public void submit(By locator) {
		driver.findElement(locator).submit();
	}

	public Boolean isDisplayed(By locator) {

		try {
			return driver.findElement(locator).isDisplayed();
		} catch (NoSuchElementException nse) {
			return false;
		}

	}

	public void visit(String url) {
		driver.get(url);
	}

	public void wait(int seconds, By locator) {

		WebDriverWait ewait = new WebDriverWait(driver, Duration.ofSeconds(seconds));

		ewait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
	}

}
