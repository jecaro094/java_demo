package com.example.utils;

public class ArraysBlockStructures {
    public static void conditionalAssignment() {
        int num_1 = 2;
        int num_2 = 3;
        var condition = num_1 == num_2;
        var x = condition ? "Numbers Equal" : "Numbers Not Equal";
        System.out.println(x);
    }

    public static void ifElse() {
        int num_1 = 2;
        int num_2 = 3;
        boolean condition = num_1 == num_2;
        if(num_1==3)
            System.out.println("Number is 3");
        else if(num_1==2)
            System.out.println("Numbers is 2");
        else
            System.out.println("No condition met");
        
    }

    public static void letsGetLogical() {
        int students = 23;
        int rooms = 0;

        if (rooms != 0 && students/rooms > 30)
            System.out.println("Crowded!!");
        System.out.println("End of the program");
    }

    public static void forLoop() {
        int range = 12;
        for(int i = 0; i< range; i++){
            System.out.println("Output: " + i);
        }
    }

    public static void forEachLoop(){
        int[] arrayInt = {1, 2, 3};
        for(int element: arrayInt)
            System.out.println(element);
    }

    public static void arraysMethod(){
        char[] opCodes = {'d', 'a', 's', 'm'};
        double[] results = new double[opCodes.length];

        for(int i=0; i<opCodes.length; i++){
            switch(opCodes[i]){
                case('a'):
                    results[i] = opCodes[i];
                    break;
                default:
                    results[i] = opCodes[i];
                break;
            }
        }
    }
}
