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

    @Test
    void isValidSudoku() {
        Solution sol = new Solution();
        char[][] board = {{'1','2','.','.','3','.','.','.','.'},
 {'4','.','.','5','.','.','.','.','.'},
 {'.','9','8','.','.','.','.','.','3'},
 {'5','.','.','.','6','.','.','.','4'},
 {'.','.','.','8','.','3','.','.','5'},
 {'7','.','.','.','2','.','.','.','6'},
 {'.','.','.','.','.','.','2','.','.'},
 {'.','.','.','4','1','9','.','.','8'},
 {'.','.','.','.','8','.','.','7','9'}};

        assertTrue(sol.isValidSudoku(board));

        char [][] board2 = {{'8','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}};
        assertFalse(sol.isValidSudoku(board2));
    }
}