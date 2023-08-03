package calculator;

import java.util.HashMap;
import java.util.Map;

public class Calculator {
    private enum Operator {
        DIVISION
    }



    private int firstValue;
    private int secondValue;

    private Operator operator;

    private Map<String, Operator > operatorMap;

    private Map<Operator, Double> calculatorMethod;

    public Calculator (){

    }

    public int getFirstValue() {
        return firstValue;
    }

    public void setFirstValue(int firstValue) {
        this.firstValue = firstValue;
    }

    public int getSecondValue() {
        return secondValue;
    }

    public void setSecondValue(int secondValue) {
        this.secondValue = secondValue;
    }
    private void defineOperator(){
        operatorMap = new HashMap<>();
        operatorMap.put("/", Operator.DIVISION);
    }

    private void defineCalculator() throws Exception {
        calculatorMethod = new HashMap<>();
        calculatorMethod.put(Operator.DIVISION, divide(this.firstValue, this.secondValue));
    }

    public double calculate(int firstValue, int secondValue, String operator) throws Exception {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
        defineOperator();
        defineCalculator();
        this.operator = operatorMap.get(operator);
        return calculatorMethod.get(this.operator);
    }

    private double divide(int a, int b) throws Exception {
        try {

            return (double) (a / b);
        }
        catch (Exception exception){
            throw new Exception("cant divide by zero");
        }

    }
}
