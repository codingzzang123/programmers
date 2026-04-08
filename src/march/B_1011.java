package march;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class B_1011 {

    static Map<Integer /* distance */, Integer /* result */> map = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);

        IntStream.range(0, n).forEach(i -> {
            try {
                int[] arr = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt).toArray();

                int distance = arr[1] - arr[0];
                sb.append(map.computeIfAbsent(distance, d -> solve(d , (int)Math.sqrt(distance)))).append("\n");

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.print(sb);
    }

    static int solve(int distance, int n /* 제곱 수 */) {
        if(Math.pow(n, 2) == distance){
            System.out.println("1번 조건");
            return 2*n -1;

        }
        else if(Math.pow(n, 2) < distance && n * (n + 1) >= distance){
            return 2*n;

        }
        else {
            return 2*n +1;
        }
    }
}
