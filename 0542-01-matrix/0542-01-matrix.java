import java.util.*;

public class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] result = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        
        // 초기 설정: 0인 셀은 큐에 추가, 1인 셀은 MAX_VALUE로 초기화
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    result[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        // 방향 벡터 설정 (상, 하, 좌, 우)
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        // BFS 탐색
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                
                // 유효한 좌표인지 확인하고, 이전보다 더 작은 거리를 찾았는지 확인
                if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                    if (result[newX][newY] > result[x][y] + 1) {
                        result[newX][newY] = result[x][y] + 1;
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }
        }
        
        return result;
    }
}
