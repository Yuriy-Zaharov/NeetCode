package Two_Pointers;

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
}
