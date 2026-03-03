package february;

import java.util.Arrays;

public class Q4 {

    public static String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int opStart  = parseTime(op_start);
        int opEnd    = parseTime(op_end);
        int position = parseTime(pos);
        int length   = parseTime(video_len);

        int standard = position >= opStart && position <= opEnd
                ? opEnd
                : position;
        System.out.println("[1] Standard:"+standard);

        for (String command : commands) {
            standard = "prev".equals(command)
                    ? Math.min(standard - 10, 0)
                    : Math.min(standard + 10, length);

            standard = standard >= opStart && standard <=opEnd
                    ? opEnd
                    : standard;
        }
        System.out.println("[2] Standard:"+standard);

        return String.format("%02d", standard / 60) + ":" + String.format("%02d", standard % 60);
    }
    public static int parseTime(String time) {
        String [] arr = time.split(":");
        return Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
    }


    public static int toNumber(String time) {
        return Integer.parseInt(time.replace(":", ""));
    }

    public static int parse_time(String str){
        int[] arr =
                Arrays.stream(str.split(":"))
                        .mapToInt(s -> s.equals("00") ? 0 : Integer.parseInt(s))
                        .toArray();

        return arr[0] * 100 + arr[1];
    }


    public static void main(String[] args) {
        System.out.println(solution("34:33",	"13:00",	"00:55",	"02:55", new String [] {"next", "prev"}));
//        System.out.println(solution("10:55",	"00:05",	"00:15",	"06:55", new String [] {"prev", "next", "next"}));
//        System.out.println(solution("07:22",	"04:05",	"00:15",	"04:07", new String [] {"next"}));
//        System.out.println(Math.min(10+10 , 15));
    }
}
