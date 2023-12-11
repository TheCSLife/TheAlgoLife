import java.util.*;

class Solution {
    
    public static boolean[][] visited;
    public static int row;
    public static int col;
    
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int index = 1;
    public static Map<Integer, Integer> dic = new HashMap<>();
    
    public int solution(int[][] land) {
        
        int answer = 0;
        row = land.length;
        col = land[0].length;
        visited = new boolean[row][col];
        
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
                if (land[i][j] == 1)
                    bfs(land, i, j);
        for (int j = 0; j < col; j++) {
            Set<Integer> result = new HashSet<>();
            int temp = 0;
            for (int i = 0; i < row; i++)
                if (land[i][j] != 0)
                    result.add(land[i][j]);
            for (int i : result)
                temp = temp + dic.get(i);                
            answer = Math.max(answer, temp);
        }
        return answer;
    }
    
    public void bfs(int[][]land, int i, int j) {
        Queue<Node> queue = new LinkedList<>();
        Node node = new Node(i, j);
        queue.offer(node);
        index++;
        int count = 1;
        visited[i][j] = true;
        land[i][j] = index;
        
        while(!queue.isEmpty()) {
            Node current = queue.poll();
            int x = current.r;
            int y = current.c;
            
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || nx >= row || ny < 0 || ny >= col)
                    continue;
                if (visited[nx][ny] || land[nx][ny] == 0)
                    continue;
                Node newNode = new Node(nx, ny);
                queue.offer(newNode);
                visited[nx][ny] = true;
                land[nx][ny] = index;
                count++;
            }
        }
        dic.put(index, count); 
    }
    
    public class Node {
        int r;
        int c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}