package march;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_14501 {

    static int N;
    static int[] tis;
    static int[] pis;
    static int[] arr;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        tis = new int[N + 1];
        pis = new int[N + 1];
//        arr = new int[N + 2]; // N+1일
        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            tis[i] = Integer.parseInt(st.nextToken());
            pis[i] = Integer.parseInt(st.nextToken());
        }
//        solve(N);
//        System.out.println(arr[1]);

        search(1, 0);
        System.out.println(MAX);
    }

    static int MAX = Integer.MIN_VALUE;
    static void search(int n, int sum) {
        if(n > N)
            return;
        search(n + 1, sum);

        if(tis[n] + n <= N+1) {
            int tmp = sum + pis[n];
            MAX = Math.max(MAX, tmp);
            search(n + tis[n], tmp);
        }
    }


    static void solve(int n) {

        for(int i = n; i > 0; i--) {
            arr[i] = arr[i + 1];

            if(i + tis[i] <= N + 1) {
                arr[i] = Math.max(arr[i], pis[i] + arr[i + tis[i]]);
            }
        }
    }
}
