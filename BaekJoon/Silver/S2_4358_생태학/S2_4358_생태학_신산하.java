import java.util.HashMap;
import java.util.Scanner;
import java.util.Arrays;

public class S2_4358_생태학_신산하 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        HashMap<String ,Integer> map = new HashMap<>();
        int count = 0;
        
        while(sc.hasNextLine()) {
            String str = sc.nextLine();
            map.put(str, map.getOrDefault(str, 0) + 1);
            count++;
        }
        
        Object[] keyArr = map.keySet().toArray(); // 키 값을 배열로 받아옴
        Arrays.sort(keyArr); 
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < keyArr.length; i++) {
            int value = map.get(keyArr[i]);
            double percent = ((double)value /(double) count) * 100;
            sb.append(keyArr[i] + " " + String.format("%.4f", percent) + "\n");
        }
        System.out.println(sb.toString());
    }
}