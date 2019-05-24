package testsMobile;

import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import appium.AppiumConfig;
import appium.MobileDriverFactory;

import io.appium.java_client.AppiumDriver;
import org.testng.asserts.SoftAssert;
import screenObjects.discogsHome.DiscoIntroHomeScreen;



public class BaseTestMobile {
	protected static SoftAssert softAssert;

	private DiscoIntroHomeScreen discoIntroHomeScreen;

	@BeforeSuite(alwaysRun=true)
	public void beforeSuite() {
		AppiumConfig config = ConfigFactory.create(AppiumConfig.class);
		MobileDriverFactory factory = new MobileDriverFactory();
		AppiumDriver<?> driver = factory.getDriver(config);
		softAssert = softAssert= new SoftAssert();
		discoIntroHomeScreen = new DiscoIntroHomeScreen(driver);
	}
	
	@AfterSuite(alwaysRun=true)
	public void afterSuite() {
		softAssert.assertAll();
		discoIntroHomeScreen.dispose();
	}
	
	public DiscoIntroHomeScreen getDiscoIntroHomeScreen(){
		return discoIntroHomeScreen;
	}


}
