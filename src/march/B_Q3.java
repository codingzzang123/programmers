package march;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/15650
한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
수열은 사전 순으로 증가하는 순서로 출력해야 한다.

* */
public class B_Q3 {
    static int N, M;
    static int[] path;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        path = new int[M];
        visited = new boolean[N + 1];

        backtracking(0);
        System.out.println(sb);
    }

    static void backtracking(int depth) {

        if (depth == M) {
            for(int v : path){
                sb.append(v);
                sb.append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            for(int j = 1; j < i; j++)
                visited[j] = true;

            if (visited[i])
                continue;

            visited[i] = true;
            path[depth] = i;
            backtracking(depth + 1);
            for(int j = 1; j <=i; j++)
                visited[j] = false;

        }
    }


    //    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(
//                new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        N = Integer.parseInt(st.nextToken());  // 첫 토큰: N
//        M = Integer.parseInt(st.nextToken());  // 둘째 토큰: M
//
//        path    = new int[M];
//        visited = new boolean[N + 1];  // 1-indexed
//
//        bt(0);
//        System.out.print(sb);
//    }
//
    static void bt(int depth) {
        System.out.println("bt 함수 호출!! Depth:" + depth);
        // 종료 조건: M개 다 골랐으면 출력
        if (depth == M) {
            for (int v : path) {
                System.out.println("sb.append(" + v + ").append(' ');");
                sb.append(v).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (visited[i]) {
                continue;  // 이미 사용됨 → 건너뜀
            }

            visited[i] = true;    // ① choose
            path[depth] = i;
            System.out.println("bt 호출 라인 전.depth=" + depth + ", i=" + i);
            bt(depth + 1);        // ② recurse
            System.out.println("bt 호출 라인 밑.depth=" + depth + ", i=" + i);
            visited[i] = false;   // ③ undo ← 핵심!
            System.out.println("=======================================");
        }
    }
}
