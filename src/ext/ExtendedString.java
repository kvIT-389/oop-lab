package ext;

import java.util.Scanner;
import java.util.Stack;
import java.util.StringJoiner;


public class ExtendedString {
    private String m_string;

    public ExtendedString()
    {
        m_string = new String();
    }

    public ExtendedString(String string)
    {
        m_string = string;
    }

    public String toString()
    {
        return m_string;
    }

    public Integer countCharacters(Character chars[])
    {
        Integer count = 0;

        for (Character ch : chars) {
            for (Character str_char : m_string.toCharArray()) {
                if (str_char.equals(ch)) {
                    ++count;
                }
            }
        }

        return count;
    }

    public ExtendedString reversedWordsOrder()
    {
        Scanner line = new Scanner(m_string);

        Stack<String> words = new Stack<String>();
        while (line.hasNext()) {
            words.push(line.next());
        }

        line.close();

        StringJoiner jnr = new StringJoiner(" ");
        while (!words.isEmpty()) {
            jnr.add(words.pop());
        }

        return new ExtendedString(jnr.toString());
    }
}
