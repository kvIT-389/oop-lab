package calc;

import java.util.Map;
import java.util.function.DoubleBinaryOperator;


public class Calculator {
    public enum BinaryOperatorCode {
        Addition,
        Subtraction,
        Multiplication,
        Division
    }

    public Calculator() {}

    private static Map<BinaryOperatorCode, DoubleBinaryOperator>
    m_binaryOperators = Map.of(
        /* Addition operator */
        BinaryOperatorCode.Addition,
        (a, b) -> { return a + b; },
        /* Subtraction operator */
        BinaryOperatorCode.Subtraction,
        (a, b) -> { return a - b; },
        /* Multiplication operator */
        BinaryOperatorCode.Multiplication,
        (a, b) -> { return a * b; },
        /* Division operator */
        BinaryOperatorCode.Division,
        (a, b) -> { return a / b; }
    );

    private static Map<String, BinaryOperatorCode>
    m_binaryOperatorNames = Map.of(
        "+", BinaryOperatorCode.Addition,
        "-", BinaryOperatorCode.Subtraction,
        "*", BinaryOperatorCode.Multiplication,
        "/", BinaryOperatorCode.Division
    );

    public static Double calculate(BinaryOperatorCode operatorCode,
                                   Double a, Double b) {
        return m_binaryOperators.get(operatorCode).applyAsDouble(a, b);
    }

    public static Double calculate(String operatorName,
                                   Double a, Double b) {
        return calculate(
            getBinaryOperatorCode(operatorName), a, b
        );
    }

    public static BinaryOperatorCode getBinaryOperatorCode(String operatorName) {
        return m_binaryOperatorNames.get(operatorName);
    }
}
