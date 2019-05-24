package screenObjects.warningsScreen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import screenObjects.BaseScreen;
import screenObjects.discogsHome.DiscogsHomeScreen;

public class WarningScreenAfterSkip extends BaseScreen {


    @AndroidFindBy(id = ID_TESTMOBILE + "md_buttonDefaultPositive")
    private AndroidElement btnOk;



    public WarningScreenAfterSkip(AppiumDriver driver) {
        super(driver);
    }

    public DiscogsHomeScreen tapBtnOk(){
        if (btnOk.isDisplayed()){
            btnOk.click();
        }
        return new DiscogsHomeScreen(driver);
    }
}
