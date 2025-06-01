/*
Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

Example 1:
Input: nums = [3,0,1]
Output: 2
Explanation:
n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.

Example 2:
Input: nums = [0,1]
Output: 2
Explanation:
n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
*/
//Approach - 1 Using index and sorting TC - O(nlogn) SC - O(1)
class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(i!=nums[i]){
                return i;
            }
        }
        return n;
    }
}
//Appraoch - 2 Optimal approach TC - O(n) SC - O(1)
class Solution {
    public int missingNumber(int[] nums) {
        int l = nums.length;
        int Esum = 0;
        for(int n : nums) {
            Esum += n;
        }
        return l * (l + 1) / 2 - Esum;
    }
}