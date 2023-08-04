package calculator;


import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class MyStepdefs {
    private Calculator calculator;

    private int value1;

    private int value2;

    private String operator;

    private double result;

    @Before
    public void before(){
        calculator = new Calculator();
    }

    @Given("two input values and operator, {int} {int} {string}")
    public void twoInputValuesAndOperator(int value1, int value2, String operator) {
        this.value1 = value1;
        this.value2 = value2;
        this.operator = operator;
    }

    @When("i Divide first value by second value")
    public void iDivideFirstValueBySecondValue() {
       this.result =  calculator.calculate(this.value1,this.value2,this.operator);

    }
    @Then("i expect the result to be {double}")
    public void iExpectTheResultToBe(double result) {
        Assert.assertEquals(result, this.result, 0);
        System.out.println(this.result);
    }

    @When("i Divide first value by second value that is zero")
    public void iDivideFirstValueBySecondValueThatIsZero() {
        this.divideByZeroException = Assert.assertThrows(Exception.class, () -> calculator.calculate(this.value1, this.value2,this.operator));
    }

    @Then("i expect the result to be {string}")
    public void iExpectTheResultToBe(String exception) {
        Assert.assertEquals(exception, divideByZeroException.getMessage());
    }
    @Given("two input values and Multiplication operator, {int} {int} {string}")
    public void twoInputValuesAndMultiplicationOperator(int value1, int value2, String operator) {
        this.value1 = value1;
        this.value2 = value2;
        this.operator = operator;
    }

    @When("i multiply first value by second value")
    public void iMultiplyFirstValueBySecondValue() throws Exception {
        this.result =  calculator.calculate(this.value1,this.value2,this.operator);
    }
    @Given("two input values and power operator, {int} {int} {string}")
    public void twoInputValuesAndPowerOperator(int value1, int value2, String operator) {
        this.value1 = value1;
        this.value2 = value2;
        this.operator = operator;
    }

    @When("i power first value to second value")
    public void iPowerFirstValueToSecondValue() {
        this.result =  calculator.calculate(this.value1,this.value2,this.operator);
    }



}
