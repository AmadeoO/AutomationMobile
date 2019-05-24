package listener;

import java.util.Formatter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import logging.Logging;

import io.appium.java_client.events.api.general.ElementEventListener;

public class ElementListener implements ElementEventListener, Logging {
	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
		String text = element.getText();
		String type = element.getTagName();
		log(format("Click on element: type: [%s] text: [%s]", type, text));
	}

	private String format(String format, Object... args) {
		return new Formatter().format(format, args).toString();
	}

	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
	}

	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
	}

	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
	}

	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver) {
	}

	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
	}

}
