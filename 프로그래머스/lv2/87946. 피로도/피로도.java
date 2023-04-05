class Solution {
    int answer = 0;
    boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        
        DFS(k, dungeons, 0);
        return answer;
    }
    
    void DFS(int k, int[][] dungeons, int depth) {
        for( int i = 0; i < dungeons.length; i++){
            int a = dungeons[i][0];
            int b = dungeons[i][1];
            
            if(visited[i] || k < a){
                continue;
            }
            
            visited[i] = true;
            DFS(k - b, dungeons, depth + 1);
            visited[i] = false;
        }
        answer = Math.max(depth, answer);
    }
}