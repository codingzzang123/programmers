package february;

public class Q2 {

    public static int solution(int n, int w, int num) {
        // 쌓인 상자의 높이
        int h = (int) Math.ceil((double) n/w);

        // 꺼내려는 상자의 세로축 위치
        int floor = 1;
        while (floor < h) {
            if(num <= floor * w)
                break;
            floor++;
        }
        int answer = h - floor + 1;

        // 상자가 위치한 가로의 위치 정보 index (1부터 시작) 1<= col_index <= w
        int col_index = floor % 2 != 0
                ? (num-1)%w + 1
                : w - ((num-1)%w);

        int n2 /* 맨 위에 상자가 있는가? */ = h % 2 != 0
                ? (h-1)*w + col_index
                : (h*w) - (col_index -1);

        return n2 > n ? answer - 1 : answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(22, 6, 15));
    }
}
