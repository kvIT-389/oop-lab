package io;

import java.io.PrintStream;


public class StreamWriter {
    private PrintStream m_printStream;

    private String m_lineSeparator = "\n";

    public StreamWriter() {}

    public StreamWriter(PrintStream printStream) {
        m_printStream = printStream;
    }

    public void print(Object obj) {
        m_printStream.print(obj);
    }

    public void printLine() {
        m_printStream.print(m_lineSeparator);
    }

    public void printLine(Object obj) {
        m_printStream.print(obj);
        printLine();
    }
}
