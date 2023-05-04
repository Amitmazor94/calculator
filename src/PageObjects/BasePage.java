package PageObjects;

import com.relevantcodes.extentreports.LogStatus;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static Tests.BaseTest.*;

public class BasePage {
    //**Attributes**//
    public WebDriver driver;

    //**Constructors**//
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }


    //**Methods**//
    //CLick on a calculator button
    public void clickButton(By elementLocation) {
        driver.findElement(elementLocation).click();
    }

    //Read a text of an element
    public String readText(By elementLocation) {
        WebElement element = driver.findElement(elementLocation);
        return
                element.getText();
    }

    //Compare expected result to actual result
    public void assertEquals(String expectedResult, String actualResult) {
        try {
            Assert.assertEquals(expectedResult, actualResult);
            myTest.log(LogStatus.PASS, "Succeeded" + myTest.addScreenCapture(takeScreenShot(getImagePath() + "\\" + System.currentTimeMillis())));
        } catch (AssertionError e) {
            myTest.log(LogStatus.FAIL, "An error occurred" + myTest.addScreenCapture(takeScreenShot(getImagePath() + "\\" + System.currentTimeMillis())));
        }
    }

}
