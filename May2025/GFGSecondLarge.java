/*
Given an array of positive integers arr[], return the second largest element from the array. If the second largest element doesn't exist then return -1.
Note: The second largest element should not be equal to the largest element.

Examples:
Input: arr[] = [12, 35, 1, 10, 34, 1]
Output: 34
Explanation: The largest element of the array is 35 and the second largest element is 34.
Input: arr[] = [10, 5, 10]
Output: 5
Explanation: The largest element of the array is 10 and the second largest element is 5.
*/
//Approach - 1 TC - O(2n) SC - O(1)
class Solution {
    public int getSecondLargest(int[] arr) {
        // code here
        if(arr.length == 2) return Math.min(arr[0], arr[1]);
        int first = -1;
        int second = -1;
        for(int n : arr) {
            first = Math.max(first, n);
        }
        for(int n : arr) {
            if(n != first) second = Math.max(second, n);
        }
        return second;
    }
}
//Approach - 2 TC - O(nlogn) SC - O(1)
class Solution {
    public int getSecondLargest(int[] arr) {
        // code here
        if(arr.length == 2) return Math.min(arr[0], arr[1]);
        Arrays.sort(arr);
        for(int i = arr.length - 2; i >= 0; i--) {
            if(arr[i] != arr[i + 1]) return arr[i];
        }
        return -1;
    }
}
//Approach - 3 TC - O(n) SC - O(1)
class Solution {
    public int getSecondLargest(int[] arr) {
        // code here
        if(arr.length < 2) return -1;
        if(arr.length == 2) return Math.min(arr[0], arr[1]);
        int first = -1;
        int second = -1;
        for(int n : arr) {
            if(n > first) {
                second = first;
                first = n;
            }
            else if(n != first && n > second) {
                second = n;
            }
        }
        return second;
    }
}