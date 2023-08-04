package calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Calculator {
    private enum Operator {
        DIVISION,
        MULTIPLICATION
    }


    private int firstValue;
    private int secondValue;

    private Operator operator;

    private Map<String, Operator > operatorMap;

    private Map<Operator, BiFunction<Integer, Integer, Double>> calculatorMethod;

    public Calculator () throws Exception {
        defineOperator();
        defineCalculator();
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
        operatorMap.put("*", Operator.MULTIPLICATION);
    }

    private void defineCalculator() throws Exception {
        calculatorMethod = new HashMap<>();
        calculatorMethod.put(Operator.DIVISION, (a, b) -> {
            try {
                return divide(a, b);
            } catch (Exception e) {
                throw new RuntimeException("cant divide by zero");
            }
        });
        calculatorMethod.put(Operator.MULTIPLICATION, this::multiply);
    }

    public double calculate(int firstValue, int secondValue, String operator) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
        this.operator = operatorMap.get(operator);
        return calculatorMethod.get(this.operator).apply(this.firstValue, this.secondValue);
    }

    private double divide(int a, int b) throws Exception {
        try {

            return (double) (a / b);
        }
        catch (Exception exception){
            throw new Exception("cant divide by zero");
        }

    }

    private double multiply(int firstValue, int secondValue){
        return (double) firstValue * secondValue;
    }
}
