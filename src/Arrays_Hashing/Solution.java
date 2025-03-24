package Arrays_Hashing;

import java.util.*;
import java.util.stream.Collectors;

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
        return null;
    }

    /**
     * Given an array of strings strs, group all anagrams together into sublists.
     * You may return the output in any order.
     * @param strs ["act","pots","tops","cat","stop","hat"]
     * @return [["hat"],["act", "cat"],["stop", "pots", "tops"]]
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedS = new String(charArray);
            res.putIfAbsent(sortedS, new ArrayList<>());
            res.get(sortedS).add(s);
        }
        return new ArrayList<>(res.values());
    }

    /**
     * Given an integer array nums and an integer k, return the k most frequent elements within the array.
     * The test cases are generated such that the answer is always unique.
     * @param nums integer array
     * @param k integer
     * @return [2,3]
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            heap.offer(new int[]{entry.getValue(), entry.getKey()});
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll()[1];
        }
        return res;
    }

    /**
     * Encode a list of strings to a single string. Delimiter is Length# (24#).
     * @param strs ["Aboba", "Biba"]
     * @return "5#Aboba4#Biba
     */
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append("#").append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        char[] chars = str.toCharArray();
        int startIndex = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '#') {
                int strLength = Integer.parseInt(String.valueOf(chars, startIndex, i - startIndex));
                res.add(str.substring(i + 1, i + strLength + 1));
                i += strLength;
                startIndex = i + 1;
            }
        }
        return res;
    }

    /**
     * Given an integer array nums, return an array output where output[i] is the product
     * of all the elements of nums except nums[i].
     * @param nums
     * @return array int of products nums except nums[i]
     */
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        int pref = 1;
        int post = 1;
        for (int i = 1; i < nums.length; i++) {
            pref *= nums[i - 1];
            res[i] = pref;
        }

        for (int i = nums.length - 2; i > -1; i--) {
            post *= nums[i + 1];
            res[i] = res[i] * post;
        }
        return res;
    }

    /**
     * Return true if the Sudoku board is valid, otherwise return false.
     * @param board Matrix of Sudoku board. Empty cell is '.'
     *     board =
     * [["1","2",".",".","3",".",".",".","."],
     *  ["4",".",".","5",".",".",".",".","."],
     *  [".","9","8",".",".",".",".",".","3"],
     *  ["5",".",".",".","6",".",".",".","4"],
     *  [".",".",".","8",".","3",".",".","5"],
     *  ["7",".",".",".","2",".",".",".","6"],
     *  [".",".",".",".",".",".","2",".","."],
     *  [".",".",".","4","1","9",".",".","8"],
     *  [".",".",".",".","8",".",".","7","9"]]
     * @return true if valid, otherwise false
     */
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> rowSet = new HashSet<>();
            Set<Character> colSet = new HashSet<>();

            for (int j = 0; j < 9; j++) {

                if (board[i][j] != '.')
                    if (rowSet.contains(board[i][j]))
                        return false;

                if (board[j][i] != '.')
                    if (colSet.contains(board[j][i]))
                        return false;

                rowSet.add(board[i][j]);
                colSet.add(board[j][i]);
            }
        }
        for (int rowStep = 0; rowStep < 9; rowStep += 3) {
            for (int colStep = 0; colStep < 9; colStep += 3) {

                Set<Character> boxSet = new HashSet<>();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (board[rowStep + i][colStep + j] == '.')
                            continue;
                        if (boxSet.contains(board[rowStep + i][colStep + j]))
                            return false;
                        boxSet.add(board[rowStep + i][colStep + j]);
                    }
                }
            }
        }
        return true;
    }

    /**
     * Given an array of integers nums,
     * return the length of the longest consecutive sequence of elements that can be formed.
     * _
     * A consecutive sequence is a sequence of elements in which each element is exactly 1 greater
     * than the previous element. The elements do not have to be consecutive in the original array.
     * @param nums array of integers
     * @return length of the longest consecutive sequence
     */
    public int longestConsecutive(int[] nums) {
        int longest = 0;
        HashSet<Integer> numsSet = (HashSet<Integer>) Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toSet());

        for (int num : numsSet) {
            if (!numsSet.contains(num - 1)) {
                int currentLength = 1;
                int currentNum = num;
                while (numsSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }
                longest = Math.max(currentLength, longest);
            }
        }

        return longest;
    }


}
