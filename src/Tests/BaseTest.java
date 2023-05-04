package Tests;


import PageObjects.CalculatorPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    //Attributes**//
    static ExtentReports extent;
    public static ExtentTest myTest;
    private static String reportFilePath = "C:\\Users\\amit\\IdeaProjects\\calculator\\src\\Data\\testReportMobileProject.html";
    private static String imagePath = "C:\\Users\\amit\\IdeaProjects\\calculator\\src\\Data\\mobile_project_screenshots";
    public static WebDriver driver= null;
    private String numbersPath = "C:\\Users\\amit\\IdeaProjects\\calculator\\src\\Data\\numbers.xml";
    private String number1 = readFromFile("firstNumber", numbersPath);
    private String number2 = readFromFile("secondNumber", numbersPath);
    final int addedNumbers = addTowNumbers(number1, number2); //parse to int and add two numbers
    final int subtractNumbers = subtractTowNumbers(number1, number2); //parse to int and subtract two numbers
    final int divideNumbers = divideTowNumbers(number1, number2); //parse to int and divide two numbers
    final int doubleNumbers = doubleTowNumbers(number1, number2); //parse to int and double two numbers
    private String expectedResultTest1 = Integer.toString(addedNumbers); //parse to String added numbers
    private String expectedResultTest2 = Integer.toString(divideNumbers); //parse to String divided numbers
    private String expectedResultTest3 = Integer.toString(doubleNumbers); //parse to String doubled numbers
    private String expectedResultTest4 = Integer.toString(subtractNumbers); //parse to String subtracted numbers
    static CalculatorPage calculatorPage;

//**Constructors**//
    public BaseTest() throws Exception {
    }

    //**Methods**//
    //Setters and Getters

    public void setImagePath(String imagePath) {
        BaseTest.imagePath = imagePath;
    }

    public void setNumber1(String number1) {
        this.number1 = number1;
    }

    public void setNumber2(String number2) {
        this.number2 = number2;
    }

    public void setExpectedResultTest1(String expectedResultTest1) {
        this.expectedResultTest1 = expectedResultTest1;
    }

    public void setExpectedResultTest2(String expectedResultTest2) {
        this.expectedResultTest2 = expectedResultTest2;
    }

    public void setExpectedResultTest3(String expectedResultTest3) {
        this.expectedResultTest3 = expectedResultTest3;
    }

    public void setExpectedResultTest4(String expectedResultTest4) {
        this.expectedResultTest4 = expectedResultTest4;
    }


    public static String getImagePath() {
        return imagePath;
    }

    public String getNumber1() {
        return number1;
    }

    public String getNumber2() {
        return number2;
    }

    public String getExpectedResultTest1() {
        return expectedResultTest1;
    }

    public String getExpectedResultTest2() {
        return expectedResultTest2;
    }

    public String getExpectedResultTest3() {
        return expectedResultTest3;
    }

    public String getExpectedResultTest4() {
        return expectedResultTest4;
    }

    //Add two numbers from xml file
    private int addTowNumbers(String number1, String number2) {
        int result;
        result = Integer.parseInt(number1) + Integer.parseInt(number2);
        return
                result;
    }
    //Subtract two numbers from xml file
    private int subtractTowNumbers(String number1, String number2) {
        int result;
        result = Integer.parseInt(number1) - Integer.parseInt(number2);
        return result;
    }
    //Divide two numbers from xml file
    private int divideTowNumbers(String number1, String number2) {
        int result;
        result = Integer.parseInt(number1) / Integer.parseInt(number2);
        return result;
    }
    //Double two numbers from xml file
    private int doubleTowNumbers(String number1, String number2) {
        int result;
        result = Integer.parseInt(number1) * Integer.parseInt(number2);
        return result;
    }


    //Initialize Test report, Web driver and page object
    @BeforeClass
    public static void setUp() throws IOException {
        extent = new ExtentReports(reportFilePath);
        myTest = extent.startTest("Calculator Test Run");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android Device");
        capabilities.setCapability("appPackage", "com.android.calculator2");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        capabilities.setCapability("unicodeKeyboard", true);
        capabilities.setCapability("resetKeyboard", true);
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub/"), capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        calculatorPage = new CalculatorPage(driver);


    }

    //Reading a dynamic value from xml file
    public String readFromFile(String keyData, String path) throws Exception {
        File xmlFile = new File(path);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);
        doc.getDocumentElement().normalize();

        return doc.getElementsByTagName(keyData).item(0).getTextContent();

    }
    //Taking a screenshot
    public static String takeScreenShot(String ImagePath) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagePath + ".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return ImagePath + ".png";
    }
    //Closing the web driver and automatically  represent test report
    @AfterClass
    public static void closeDriverAndReports() throws IOException {

        driver.quit();
        extent.flush();
        Desktop.getDesktop().browse(new File(reportFilePath).toURI());
    }
}
