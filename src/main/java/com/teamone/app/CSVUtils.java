package com.teamone.app;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class CSVUtils {

    private static final char DEFAULT_SEPARATOR = ',';

    static void writeLine(Writer w, List<String> values) throws ExceptionAppLayer {
        writeLine(w, values, DEFAULT_SEPARATOR, ' ');
    }

    public static void writeLine(Writer w, List<String> values, char separators) throws ExceptionAppLayer {
        writeLine(w, values, separators, ' ');
    }

    private static String followCVSformat(String value) {

        String result = value;
        if (result.contains("\"")) {
            result = result.replace("\"", "\"\"");
        }
        return result;
    }

    private static void writeLine(Writer w, List<String> values, char separators, char customQuote) throws ExceptionAppLayer {

        boolean first = true;

        try {
            if (separators == ' ') {
                separators = DEFAULT_SEPARATOR;
            }

            StringBuilder sb = new StringBuilder();
            for (String value : values) {
                if (!first) {
                    sb.append(separators);
                }
                if (customQuote == ' ') {
                    sb.append(followCVSformat(value));
                } else {
                    sb.append(customQuote).append(followCVSformat(value)).append(customQuote);
                }

                first = false;
            }
            sb.append("\n");
            w.append(sb.toString());
        } catch (IOException exe) {
            throw new ExceptionAppLayer("CSVUtils writeLine", exe);
        }
    }
}
