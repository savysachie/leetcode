/*
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
You must solve this problem without using the library's sort function.

Example 1:
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:
Input: nums = [2,0,1]
Output: [0,1,2]
*/
//Approach - 1 TC - O(n) SC - O(1)
class Solution {
    public void sortColors(int[] nums) {
        int[] freq = new int[3];
        for(int n : nums) {
            freq[n]++;
        }
        int i = 0;
        for(i = 0; i < freq[0]; i++) {
            nums[i] = 0;
        }
        for(; i < freq[0] + freq[1]; i++) {
            nums[i] = 1;
        }
        for(; i < freq[0] + freq[1] + freq[2]; i++) {
            nums[i] = 2;
        }
    }
}
//Approach - 2 TC - O(n) SC - O(1)
class Solution {
    public void sortColors(int[] nums) {
        int n=nums.length;
        int i=0; //denotes 0
        int j=0; //denotes 1
        int k=nums.length-1; //denotes 2

        while(j<=k){
            if(nums[j]==1){
                j++;
            }
            else if(nums[j]==2){
                int temp=nums[k];
                nums[k]=nums[j];
                nums[j]=temp;
                k--;
            }
            else{
                int temp2=nums[i];
                nums[i]=nums[j];
                nums[j]=temp2;
                i++;
                j++;
            }
        }
    }
}