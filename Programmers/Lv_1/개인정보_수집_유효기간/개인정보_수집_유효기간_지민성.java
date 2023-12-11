import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> dic = new HashMap<>();
        for (String info : terms) {
            String[] temp = info.split(" ");
            String alphabet = temp[0];
            int term = Integer.parseInt(temp[1]);
            dic.put(alphabet, term);
        }
        int day = convert(today);
        for (int i = 0; i < privacies.length; i++) {
            String[] info = privacies[i].split(" ");
            int value = convert(info[0]) + dic.get(info[1]) * 28;
            if (value <= day) {
                result.add(i + 1);
            }
        }
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++)
            answer[i] = result.get(i);
        return answer;
    }
    
    public int convert(String date) {
        String[] parts = date.split("\\.");
        int y = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        int d = Integer.parseInt(parts[2]);
        return (y * 12 + m) * 28 + d;
    }

}