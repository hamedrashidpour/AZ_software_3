package calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Calculator {
    private enum Operator {
        DIVISION,
        MULTIPLICATION,
        POWER
    }


    private int firstValue;
    private int secondValue;

    private Operator operator;

    private Map<String, Operator > operatorMap;

    private Map<Operator, BiFunction<Integer, Integer, Double>> calculatorMethod;

    public Calculator () {
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
        operatorMap.put("^", Operator.POWER);
    }

    private void defineCalculator() {
        calculatorMethod = new HashMap<>();
        calculatorMethod.put(Operator.DIVISION, (a, b) -> {
            try {
                return divide(a, b);
            } catch (Exception e) {
                throw new RuntimeException("cant divide by zero");
            }
        });
        calculatorMethod.put(Operator.MULTIPLICATION, this::multiply);
        calculatorMethod.put(Operator.POWER, this::power);
    }

    public double calculate(int firstValue, int secondValue, String operator) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
        this.operator = operatorMap.get(operator);
        return calculatorMethod.get(this.operator).apply(this.firstValue, this.secondValue);
    }

    private double divide(int firstValue, int secondValue) throws Exception {
            if (secondValue == 0)
                throw new Exception("cant divide by zero");
            return (double) ((double) firstValue  / (double) secondValue);
    }

    private double multiply(int firstValue, int secondValue){
        return (double) firstValue * secondValue;
    }

    private double power(int firstValue, int secondValue){
        double tempFirst = firstValue;
        if (secondValue == 0)
            return 1;
        if (secondValue < 0){
             tempFirst = 1.0 / firstValue;
            secondValue *= -1;
        }
        double result = tempFirst;
        for (int i = 0; i < secondValue - 1; i++) {
            result *= tempFirst;
        }
        return result;
    }
}
