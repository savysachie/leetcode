/*
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
There is only one repeated number in nums, return this repeated number.
You must solve the problem without modifying the array nums and using only constant extra space.

Example 1:
Input: nums = [1,3,4,2,2]
Output: 2
*/
//Approach - 1 Brute Force TC - O(n^2) SC - O(1)
//TIME LIMIT EXCEEDED
class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int num = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    if (nums[i] == nums[j]) {
                        num = nums[i];
                    }
                }
            }
        }

        return num;
    }
}
//Approach - 2 TC - O(n) SC - O(1)
class Solution {
    public int findDuplicate(int[] nums) {
        int slow=nums[0];
        int fast=nums[0]; 
        slow=nums[slow];
        fast=nums[nums[fast]];

        //detect cycle
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[nums[fast]];
        }
        slow=nums[0];
        //detect the value
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }
        return fast;
    }
}