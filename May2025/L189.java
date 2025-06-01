/*
Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

Example 1:
Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]

Example 2:
Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
*/

//Approach - 1 BRUTE FORCE TC - O(K*N) SC - O(1)
class Solution {
    public void rotate(int[] nums, int k) {
        for(int i = 0; i < k; i++) {
            int last = nums[nums.length - 1];
            for(int j = nums.length - 2; j >= 0; j--) {
                nums[j + 1] = nums[j];
            }
            nums[0] = last;
        }
    }
}
//Approach - 2 Using another array TC - O(n) SC - O(n)
class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int[] result = new int[len];
        for(int i = 0; i < len; i++) {
            result[(i + k) % len] = nums[i];
        }
        System.arraycopy(result, 0, nums, 0, len);
    }
}
//Approach - 3 Optimal Approach
//TC - O(n) SC - O(1)
class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        if(k < 0) {
            k += nums.length;
        }
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        int left = start;
        int right = end;

        while(left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}