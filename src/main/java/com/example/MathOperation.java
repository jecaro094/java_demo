package com.example;

public enum MathOperation {
    ADD('+'),
    SUBSTRACT('-'),
    MULTIPLY('*'),
    DIVIDE('/');
    
    private char symbol;
    public char getSymbol(){ return symbol; }

    private MathOperation(char symbol){
        this.symbol = symbol;
    }
}
