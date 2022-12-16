package io;

import java.io.InputStream;
import java.util.Scanner;


public class StreamReader {
    private Scanner m_streamScanner;

    public StreamReader() {}

    public StreamReader(InputStream inputStream) {
        m_streamScanner = new Scanner(inputStream);
    }

    public String readLine() {
        return m_streamScanner.nextLine();
    }

    public String readLine(String regex) throws MatchException {
        String result = readLine();

        if (result.matches(regex)) {
            throw new MatchException(
                "The input doesn't match given regex."
            );
        }

        return result;
    }

    public Integer readInteger() throws NumberFormatException {
        return Integer.parseInt(readLine());
    }

    public Integer readInteger(Integer leftBoundary,
                               Integer rightBoundary)
                               throws NumberFormatException,
                                      RangeException {
        Integer result = readInteger();

        if (result < leftBoundary || result > rightBoundary) {
            throw new RangeException(
                "The input is not in given range."
            );
        }

        return result;
    }

    public Double readDouble() throws NumberFormatException {
        return Double.parseDouble(readLine());
    }

    public Double readDouble(Double leftBoundary,
                             Double rightBoundary)
                             throws NumberFormatException,
                                    RangeException {
        Double result = readDouble();

        if (result < leftBoundary || result > rightBoundary) {
            throw new RangeException(
                "The input is not in given range."
            );
        }

        return result;
    }
}
