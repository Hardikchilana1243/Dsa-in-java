class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        helper(root,list);
        return list;
    }
    public void helper(TreeNode root,List<List<Integer>> list){
        if(root==null)return;
        Queue<TreeNode> q =new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int s=q.size();
            TreeNode curr;
            ArrayList<Integer> ans= new ArrayList<>();
            for(int i=0;i<s;i++){
                curr=q.poll();
                ans.add(curr.val);
                if(curr.left!=null)q.add(curr.left);
                if(curr.right!=null)q.add(curr.right);

            }
            list.add(ans);
        }
    }
}
