package march;

// 멀리 뛰기
// https://school.programmers.co.kr/learn/courses/30/lessons/12914
public class Q2 {

    public static long solution(int n) {
        final int MOD = 1234567;
        if(n < 3)
            return n;

        long[] dp = new long[n + 1];
        dp[1] = 1L;
        dp[2] = 2L;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }
        return dp[n];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(solution(1)); // 5
        System.out.println(solution(4)); // 5
        System.out.println(solution(3)); // 3
    }
}
