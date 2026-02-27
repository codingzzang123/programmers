package february;

public class Q3 {

    public static int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;

        for(int i=0; i<schedules.length; i++) {
            boolean flag = true;
            int[] timelog = timelogs[i];

            int hour   = schedules[i] / 100;
            int minute = schedules[i] % 100;

            schedules[i] = minute + 10 >= 60
                    ? (hour+1)* 100 + (minute+10 - 60)
                    : schedules[i] + 10;


            int day = startday;
            for (int k : timelog) {
                if (day == 6 || day == 7 || day == 13) {
                } else {
                    if (k > schedules[i])
                        flag = false;
                }
                day++;
            }

            if(flag) answer++;

        }
        return answer;
    }

    public static void main(String[] args) {
//        System.out.println(
//                solution(
//                        new int[]{700},
//                        new int[][]{
//                             //     7    8    9    10  11   12    13
//                                {1100, 701, 702, 700, 700, 701, 1100}
//                        },
//                        7
//                )
//        );

        System.out.println(
                solution(
                        new int[]{730, 855, 700, 720},
                        new int[][]{
                                {710, 700, 650, 735, 700, 931, 912},
                                {908, 901, 805, 815, 800, 831, 835},
                                {705, 701, 702, 705, 710, 710, 711},
                                {707, 731, 859, 913, 934, 931, 905}
                        },
                        1
                )
        );

    }
}
