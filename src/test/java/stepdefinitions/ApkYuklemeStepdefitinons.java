package stepdefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.en.Given;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ApkYuklemeStepdefitinons {

    AndroidDriver<AndroidElement> androidDriver;

    @Given("Kullanici {string} cihaza yukler")
    public void kullanici_cihaza_yukler(String apkDosyaYolu) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 4");//cihazimizin adi
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android"); //isletim sistemi
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0"); //versiyonu biz 10 sectik
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");//android kullandigimiz icin UiAutomator2, IOS icin XCUITest kullanilir
        caps.setCapability(MobileCapabilityType.APP, apkDosyaYolu);


        androidDriver= new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        androidDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

}
