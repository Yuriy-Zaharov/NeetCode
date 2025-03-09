import Arrays_Hashing.Solution;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        String encodedString = sol.encode(List.of("aboba", "baboba", "kartoshka s tomatom aboba baboba Vatruha русский пакет попет попект"));
        System.out.println(encodedString);
        System.out.println();
        System.out.println(sol.decode(encodedString));

    }
}