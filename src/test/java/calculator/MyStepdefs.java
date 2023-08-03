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
       this.result =  calculator.divide(value1,value2);

    }
    @Then("i expect the result to be {double}")
    public void iExpectTheResultToBe(double result) {
        Assert.assertEquals(result, this.result, 0);
        System.out.println(this.result);
    }


}
