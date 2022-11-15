package ext;

import java.util.ArrayList;
import calc.Calculator;


public class ExtendedArray {
    private ArrayList<Double> m_array;

    public ExtendedArray() {}

    public void add(Double e)
    {
        m_array.add(e);
    }

    public void apply(String binaryOperatorName, Double arg)
    {
        m_array.replaceAll((a) -> {
            return Calculator.calc(
                binaryOperatorName, a, arg
            );
        });
    }
}