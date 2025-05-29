/*
An array is considered special if the parity of every pair of adjacent elements is different. In other words, one element in each pair must be even, and the other must be odd.
You are given an array of integers nums. Return true if nums is a special array, otherwise, return false.

Example 1:
Input: nums = [1]
Output: true
Explanation:
There is only one element. So the answer is true.

Example 2:
Input: nums = [2,1,4]
Output: true
Explanation:
There is only two pairs: (2,1) and (1,4), and both of them contain numbers with different parity. So the answer is true.
*/

//Approach - 1 (The only approach) TC - O(n) SC - O(1)
class Solution {
    public boolean isArraySpecial(int[] nums) {
        if(nums.length == 1) return true;
        for(int i = 1; i < nums.length; i++) {
            if((nums[i] % 2 == 1 && nums[i-1] % 2 == 1) || (nums[i] % 2 == 0 && nums[i-1] % 2 == 0)) 
                return false;
        }
        return true;
    }
}