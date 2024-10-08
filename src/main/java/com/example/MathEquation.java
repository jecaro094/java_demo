package com.example;

import com.example.utils.Strings;

public class MathEquation {
    private double leftVal;
    private double rightVal;
    private MathOperation opCode;
    private double result;

    // STATIC = Related to the class itself, and not the object
    // Static values can only be modified using static mathods...
    private static int numberOfCalculations;
    private static double sumOfResults;

    // INITIALIZATION BLOCK
    // Initialization blocks run no matter what, before any
    // constructor is called. 
    // Runs when object is created
    {
        // Code inside INITALIZATION BLOCK
    }


    // We can add several constructors in the same class
    // We can controll who can access the constructors by using `public` / `private`
    // The several constructors can use the other constructors
    // Once that we define a constructor, we need to be responsible for all the constructors,
    // because otherwise Java handles itself the default definition of constructor by 
    // usint MathEquation()
    public MathEquation(){}

    public MathEquation(MathOperation opCode){
        this.opCode = opCode;
    }

    public MathEquation(MathOperation opCode, double leftVal, double rightVal){
        this(opCode);
        this.leftVal = leftVal;
        this.rightVal = rightVal;
    }

    // It is like __str__ in Python
    @Override
    public String toString(){
        return "Equation: (" 
            + Strings.displayResult(opCode, leftVal, rightVal, result) 
            + ")";
    }

    public void execute(){
        switch(opCode){
            case ADD:
                result = this.leftVal + rightVal;
                break;
            case MULTIPLY:
                result = leftVal * rightVal;
                break;
            case DIVIDE:
                result = rightVal != 0 ? leftVal / rightVal : 0;
                break;
            case SUBSTRACT:
                result = leftVal - rightVal;
                break;
            default:
                System.out.println("Invalid opCode");
                result = 0;
            break;
        }
        numberOfCalculations ++;
        sumOfResults += result;

    }


    // Method Overloading
    public void execute(double leftVal, double rightVal){
        this.leftVal = leftVal;
        this.rightVal = rightVal;
        execute();
    }


    public static double getAverageResult(){
        return sumOfResults / numberOfCalculations;
    }

    // Because the attributes are PRIVATE, we can define GETTERS and SETTERS
    // (custom) to modify and get properties.
    public double getResult(){
        return this.result;
    }
    public void setLeftValue(double leftVal){
        this.leftVal = leftVal;
    }
    public void setRightValue(double rightVal){
        this.rightVal = rightVal;
    }
    public void setOpCode(MathOperation opCode){
        this.opCode = opCode;
    }
    
}
