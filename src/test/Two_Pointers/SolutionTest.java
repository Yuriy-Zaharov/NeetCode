package Two_Pointers;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void isPalindrome() {
    }

    @Test
    void twoSum() {
    }

    @Test
    void threeSum() {
        Solution solution = new Solution();
        List<List<Integer>> res = solution.threeSum(new int[] {-1,0,1,2,-1,-4});
        System.out.println(res);
    }
}