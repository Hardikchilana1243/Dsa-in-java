class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source == destination) return true;
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<n;i++)list.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            list.get(a).add(b);
            list.get(b).add(a);
        }
        boolean v[] = new boolean[n];
        v[source] = true;
        dfs(source,destination,list,v);
        return v[destination];
    }
    public void dfs(int s,int e , List<List<Integer>> list , boolean v[]) {
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        while(!q.isEmpty()) {
            int front = q.poll();
            for(int ele: list.get(front)) {
                if(s == e) return;
                if(!v[ele]) {
                    v[ele] = true;
                    q.add(ele);
                }
            }
        }
    
    }
}