class Solution {
    static int parent[];
    static int size[];
    public int leader(int n) {
        if(parent[n] == n)return parent[n];
        return parent[n] = leader(parent[n]);
    }
    public void union(int u ,int v) {
        int a = leader(u);
        int b = leader(v);
        if(a!=b) {
            if(size[a] > size[b]) {
                parent[b] = a;
                size[a] += size[b];
            }
            else {
                parent[a] = b;
                size[b] += size[a];
            }
        }
    }
     class Triplet implements Comparable<Triplet> {
        int u;
        int v;
        int dist;
        Triplet(int u ,int v ,int dist) {
            this.u = u;
            this.v = v;
            this.dist = dist;
        }
        public int compareTo(Triplet t) {
            if(this.dist == t.dist) return this.u - t.u;
            return this.dist - t.dist;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        parent = new int[n];
        size = new int[n];
        for(int i=0;i<n;i++) {
            parent[i] =i;
            size[i] = 1;
        }
        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++) {
                int x1 = points[i][0] , y1 = points[i][1] , x2 = points[j][0] , y2 = points[j][1];
                int dist = Math.abs(x2-x1) + Math.abs(y2 - y1);
                pq.add(new Triplet(i,j,dist));
            }
        }
        int cost = 0;
        while(!pq.isEmpty()) {
            Triplet curr = pq.poll();
            int u = curr.u;
            int v= curr.v;
            int dist = curr.dist;
            if(leader(u) != leader(v) ) {
                cost += dist;
                union(u,v);
            }
        }
        return cost;
    }
}