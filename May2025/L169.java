/*
Given an array nums of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

Example 1:
Input: nums = [3,2,3]
Output: 3

Example 2:
Input: nums = [2,2,1,1,1,2,2]
Output: 2
*/

//Approach - 1 TC - O(nlogn) SC - O(1)
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        if(nums.length == 1) return nums[0];

        int count = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i - 1] == nums[i]) count++;
            else count = 1;
            if(count > nums.length / 2) return nums[i];
        }

        return 0;
    }
}

//Approach - 2 TC - O(n) SC - O(n)
//used HashMap to store the count of elements
class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
                return entry.getKey();
            }
        }

        return -1;
    }
}

//Approach - 3 TC - O(n) SC - O(1)
//using the voting algorithm
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        for(int n : nums) {
            if(count == 0) candidate = n;
            if(candidate == n) count++;
            else count--;
        }
        
        return candidate;
    }
}