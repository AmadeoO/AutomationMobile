package screenObjects.discogsHome;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import screenObjects.BaseScreen;
import screenObjects.warningsScreen.WarningScreenAfterSkip;

public class DiscoIntroHomeScreen extends BaseScreen {

    @AndroidFindBy(id = ID_TESTMOBILE + "skip")
    private AndroidElement btnSkip;

    @AndroidFindBy(id = ID_TESTMOBILE + "next")
    private AndroidElement btnNext;

    public DiscoIntroHomeScreen(AppiumDriver driver) {
        super(driver);
    }

    public WarningScreenAfterSkip tapBtnSkip(){
        btnSkip.click();
        return new WarningScreenAfterSkip(driver);
    }
}
