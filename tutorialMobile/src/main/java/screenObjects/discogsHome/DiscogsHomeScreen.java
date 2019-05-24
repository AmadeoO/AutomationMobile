package screenObjects.discogsHome;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import screenObjects.BaseScreen;
import screenObjects.pageSearch.SearchScreen;
import tools.UtilitiesMobile;

public class DiscogsHomeScreen extends BaseScreen {

    @AndroidFindBy(id = ID_TESTMOBILE + "fragment_welcome_register")
    private AndroidElement btnCreateAccount;

    @AndroidFindBy(id = ID_TESTMOBILE + "fragment_welcome_login")
    private AndroidElement btnLogin;

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@index='1']")
    private AndroidElement btnSearch;




    public DiscogsHomeScreen(AppiumDriver driver) {
        super(driver);
    }

    public SearchScreen tapBtnSearch(){
        UtilitiesMobile.tapOnScreen((AndroidDriver) driver,1022,136);
        return new SearchScreen(driver);
    }

}
