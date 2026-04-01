package march;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class B_1011 {

    static Map<Integer /* distance */, Integer /* result */> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.put(4, 3);


    }
}
