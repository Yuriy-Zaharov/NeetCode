package Arrays_Hashing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void hasDuplicate() {
    }

    @Test
    void isAnagramArrayOptimal() {
    }

    @Test
    void twoSum() {
    }

    @Test
    void groupAnagrams() {
    }

    @Test
    void topKFrequent() {
    }

    @Test
    void encode() {
    }

    @Test
    void decode() {
    }

    @Test
    void productExceptSelf() {
        Solution sol = new Solution();
        int[] nums = {1, 2, 4, 6};
        int[] expected = {48, 24, 12, 8};
        int[] res = sol.productExceptSelf(nums);
        assertArrayEquals(expected, res);
    }
}