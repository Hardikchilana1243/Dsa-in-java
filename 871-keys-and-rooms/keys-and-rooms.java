class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        boolean v[] = new boolean[rooms.size()];
        v[0] = true;
        while(!q.isEmpty()) {
            int front = q.poll();
            for(int ele : rooms.get(front)) {
                if(v[ele]!=true) {
                    v[ele] = true;
                    q.add(ele);
                }
            }
        }
        for(int i=0;i<rooms.size();i++) {
            if(v[i] == false) {
                return false;
            }
        }
        return true;
    }
}