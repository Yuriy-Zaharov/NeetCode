package Arrays_Hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    /**
     * Given an integer array nums, return true if any value appears more than once in the array, otherwise return false.
     * @param nums integer array
     * @return true/false
     */
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> hashSetInt = new HashSet<>();
        for (int num : nums) {
            if (hashSetInt.contains(num)) {
                return true;
            }
            hashSetInt.add(num);
        }
        return false;
    }

    /**
     * Given two strings s and t, return true if the two strings are anagrams of each other, otherwise return false.
     * @param s String 1
     * @param t String 2
     * @return true/false
     */
    public boolean isAnagramArrayChar(String s, String t) {
        if (s.length() != t.length()) { return false; }

        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        Arrays.sort(sChar);
        Arrays.sort(tChar);

        return Arrays.equals(sChar, tChar);
    }

    /**
     * Given two strings s and t, return true if the two strings are anagrams of each other, otherwise return false.
     * @param s String 1
     * @param t String 2
     * @return true/false
     */
    public boolean isAnagramHashMap(String s, String t) {
        if (s.length() != t.length()) { return false; }

        HashMap<Character, Integer> sHashMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            sHashMap.put(c, sHashMap.getOrDefault(c, 0) + 1);
        }
        HashMap<Character, Integer> tHashMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tHashMap.put(c, tHashMap.getOrDefault(c, 0) + 1);
        }
        return sHashMap.equals(tHashMap);
    }

    /**
     * Given two strings s and t, return true if the two strings are anagrams of each other, otherwise return false.
     * @param s String 1
     * @param t String 2
     * @return true/false
     */
    public boolean isAnagramArrayOptimal(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int val : count) {
            if (val != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Given an array of integers nums and an integer target,
     * return the indices i and j such that nums[i] + nums[j] == target and i != j.
     * @param nums array of integers
     * @param target target int
     * @return [i, j] indices i and j such that nums[i] + nums[j] == target and i != j
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMapNums = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMapNums.containsKey(target - nums[i])) {
                return new int[]{hashMapNums.get(target - nums[i]), i};
            }
            else {
                hashMapNums.put(nums[i], i);
            }
        }
        return new int[] {};
    }
}
