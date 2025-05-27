/*
You are given positive integers n and m.

Define two integers as follows:

num1: The sum of all integers in the range [1, n] (both inclusive) that are not divisible by m.
num2: The sum of all integers in the range [1, n] (both inclusive) that are divisible by m.
Return the integer num1 - num2.
*/

//Approach - 1 TC - O(n) SC - O(1)
//Simpler naive approach
class Solution {
    public int differenceOfSums(int n, int m) {
        int sumDiv=0;
        int sumNoDiv=0;
        while(n>0){
            if(n%m==0) sumDiv+=n;
            else sumNoDiv+=n;
            n--;
        }
        return sumNoDiv-sumDiv;
    }
}

//However there exist another approach using the mathematic part by simply calculating the total sum and sum of the divisible num
//Approach - 2 TC - O(1) SC - O(1)
class Solution {
    public int differenceOfSums(int n, int m) {
        int sumAll = n * (n + 1) / 2; //First we calculated sum of every num
        int countDivByM = n / m; //Count of num divisible by m
        int sumDivisible = m * countDivByM * (countDivByM + 1) / 2; //Sum of divisible num
        return sumAll - 2 * sumDivisible;
    }
}

//n = 10, m = 3
/* Total sum = (1 + 2 + 3 + ... + 10) = (10 * 11) /2 = 55
Numbers divisible by 3 are 3, 6, 9 --> count = 10 / 3 = 3 numbers are there 
Sum of numbers divisible by 3 --> sumDivisible = (3 + 6 + 9) = 3 * (1 + 2 + 3) = 3 * [3 * (3 + 1) / 2] = 18
Total sum = 55
sumDivisible = 18
now we can calculate the sumNotDivisible
*/