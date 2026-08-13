class Solution {
    public boolean anss;
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int v[] = new int[n];
        Arrays.fill(v,-1);
        anss = true;
        for(int i=0 ;i<n ;i++) {
            if(v[i] == -1) {
                bfs(i,graph,v);
            }
        }
        return anss;
    }
    public void bfs(int idx , int[][] graph , int[] ans) {
        ans[idx] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(idx);
        while(!q.isEmpty()){
            int front = q.poll();
            int color = ans[front];
            for(int a : graph[front]) {
                if(ans[a] == ans[front]) {
                    anss = false;
                    return;
                }
                if(ans[a] == -1) {
                    ans[a] = color + 1;
                    q.add(a);
                }
            }
        }
    }
}