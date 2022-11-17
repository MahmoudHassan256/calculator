package com.example.calculator;

import org.apache.commons.lang3.StringUtils;
import com.fathzer.soft.javaluator.DoubleEvaluator;

public class ArithmeticApp {
    public static String expression;
    public static String result;
    public ArithmeticApp(String expression){
        this.expression=expression;
        main(null);
    }
    public String getResult(){
        return result;
    }
    public static void main(String[] Args) {
        int dobuleResult;
        if (!CheckCorrect(expression.strip())) {
            result= "Error: invalid expression: " + expression;
        } else {
            dobuleResult = (int)calc(expression);
            if (1 / dobuleResult == 0) {
                result= "Error: divide by zero.";
            }
            String hex = doubletoHex(dobuleResult);
            result=hex;
            }
        }


    private static boolean isHex(Character c) {
        return c.toString().matches("[A-F0-9]");
    }

    private static double hextoDouble(String hex) {
        String digits = "0123456789ABCDEF";
        return digits.indexOf(hex);
    }

    private static boolean CheckCorrect(String expression) {

        if (!StringUtils.containsOnly(expression, "ABCDEF0123456789+-/* ")) {
            return false;
        } else {
            int i = 0;
            int maxSize = expression.length();
            String hexValue = "+*/";
            if (maxSize == 0) return false;
            if (hexValue.indexOf(expression.charAt(0)) >= 0) {
                return false;
            }
            if (expression.charAt(0) == '-' && maxSize == 1) {
                return false;
            }
            hexValue += "-";
            if (hexValue.indexOf(expression.charAt(maxSize - 1)) >= 0) {
                return false;
            }
            while (i < maxSize) {
                boolean doubleOperators = (i + 1 < maxSize);
                if (doubleOperators && (expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*' || expression.charAt(i) == '/')) {
                    if (expression.charAt(i + 1) == '*' || expression.charAt(i + 1) == '/') {//not valid
                        return false;
                    }
                    i++;
                }
                i++;
            }
        }
        return true;
    }

    private static double calc(String expression) {
        String doubleString = "";
        double tempDouble = 0;
        if (expression.charAt(0) == '-') {
            expression = "0".concat(expression);
        }
        int i = 0, maxSize = expression.length();
        while (i < maxSize) {
            while (i < maxSize && !isHex(expression.charAt(i))) {
                doubleString=doubleString.concat(""+expression.charAt(i));
                i++;
            }
            while (i < maxSize && isHex(expression.charAt(i))) {
                tempDouble *= 16;
                tempDouble += hextoDouble("" + expression.charAt(i));
                i++;
            }
            doubleString=doubleString.concat(""+tempDouble);
            tempDouble = 0;
        }
        DoubleEvaluator doubleevaluator = new DoubleEvaluator();
        return doubleevaluator.evaluate(doubleString);
    }

    private static String doubletoHex(double number) {
        String hexResult = "";
        String digits = "0123456789ABCDEF";
        while (number >= 1) {
            hexResult=hexResult.concat(""+digits.charAt((int) number % 16));
            number /= 16;
        }
        hexResult = StringUtils.reverse(hexResult);
        return hexResult;
    }
}