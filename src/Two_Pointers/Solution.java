package Two_Pointers;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * Given a string s, return true if it is a palindrome, otherwise return false.
     * @param s string palindrome
     * @return valid true/ not valid false
     */
    public boolean isPalindrome(String s) {
        String sAlphabetic = s.toLowerCase().replaceAll("[^a-zA-Z]", "");

        for (int i = 0; i < sAlphabetic.length() / 2; i++) {
            if (sAlphabetic.charAt(i) != sAlphabetic.charAt(sAlphabetic.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int tmp = target - numbers[i];
            if (mp.containsKey(tmp)) {
                return new int[] { mp.get(tmp), i + 1 };
            }
            mp.put(numbers[i], i + 1);
        }
        return new int[0];
    }
}
