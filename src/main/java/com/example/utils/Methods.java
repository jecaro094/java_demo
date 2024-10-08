package com.example.utils;

public class Methods {
    public static void someTest() {
        System.out.println("This is some test");
    }

    @Deprecated
    public static double executeFunction(char opCode, double leftVal, double rightVal){
        double result;
        switch(opCode){
            case 'a':
                result = leftVal + rightVal;
                break;
            case 'm':
                result = leftVal * rightVal;
                break;
            case 'd':
                result = rightVal != 0 ? leftVal / rightVal : 0;
                break;
            case 's':
                result = leftVal - rightVal;
                break;
            default:
                System.out.println("Invalid opCode");
                result = 0;
            break;
        }
        return result;
    }

}
