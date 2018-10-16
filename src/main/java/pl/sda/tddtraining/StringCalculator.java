package pl.sda.tddtraining;

import org.apache.commons.lang3.StringUtils;

public class StringCalculator {

    public static int adding(String data) {
        if (StringUtils.isBlank(data)) {
            return 0;
        }
        return tokenizeAndSum(data);
    }

    //;\n1;2
    private static int tokenizeAndSum(String data) {
        String delimiter = "[,\n]";
        if (data.startsWith("//")) {
            delimiter = String.valueOf(data.charAt(2));
            data = data.split("\n")[1];
        }
        String[] splitted = data.split(delimiter);
        int sum = 0;
        for (String s : splitted) {
            if (StringUtils.isNotBlank(s)) {
                sum = sum + Integer.parseInt(s.trim());
            }

        }
        return sum;
    }

}
