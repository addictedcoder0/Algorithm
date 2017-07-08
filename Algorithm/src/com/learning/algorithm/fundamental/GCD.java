package com.learning.algorithm.fundamental;

/**
 * Created by abhishek.
 */
public class GCD {
    public static void main(String[] args) {
        //Normal Cases
        calculateGCD(10L,4L);
        calculateGCD(100000L,4534223L);
        calculateGCD(123123123123123L,20L);
        calculateGCD(565,55555555);
        calculateGCD(25,625);

        //Edge Cases
        calculateGCD(0L,0L);
        calculateGCD(0L,5L);
        calculateGCD(5L,0L);
        calculateGCD(-1L,0L);
        calculateGCD(-100L,-25L);

    }


    private static void calculateGCD(long bigNumber , long smallNumber){
        //handle the negative number case
        /*
        gcd{a,b}=gcd{|a|,b}=gcd{a,|b|}=gcd{|a|,|b|}
        Alternatively, this can be put:
        gcd{a,b}=gcd{−a,b}=gcd{a,−b}=gcd{−a,−b}
        */

        System.out.println("[Recursive] GCD of { "+bigNumber+" , "+smallNumber+" } is => "+ euclideanGCDRecursive(Math.abs(bigNumber), Math.abs(smallNumber)));
        System.out.println("[NonRecursive] GCD of { "+bigNumber+" , "+smallNumber+" } is => "+ euclideanGCDNonRecursive(Math.abs(bigNumber), Math.abs(smallNumber)));
    }

    //Euclidean method to calculate the GCD
    private static long euclideanGCDRecursive(long bigNumber, long smallNumber){
        //handling the wrong/misplaced argument case
        if (bigNumber<smallNumber){
            bigNumber = (bigNumber+smallNumber);
            smallNumber = bigNumber-smallNumber;
            bigNumber = bigNumber-smallNumber;
        }

        // handling dividedByZero case
        if(smallNumber!=0){
            return euclideanGCDRecursive(smallNumber, bigNumber % smallNumber);
        }else{
            return bigNumber;
        }
    }

    //efficient : as it will not generate unnecessary stack-frames on recursive call
    private static long euclideanGCDNonRecursive(long bigNumber , long smallNumber){
        //handling the wrong/misplaced argument case
        if (bigNumber<smallNumber){
            bigNumber = (bigNumber+smallNumber);
            smallNumber = bigNumber-smallNumber;
            bigNumber = bigNumber-smallNumber;
        }

        while (smallNumber!=0L) {
            long nextBigNumber = smallNumber;
            smallNumber = bigNumber%smallNumber;
            bigNumber = nextBigNumber;
        }
        return bigNumber;
    }
}
