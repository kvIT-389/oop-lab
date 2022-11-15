package calc;

import java.util.Map;
import java.util.function.BinaryOperator;


public class Calculator {
    enum BinaryOperatorCode
    {
        Addition,
        Subtraction,
        Multiplication,
        Division
    }

    public Calculator() {}

    private static Map<BinaryOperatorCode, BinaryOperator<Double>>
    m_binaryOperators = Map.of(
        BinaryOperatorCode.Addition,       (a, b) -> { return a + b; },
        BinaryOperatorCode.Subtraction,    (a, b) -> { return a - b; },
        BinaryOperatorCode.Multiplication, (a, b) -> { return a * b; },
        BinaryOperatorCode.Division,       (a, b) -> { return a / b; }
    );

    private static Map<String, BinaryOperatorCode>
    m_binaryOperatorNames = Map.of(
        "+", BinaryOperatorCode.Addition,
        "-", BinaryOperatorCode.Subtraction,
        "*", BinaryOperatorCode.Multiplication,
        "/", BinaryOperatorCode.Division
    );

    public static Double calc(BinaryOperatorCode operatorCode, Double a, Double b)
    {
        return m_binaryOperators.get(operatorCode).apply(a, b);
    }

    public static Double calc(String binaryOperatorName, Double a, Double b)
    {
        return calc(getBinaryOperatorCode(binaryOperatorName), a, b);
    }

    public static BinaryOperatorCode getBinaryOperatorCode(String operatorName)
    {
        return m_binaryOperatorNames.get(operatorName);
    }
}
