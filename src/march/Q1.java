package march;

import java.util.HashMap;
import java.util.Map;

// 피보나치 수
// https://school.programmers.co.kr/learn/courses/30/lessons/12945
public class Q1 {

    static Map<Integer, Integer> map = new HashMap<>();
    static final int MOD = 1234567;
    static int fib(int i) {
        Integer v = map.get(i);
        if (v != null) return v;

        int res = (fib(i - 1) + fib(i - 2)) % MOD;
        map.put(i, res);
        return res;
    }

    public static int solution(int n) {
        final int MOD = 1234567;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }
        return dp[n];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(solution(99999));
    }
}
