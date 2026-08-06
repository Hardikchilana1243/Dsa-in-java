class Solution {
    public int makeConnected(int n, int[][] connections) {
        int m = connections.length;
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<n;i++) {
            list.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++) {
            int u = connections[i][0] , v = connections[i][1];
            list.get(u).add(v);
            list.get(v).add(u);
        }
        if(m < n-1) return -1;
        int c=0;
        boolean vis[] = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++) {
            if(!vis[i]) {
                q.add(i);
                c++;
                vis[i] = true;
                while(!q.isEmpty()){
                    int front = q.poll();
                    for(int ele  : list.get(front)){
                        if(!vis[ele]) {
                            vis[ele] = true;
                            q.add(ele);
                        }
                    }
                }
            }
        }
        return c-1;
    }
}