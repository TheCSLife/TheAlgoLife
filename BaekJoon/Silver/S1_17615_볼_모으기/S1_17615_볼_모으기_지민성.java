package algolife;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class S1_17615_볼_모으기_지민성 {

    public static int n;

    public static int check(char ball, String balls) {
        boolean flag = false;
        int result = 0;
        for (int i = 0; i < n; i++){
            if (flag) {
                if (ball == balls.charAt(i))
                    result++;
            } else {
                if (ball != balls.charAt(i))
                    flag = true;
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        String input = br.readLine();
        StringBuilder stringBuilder = new StringBuilder(input);
        String balls = stringBuilder.toString();
        String reverseBalls = stringBuilder.reverse().toString();

        List<Integer> list = new ArrayList<>();
        list.add(check('B', balls));
        list.add(check('R', balls));
        list.add(check('B', reverseBalls));
        list.add(check('R', reverseBalls));
        System.out.println(Collections.min(list));
    }
}
