import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class S4_1331_나이트_투어_지민성 {

    public static String x, y, sx, sy;
    public static String[] input;

    public static boolean check(String x, String y) {
        int prevX = x.charAt(0);
        int prevY = Integer.parseInt(y);
        int nextX = input[0].charAt(0);
        int nextY = Integer.parseInt(input[1]);

        int MDX = Math.abs(prevX - nextX);
        int MDY = Math.abs(prevY - nextY);

        return MDX + MDY == 3 && MDX != 3 && MDY != 3;
    }

    public static void main(String[] args) throws IOException {
        Set<String> set = new HashSet<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 36; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String temp = st.nextToken();
            input = temp.split("");
            if (x == null || y == null) {
                x = input[0];
                y = input[1];
                sx = input[0];
                sy = input[1];
                set.add(temp);
                continue;
            }

            if (set.contains(temp) || !check(x, y)) {
                System.out.println("Invalid");
                System.exit(0);
            }
            set.add(temp);
            x = input[0];
            y = input[1];
        }
        if (!check(sx, sy)) {
            System.out.println("Invalid");
            System.exit(0);
        }
        System.out.println("Valid");
    }
}
