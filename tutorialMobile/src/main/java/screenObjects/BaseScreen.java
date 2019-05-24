package screenObjects;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;

import appium.AppiumConfig;
import logging.Logging;

import static io.appium.java_client.MobileBy.AndroidUIAutomator;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import tools.UtilitiesMobile;

@SuppressWarnings({ "rawtypes", "unchecked" })
public abstract class BaseScreen<T extends AppiumDriver> implements Logging {

	protected final T driver;
	private AppiumConfig config = ConfigFactory.create(AppiumConfig.class);
	protected final String ID_TESTMOBILE = "com.discogs.app:id/";

	public BaseScreen(AppiumDriver<?> driver) {
		this.driver = (T) driver;
		initElements();
	}

	private void initElements() {
		PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
	}

	protected T getDriver() {
		return (T) driver;
	}

	public void dispose() {
		if (driver != null) {
			driver.quit();
		}
	}

	protected <K> FluentWait<K> waitOn(K object, int timeOutSeconds) {
		return new FluentWait<>(object).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class).withTimeout(timeOutSeconds, SECONDS)
				.pollingEvery(1, SECONDS);
	}

	protected FluentWait<T> getWait() {
		return waitOn(getDriver(), config.timeout());
	}

	protected void tap(MobileElement element) {
		getWait().until(elementToBeClickable(element)).click();
	}

	protected void tap(String text) {
		By locator = AndroidUIAutomator("text(\"" + text + "\")");
		getWait().until(elementToBeClickable(locator)).click();
	}

	protected String getText(MobileElement element) {
		return getWait().until(visibilityOf(element)).getText();
	}

	protected void type(MobileElement element, String text) {
		getWait().until(elementToBeClickable(element));
		element.clear();
		element.sendKeys(text);
	}

	protected boolean isLoaded(MobileElement element, int timeLimitSeconds) {
		return UtilitiesMobile.waitForPresence((AndroidDriver) driver, timeLimitSeconds, element);
	}

	protected void hideKeyboard() {
		getDriver().hideKeyboard();
	}

	public void tapButtonBack() {
		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
	}

}


