package algolife;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G4_17141_연구소2_지민성 {
    
    public static int n, m, size;
    public static int result = 100000000;
    public static int[][] map;
    public static boolean[] select;
    public static List<Node> list;
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static class Node {
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void backTracking(int count, int index) {
        if (count == m) {
            result = Math.min(result, spreadVirus());
            return;
        }
        for (int i = index; i < size; i++) {
            if (!select[i]) {
                select[i] = true;
                backTracking(count + 1, i + 1);
                select[i] = false;
            }
        }
    }

    public static int spreadVirus() {
        int[][] newMap = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newMap[i][j] = map[i][j];
            }
        }
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            if (select[i]) {
                Node curr = list.get(i);
                queue.offer(curr);
                newMap[curr.x][curr.y] = -1;
            }
        }
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            int x = curr.x;
            int y = curr.y;
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n)
                    continue;
                if (newMap[nx][ny] < 0 || newMap[nx][ny] == 1)
                    continue;
                newMap[nx][ny] = newMap[x][y] - 1;
                queue.offer(new Node(nx, ny));
            }
        }
        int res = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = newMap[i][j];
                if (num == 0 || num == 2) {
                    return 100000000;
                }
                if (num < 0) {
                    res = Math.max(res, -1 * num - 1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 2)
                    list.add(new Node(i, j));
                map[i][j] = num;
            }
        }
        size = list.size();
        select = new boolean[size];
        backTracking(0, 0);
        if (result == 100000000)
            result = -1;
        System.out.println(result);
    }
    
}
