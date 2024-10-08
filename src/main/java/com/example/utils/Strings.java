package com.example.utils;

import java.util.Scanner;

import com.example.MathEquation;
import com.example.MathOperation;

public class Strings {
    public static void someFunc(){
        System.out.println("Some string function...");
    }

    // Remember to have a look at String class methods (useful)
    // Maybe use ChatGPT for that purpose.
    @Deprecated
    private static char opCodeFromString(String operationName){
        return operationName.charAt(0);
    }

    private static double valueFromWord(String word){
        String[] numberWords = {
            "zero", "one", "two", "three", "four",
            "five", "six", "seven", "eight", "nine",
        };
        boolean isValueSet  = false;
        double value = 0;
        for(int index = 0; index < numberWords.length; index++){
            if(word.equals(numberWords[index])){
                value = index;
                isValueSet = true;
                break;
            }
        }
        if(!isValueSet)
            value = Double.parseDouble(word);
        return value;
    }

    
    public static void performOperation(String[] parts) {
        MathOperation opCode = MathOperation.valueOf(parts[0].toUpperCase());
        double leftVal = valueFromWord(parts[1]);
        double rightVal = valueFromWord(parts[2]);
        MathEquation equation = new MathEquation(opCode, leftVal, rightVal);
        equation.execute();
        System.out.println(equation);
    }

    public static String displayResult(MathOperation opCode, double leftVal, double rightVal, double result) {
        // char symbol = symbolFromOpCode(opCode);
        char symbol = opCode.getSymbol();

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

    @Deprecated 
    private static char symbolFromOpCode(MathOperation opCode){
        MathOperation[] opCodes = {
            MathOperation.ADD, 
            MathOperation.SUBSTRACT, 
            MathOperation.MULTIPLY, 
            MathOperation.DIVIDE
        };
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
        performOperation(parts);
    }
}
