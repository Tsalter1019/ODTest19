package com.basicKnowledge;


public class Prime {


    public static void main(String[] args) {
        System.out.println(isPrimeOrNot(2));
        System.out.println(isPrimeOrNot(3));
        System.out.println(isPrimeOrNot(5));
        System.out.println(isPrimeOrNot(7));
        System.out.println(isPrimeOrNot(11));
        System.out.println(isPrimeOrNot(13));
        System.out.println(isPrimeOrNot(17));

        System.out.println("--------------");

        System.out.println(isPrimeOrNot(4));
        System.out.println(isPrimeOrNot(6));
        System.out.println(isPrimeOrNot(8));
        System.out.println(isPrimeOrNot(9));
        System.out.println(isPrimeOrNot(10));
        System.out.println(isPrimeOrNot(12));
        System.out.println(isPrimeOrNot(14));
        System.out.println(isPrimeOrNot(15));
        System.out.println(isPrimeOrNot(16));
    }

    private static boolean isPrimeOrNot(int x){
        int j = 0;
        for(j=2;j<Math.sqrt(x);j++){
            if(x%j==0){
                break;
            }
        }
        if(j > Math.sqrt(x)){
            return true;
        }else{
            return false;
        }
    }
}