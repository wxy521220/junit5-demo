package com.demo;

public class Calculate {

    public static int result=0;

    public static int add(int x,int y){
        int result=x+y;
        return result;
    }
    public static int subtract(int x,int y){
        int  result=x-y;
        return result;
    }
    public static int multiply(int x,int y){
        int result=x*y;
        return result;
    }
    public static int divide(int x,int y){
         int result=x/y;
        return result;
}
    public static int count(int x){
        result=result+x;
        return result;
    }
    public synchronized static int countSyn(int x){
        result=result+x;
        return result;
    }
    public static void clear(){
        result=0;
        System.out.println("当前结果已经清零");
    }


}
