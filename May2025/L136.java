/*
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
You must implement a solution with a linear runtime complexity and use only constant extra space.

Example 1:
Input: nums = [2,2,1]
Output: 1
Example 2:
Input: nums = [4,1,2,1,2]
Output: 4
*/

//Approach - 1 {As mentioned in the description} TC - O(n) but SC - O(n)
class Solution {
    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int n : nums) {
            if(set.contains(n)) set.remove(n);
            else set.add(n);
        }
        return set.iterator().next();
    }
}

//Approach - 2 TC - O(n) SC - O(1)
class Solution {
    public int singleNumber(int[] nums) {
        int xor = 0;
        for(int n : nums) xor ^= n;
        return xor;
    }
}

//Approach - 3 TC - O(nlogn) SC - O(1)
class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int itr = 0;
        for(itr = 0; itr < nums.length-1;) 
            if(nums[itr] != nums[itr + 1]) return nums[itr];
            else itr += 2;
        return nums[itr];
    }
}