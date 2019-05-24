package screenObjects.pageSearch;
import io.appium.java_client.AppiumDriver;
import screenObjects.BaseScreen;


public class SearchScreen extends BaseScreen {
    public SearchScreen(AppiumDriver driver) {
        super(driver);

    }

    public String getClassName() throws InterruptedException {
        Thread.sleep(2000);
        tapButtonBack();
        Thread.sleep(10000);
        return this.getClass().getSimpleName();
    }
}
