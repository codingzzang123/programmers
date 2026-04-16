package april;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class B_15654 {

    static int N;
    static int M;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder stringBuilder = new StringBuilder();
    static List<Integer> integerList;

    // https://www.acmicpc.net/problem/15654
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] stringArray = br.readLine().split(" ");
        N = Integer.parseInt(stringArray[0]);
        M = Integer.parseInt(stringArray[1]);

        arr = new int[M];
        visited = new boolean[N + 1];

        stringArray = br.readLine().split(" ");
        integerList = new ArrayList<>(Arrays.stream(stringArray)
                .mapToInt(Integer::parseInt)
                .boxed().toList());

        // 오름차순 정렬
        integerList.sort(Comparator.naturalOrder());
        System.out.println(integerList);

        solve(0);
        System.out.println(stringBuilder);
    }

    public static void solve(int depth) {
        if(depth == M) {
            //
            for(int i : arr)
                stringBuilder.append(i).append(" ");
            stringBuilder.append("\n");
            return;
        }

        for(int i = 0; i < N; i++) {
            if(visited[i]) {
                continue;
            }
            visited[i] = true;
            arr[depth] = integerList.get(i);

            solve(depth + 1);
            visited[i] = false;
        }
    }
}
