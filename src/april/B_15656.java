package april;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class B_15656 {
    // https://www.acmicpc.net/problem/15656

    static int N;
    static int M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> list = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        arr = new int[M];

        str = br.readLine().split(" ");
        for(String s : str)
            list.add(Integer.parseInt(s));

        list.sort(Comparator.naturalOrder());
        solve(0);
        System.out.println(sb);
    }

    static void solve(int depth) {
        if(depth == M){
            for(int i : arr)
                sb.append(i).append(" ");
            sb.append("\n");

            return;
        }

        for(int i = 0; i < N; i++){
            arr[depth] = list.get(i);
            solve(depth + 1);
        }
    }
}
