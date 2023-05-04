package Tests;

import com.relevantcodes.extentreports.LogStatus;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CalculationTests extends BaseTest {

    public CalculationTests() throws Exception {
    }
//Clears the Calculator board before every test
@Before
public void clearBoard(){
    calculatorPage.clickClear();
}
//Check the result of adding two numbers
    @Test
    public void test01_AddTowNumbers(){
        myTest = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
        myTest.log(LogStatus.INFO,"Test Start: ");
        calculatorPage.setNumber(getNumber1());
        calculatorPage.clickPlus();
        calculatorPage.setNumber(getNumber2());
        calculatorPage.clickEqual();
        System.out.println("actual result: "+calculatorPage.readActualResult()+" expected result: "+getExpectedResultTest1());
        calculatorPage.assertEquals(getExpectedResultTest1(), calculatorPage.readActualResult());
    }
    //Check the result of dividing two numbers
    @Test
    public void test02_DivideTowNumbers(){
        myTest = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
        calculatorPage.setNumber(getNumber1());
        calculatorPage.clickDiv();
        calculatorPage.setNumber(getNumber2());
        calculatorPage.clickEqual();
        System.out.println("actual result: "+calculatorPage.readActualResult()+" expected result: "+getExpectedResultTest2());
        calculatorPage.assertEquals(getExpectedResultTest2(), calculatorPage.readActualResult());

    }
    //Check the result of doubling two numbers
    @Test
    public void test03_DoubleTowNumbers() {
        myTest = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
        calculatorPage.setNumber(getNumber1());
        calculatorPage.clickDouble();
        calculatorPage.setNumber(getNumber2());
        calculatorPage.clickEqual();
        System.out.println("actual result: "+calculatorPage.readActualResult()+" expected result: "+getExpectedResultTest3());
        calculatorPage.assertEquals(getExpectedResultTest3(), calculatorPage.readActualResult());
    }
    //Check the result of absenting two numbers
    @Test
    public void test04_AbsenceTowNumbers() {
        myTest = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
        calculatorPage.setNumber(getNumber1());
        calculatorPage.clickMinus();
        calculatorPage.setNumber(getNumber2());
        calculatorPage.clickEqual();
        System.out.println("actual result: "+calculatorPage.readActualResult()+" expected result: "+getExpectedResultTest4());
        calculatorPage.assertEquals(getExpectedResultTest4(), calculatorPage.readActualResult());
    }
}
