class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        for (int i = 1; i < triangle.length; i++) {
            int k = triangle[i].length;
            for (int j = 0; j < k; j++) {
                if (j == 0) {
                    triangle[i][j] = triangle[i][j] + triangle[i - 1][j];
                } else if (j == k - 1) {
                    triangle[i][j] = triangle[i][j] + triangle[i - 1][j - 1];
                } else {
                    triangle[i][j] = triangle[i][j] + Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
                }
            }
        }
        for (int[] line : triangle)
            for (int i : line)
                answer = Math.max(answer, i);
        return answer;
    }
}