package Two_Pointers;

import java.util.*;

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
        return null;
    }

    /**
     * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
     * where nums[i] + nums[j] + nums[k] == 0, and the indices i, j and k are all distinct.
     * The output does not contain any duplicate triplets.
     * @param nums integer array
     * @return all the triplets [nums[i], nums[j], nums[k]]
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays_Hashing.Solution solution = new Arrays_Hashing.Solution();
        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> setRes = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            int[] numsTemp = new int[nums.length - 1 - i];
            //System.arraycopy(nums, 0, numsTemp, 0, i); // Копируем часть до index
            System.arraycopy(nums, i + 1, numsTemp, 0, nums.length - i - 1); // Копируем часть после index

            int[] arrayTwo = solution.twoSum(numsTemp, -nums[i]);
            if (arrayTwo != null) {
                setRes.add(List.of(numsTemp[arrayTwo[0]], numsTemp[arrayTwo[1]], nums[i]));
            }
        }
        for (List<Integer> set : setRes) {
            res.add(new ArrayList<>(set));
        }

        return res;
    }
}
