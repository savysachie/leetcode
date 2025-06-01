/*
You are given a 0-indexed array of strings words and a character x.
Return an array of indices representing the words that contain the character x.
Note that the returned array may be in any order.

Example 1:
Input: words = ["leet","code"], x = "e"
Output: [0,1]
Explanation: "e" occurs in both words: "leet", and "code". Hence, we return indices 0 and 1.

Example 2:
Input: words = ["abc","bcd","aaaa","cbc"], x = "a"
Output: [0,2]
Explanation: "a" occurs in "abc", and "aaaa". Hence, we return indices 0 and 2.
*/
//Approach - 1 TC - O(n * m) SC - O(k)
//k is the number of matching indices stored in the result list.
// n = number of words in the array
// m = average length of each word
class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        String s = Character.toString(x);
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < words.length; i++) {
            if(words[i].contains(s)) res.add(i);
        }
        return res;
    }
}
//Approach - 2 same as previous TC n SC
class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < words.length; i++) {
            if(words[i].indexOf(x) != -1) res.add(i);
        }
        return res;
    }
}