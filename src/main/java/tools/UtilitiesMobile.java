package tools;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import screenObjects.BaseScreen;

import java.util.Random;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

public class UtilitiesMobile extends BaseScreen {



    public UtilitiesMobile(AppiumDriver driver) {
        super(driver);

    }

    /**
     * Generates a pseudo-random integer in the range [min, max]
     * @param min : the starting value of the range (inclusive)
     * @param max : the ending value of the range (inclusive)
     */
    public static int generateRandomNumberMinMax(int min, int max)
    {
        if (min > max) {
            throw new IllegalArgumentException("Invalid range");
        }

        Random rand = new Random();

        return rand.ints(min, (max + 1))	// IntStream
                .findFirst()			// OptionalInt
                .getAsInt();			// int
    }

    public static boolean waitForPresence(AndroidDriver driver, int timeLimitInSeconds, final MobileElement mobileElement) {

        boolean isElementPresent;
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeLimitInSeconds);
            wait.until(ExpectedConditions.visibilityOf(mobileElement));
            isElementPresent = mobileElement.isDisplayed();
            return isElementPresent;
        } catch (Exception e) {
            isElementPresent = false;
            System.out.println(e.getMessage());
            return isElementPresent;
        }


    }

    public static void swipe(AppiumDriver driver) {
        TouchAction touchAction = new TouchAction(driver);
        int startX = 300;
        int startY = 500;

        int endX = 700;
        int endY = 100;

        touchAction
                .press(point(startX, startY))
                .waitAction(waitOptions(ofMillis(1000)))
                .moveTo(point(endX, endY))
                .release().perform();
    }


    public static void tapOnScreen(AndroidDriver driver, int x, int y){
        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(point(x,y)).release().perform();
    }
}
