package april;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class B_15655 {
    // https://www.acmicpc.net/problem/15655

    static int N;
    static int M;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder stringBuilder = new StringBuilder();
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] readLine = br.readLine().split(" ");
        N = Integer.parseInt(readLine[0]);
        M = Integer.parseInt(readLine[1]);

        visited = new boolean[N];
        arr = new int[M];

        readLine = br.readLine().split(" ");
        for(String str : readLine)
            list.add(Integer.parseInt(str));

        list.sort(Comparator.naturalOrder());
        solve(0);
        System.out.println(stringBuilder);
    }

    static void solve(int depth) {
        if(depth == M) {
            for(int i : arr)
                stringBuilder.append(i).append(" ");
            stringBuilder.append("\n");
            return;
        }

        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;

                int num = list.get(i);
                if(depth == 0) {
                    arr[depth] = num;
                    solve(depth + 1);

                }else if(num > arr[depth - 1]){
                    arr[depth] = num;
                    solve(depth + 1);
                }


                visited[i] = false;
            }
        }
    }
}
