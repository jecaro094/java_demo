package com.example.utils;

import java.util.Scanner;

public class Strings {
    public static void someFunc(){
        System.out.println("Some string function...");
    }

    // Remember to have a look at String class methods (useful)
    // Maybe use ChatGPT for that purpose.

    private static char opCodeFromString(String operationName){
        return operationName.charAt(0);
    }

    private static double valueFromWord(String word){
        String[] numberWords = {
            "zero", "one", "two", "three", "four",
            "five", "six", "seven", "eight", "nine",
        };
        double value = 0;
        for(int index = 0; index < numberWords.length; index++){
            if(word.equals(numberWords[index])){
                value = index;
                break;
            }
        }
        return value;
    }

    
    private static void performOperations(String[] parts) {
        char opCode = opCodeFromString(parts[0]);
        double leftVal = valueFromWord(parts[1]);
        double rightVal = valueFromWord(parts[2]);
        double result = Methods.executeFunction(opCode, leftVal, rightVal);
        // System.out.println(result);
        displayResult(opCode, leftVal, rightVal, result);
    }

    public static String displayResult(char opCode, double leftVal, double rightVal, double result) {
        char symbol = symbolFromOpCode(opCode);

        // In terms of efficency, it is better for memory to use 'StringBuilder'
        // rather than 'String'

        // Because strings are immutable, and changes in the value create a new
        // string instance
        
        StringBuilder sb = new StringBuilder(20);

        sb.append(leftVal);
        sb.append(" ");
        sb.append(symbol);
        sb.append(" ");
        sb.append(rightVal);
        sb.append(" = ");
        sb.append(result);
        return sb.toString();
    }

    private static char symbolFromOpCode(char opCode){
        char[] opCodes = {'a', 's', 'm', 'd'};
        char[] symbols = {'+', '-', '*', '/'};
        char symbol = ' ';
        for(int index=0; index<opCodes.length; index++){
            if(opCode == opCodes[index]){
                symbol = symbols[index];
                break;
            }
        }
        return symbol;
    }
    
    public static void executeInteractively(){
        System.out.println("Enter an operation and 2 numbers...");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String[] parts = userInput.split(" ");
        performOperations(parts);
    }
}
