package testsMobile.smokeTests;

import org.testng.annotations.Test;
import screenObjects.discogsHome.DiscoIntroHomeScreen;
import screenObjects.discogsHome.DiscogsHomeScreen;
import screenObjects.pageSearch.SearchScreen;
import screenObjects.warningsScreen.WarningScreenAfterSkip;
import testsMobile.BaseTestMobile;

public class SmokeTest extends BaseTestMobile {

    @Test
    public void SmokeTest() throws InterruptedException {
        DiscoIntroHomeScreen discogsIntroHomeScreen = getDiscoIntroHomeScreen();
        WarningScreenAfterSkip warningScreenAfterSkip = discogsIntroHomeScreen.tapBtnSkip();
        DiscogsHomeScreen discogsHomeScreen = warningScreenAfterSkip.tapBtnOk();
        SearchScreen searchScreen = discogsHomeScreen.tapBtnSearch();

        softAssert.assertEquals(searchScreen.getClassName(), "SearchScreen", "Assert Equals with SearchScreen");

    }
}
