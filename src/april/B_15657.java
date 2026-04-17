package april;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class B_15657 {
    // https://www.acmicpc.net/problem/15657
    static int N;
    static int M;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> list = new ArrayList<>();

    static void solve(int start, int depth) {
        if(depth == M){
            for(int i : arr)
                sb.append(i).append(" ");
            sb.append("\n");

            return;
        }

        for(int i = start; i < N; i++){
            arr[depth] = list.get(i);
            solve(i, depth + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        arr = new int[M];
        visited = new boolean[N + 1];

        str = br.readLine().split(" ");
        for(String s : str)
            list.add(Integer.parseInt(s));

        list.sort(Comparator.naturalOrder());
        System.out.println("list="+list);
        solve(0, 0);
        System.out.println(sb);
    }
}
