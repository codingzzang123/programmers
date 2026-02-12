package february;

import java.util.Arrays;

// 문자열 내 마음대로 정렬하기
public class Q1 {
    public String[] solution(String[] strings, int n) {
        String[] answer = Arrays.copyOf(strings, strings.length);

        for(int i = 0; i < strings.length; i++) {
            for(int k=0; k< strings.length - 1; k++){
                cmp(answer, k, k+1, n);
            }
        }
        return answer;
    }

    public void cmp (String[] s, int i, int k, int n){
        char ca = s[i].charAt(n);
        char cb = s[k].charAt(n);
        if(ca > cb) {
            String tmp = s[i];
            s[i] = s[k];
            s[k] = tmp;
        }
        if(ca == cb){
            if(s[i].compareTo(s[k]) > 0) {
                String tmp = s[i];
                s[i] = s[k];
                s[k] = tmp;
            }
        }
    }
}
