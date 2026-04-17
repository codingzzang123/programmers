package april;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class B_15666 {

    static int N;
    static int M;
    static int[] arr;
    static StringBuilder stringBuilder = new StringBuilder();
    static List<Integer> integerList = new ArrayList<>();
    static Set<String> set = new HashSet<>();


    // https://www.acmicpc.net/problem/15665
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] stringArray = br.readLine().split(" ");
        N = Integer.parseInt(stringArray[0]);
        M = Integer.parseInt(stringArray[1]);

        arr = new int[M];

        stringArray = br.readLine().split(" ");
        for(String s : stringArray)
            integerList.add(Integer.parseInt(s));

        // 오름차순 정렬
        integerList.sort(Comparator.naturalOrder());
        solve(0);
        System.out.println(stringBuilder);
    }

    public static void solve(int depth) {
        if(depth == M) {
            StringBuilder tmp = new StringBuilder();
            for(int i : arr)
                tmp.append(i).append(" ");

            if(!set.contains(tmp.toString())) {
                set.add(tmp.toString());
                stringBuilder.append(tmp).append("\n");
            }

            return;
        }

        for(int i = 0; i < N; i++) {
            if(depth != 0 && arr[depth - 1] > integerList.get(i))
                continue;

            arr[depth] = integerList.get(i);
            solve(depth + 1);
        }
    }
}
