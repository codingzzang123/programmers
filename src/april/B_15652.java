package april;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_15652 {

    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();

    static int[] arr; // M개 만큼 숫자를 담을 정수형 배열. 크기는 M만큼

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        arr = new int[M];

        solve(0);
        System.out.println(sb);
    }

    static void solve(int depth) {
        if(depth == M) {
            for(int i : arr){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= N; i++) {
            if(depth != 0 && arr[depth - 1] <= i) {
                arr[depth] = i;
            } else if (depth == 0) {
                arr[depth] = i;
            } else
                continue;

            solve(depth + 1);
        }
    }
}
