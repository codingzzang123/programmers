package march;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/15651
자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
1부터 N까지 자연수 중에서 M개를 고른 수열
같은 수를 여러 번 골라도 된다.

* */
public class B_Q4 {
    static int N, M;
    static int[] queue;
    static boolean[] v;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        // N 까지의 숫자 중 M개를 고른 수열. 가지수 => M개
        queue = new int[M];
        v = new boolean[N + 1];

        backtracking(0);
        System.out.println(sb);
    }

    static void backtracking(int depth) {
        if(depth == M) {
            for(int v : queue){
                sb.append(v);
                sb.append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1; i<= N; i++) {
            queue[depth] = i;
            backtracking(depth + 1);
        }
    }
}
