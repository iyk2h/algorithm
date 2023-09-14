import java.util.*;

class Solution {
    
    int[] dx = new int[]{0, 0, 1, -1};
    int[] dy = new int[]{1, -1, 0, 0};

    int[][] recList;
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        
        recList = new int[rectangle.length][rectangle[0].length];
        
        for(int i = 0; i < rectangle.length; i++) {
            for (int j = 0; j < rectangle[0].length; j++) {
				rectangle[i][j] *= 2;
            }
        }
        
        recList = rectangle;
        
        characterX *= 2;
        characterY *= 2;
        
        itemX *= 2;
        itemY *= 2;
        
        int[][] map = new int[102][102];
        
        for(int[] rec : recList) {
            int x1 = rec[0];
            int x2 = rec[2];
            int y1 = rec[1];
            int y2 = rec[3];
            
            for (int i = x1; i <= x2; i++) {
                for (int j = y1; j <= y2; j++) {
                    map[i][j] = -1;
                }
            }
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{characterX, characterY, 1});
        map[characterX][characterY] = 1;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            
            if(cx == itemX && cy == itemY) {
                answer = cur[2] / 2;
                break;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if (map[nx][ny] < 0 && checkOut(nx, ny)) {
                    map[nx][ny] = cur[2] + 1;
                    q.add(new int[]{nx, ny, cur[2] + 1});
                }

            }
        }
        
        
        return answer;
    }
    
    private boolean checkOut(int x, int y) {
        for(int[] rec : recList) {
            int x1 = rec[0];
            int x2 = rec[2];
            int y1 = rec[1];
            int y2 = rec[3];
            
            if (x > x1 && x < x2 && y > y1 && y < y2) {
                return false;
            }
        }
        return true;
    }
}