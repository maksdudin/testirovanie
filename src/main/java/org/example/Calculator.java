package org.example;
public class Calculator {
    private static int ACTION_AMOUNT=0;

    public static int getAthionAmount() {
        return ACTION_AMOUNT;
    }



    public int add(int a, int b){
        ACTION_AMOUNT++;
        return a+b;
    }
    public static void reserAthionAmount(){
        ACTION_AMOUNT=0;
    }
}
