package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CalculatorPage extends BasePage {


    //**Attributes**//
    //page's elements
    By zero = By.id("com.android.calculator2:id/digit_0");
    By one = By.id("com.android.calculator2:id/digit_1");
    By tow = By.id("com.android.calculator2:id/digit_2");
    By three = By.id("com.android.calculator2:id/digit_3");
    By four = By.id("com.android.calculator2:id/digit_4");
    By five = By.id("com.android.calculator2:id/digit_5");
    By six = By.id("com.android.calculator2:id/digit_6");
    By seven = By.id("com.android.calculator2:id/digit_7");
    By eight = (By.id("com.android.calculator2:id/digit_8"));
    By nine = By.id("com.android.calculator2:id/digit_9");
    By plus = By.id("com.android.calculator2:id/op_add");
    By minus = By.id("com.android.calculator2:id/op_sub");
    By div = By.id("com.android.calculator2:id/op_div");
    By doub = By.id("com.android.calculator2:id/op_mul");
    By clear = By.id("com.android.calculator2:id/op_clr");
    By equal = By.id("com.android.calculator2:id/eq");
    By actualResult = By.id("com.android.calculator2:id/formula");
    //**Constructors**//
    //Connect the driver to the page
    public CalculatorPage(WebDriver driver) {
        super(driver);
    }
    //Type a number according to xml file
    public void setNumber(String number) {

        // String [] numberArray= number.split("");
        for (int i = 0; i < number.length(); i++) {
            switch (number.charAt(i)) {
                case '0':
                    clickButton(zero);
                    break;
                case '1':
                    clickButton(one);
                    break;
                case '2':
                    clickButton(tow);
                    break;
                case '3':
                    clickButton(three);
                    break;
                case '4':
                    clickButton(four);
                    break;
                case '5':
                    clickButton(five);
                    break;
                case '6':
                    clickButton(six);
                    break;
                case '7':
                    clickButton(seven);
                    break;
                case '8':
                    clickButton(eight);
                    break;
                case '9':
                    clickButton(nine);
                    break;
                default:
                    System.out.println("error: xml file contains invalid digits");
            }
        }
    }
    //Click on plus button
    public CalculatorPage clickPlus() {
        clickButton(plus);
        return this;
    }
    //Click on minus button
    public CalculatorPage clickMinus() {
        clickButton(minus);
        return this;
    }
    //Click on division button
    public CalculatorPage clickDiv() {
        clickButton(div);
        return this;
    }
    //Click on double button
        public CalculatorPage clickDouble() {
        clickButton(doub);
        return this;
    }
    //Click on clear button
    public CalculatorPage clickClear() {
        clickButton(clear);
        return this;
    }
    //Click on equal button
    public CalculatorPage clickEqual() {
        clickButton(equal);
        return this;
    }
    //Read the actual result from the calculator's board
    public String readActualResult() {
        return
                readText(actualResult);

    }


}
