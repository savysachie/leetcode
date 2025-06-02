/*
Given an array arr[] consisting of only 0’s and 1’s, return count of a maximum number of consecutive 1’s or 0’s present in the array. 

Examples:
Input: arr[] = [1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1]
Output: 4
Explanation: The maximum number of consecutive 1’s in the array is 4 from index 8-11.
Input: arr[] = [0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1]
Output: 2
Explanation: The maximum number of consecutive 0’s in the array is 2 from index 0-1.
*/
//Approach -> TC - O(n) SC - O(1)
class Solution {
    public int maxConsecutiveCount(int[] arr) {
        // code here
        if(arr.length == 0) return 1;
        int max = 1;
        int curr = 1;
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] == arr[i - 1]) curr++;
            else  curr = 1;
            max = Math.max(max, curr);
        }
        return max;
    }
}