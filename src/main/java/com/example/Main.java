package com.example;

import com.example.utils.*;
import com.example.MathEquation;

// COMPILE
// javac src/main/java/com/example/Main.java src/main/java/com/example/utils/*.java -d target/classes/

// RUN
// java -cp target/classes com.example.Main

// RUN WITH ARGUMENTS
// java -cp target/classes com.example.Main 'd' 100 10

public class Main {
    public static void main(String[] args) {
        performOperations();
    }



    public static void printLines(){
        System.out.println("This is the first line...");
        System.out.println("...and this is the second line...");
        System.out.println("...at last, this is the third line!");
    }

    public static void performOperations(){

        MathEquation[] equations = new MathEquation[4];
        equations[0] = new MathEquation('d', 100, 50);
        equations[1] = new MathEquation('a', 25, 92);
        equations[2] = new MathEquation('s', 225, 17);
        equations[3] = new MathEquation('m', 11, 3);
        for(MathEquation equation: equations){
            equation.execute();
            System.out.println(equation); // This will call to `toString()`
            // System.out.println("result: " + eq.getResult());
        }

        // Static methods are methods bounded to a class, and not to an object /
        // class instantiation.
        System.out.println("Average result = " + MathEquation.getAverageResult());


        // useOverloads();
    }

    static void useOverloads(){
        System.out.println();
        System.out.println("Using execute overloads...");   
        System.out.println();

        MathEquation equationOverload = new MathEquation('d');
        double leftVal = 9;
        double rightVal = 4;
        equationOverload.execute(leftVal, rightVal);
        System.out.println("Overload result with doubles: " + equationOverload.getResult());
    }

    private static MathEquation create(double leftVal, double rightVal, char opCode){
        MathEquation equation = new MathEquation();
        equation.setLeftValue(leftVal);
        equation.setRightValue(rightVal);
        equation.setOpCode(opCode);
        return equation;
    }

    public static void calculateOperation(){
        double[] leftVals = {100, 25, 225, 11};
        double[] rightVals = {50, 92, 17, 3};
        char[] opCodes = {'d', 'a', 's', 'm'};
        double[] results = new double[opCodes.length];

        for(int i = 0; i<opCodes.length; i++){
            results[i] = Methods.executeFunction(opCodes[i], leftVals[i], rightVals[i]);
        }
        System.out.println(results[0]);
    }

    public static void calculateOperationCommandLine(String[] args){
        double[] leftVals = {100, 25, 225, 11};
        double[] rightVals = {50, 92, 17, 3};
        char[] opCodes = {'d', 'a', 's', 'm'};
        double[] results = new double[opCodes.length];
        String interactiveStr = "interactive";

        if(args.length == 0){
            for(int i = 0; i<opCodes.length; i++){
                results[i] = Methods.executeFunction(opCodes[i], leftVals[i], rightVals[i]);
            }
            for(double res: results)
                System.out.println(res);
        } else if(args.length == 1 && args[0].equals(interactiveStr))
            Strings.executeInteractively();   
        else if(args.length == 3)
            handleCommandLine(args); 
        else
            System.out.println("Please provide an operation code and 2 numeric values...");
    }

    private static void handleCommandLine(String[] args) {
        char opCode = args[0].charAt(0);
        double leftVal = Double.parseDouble(args[1]);
        double rightVal = Double.parseDouble(args[2]);
        double result = Methods.executeFunction(opCode, leftVal, rightVal);
        System.out.println(result);
    }

}