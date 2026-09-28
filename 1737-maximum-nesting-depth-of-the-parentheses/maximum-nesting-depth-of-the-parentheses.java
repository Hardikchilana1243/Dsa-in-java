class Solution {
    public int maxDepth(String s) {
        int countOfDepth = 0;
        
        Stack<Character> st = new Stack<>();
        int n = s.length();
        int count1 = 0;
        int count2=0;
        for(int i = 0; i < n; i++){
            
            char ch = s.charAt(i);

            if(ch == '(') {
                st.push(ch);
                count1++;
            }
            else if(ch == ')') {
                st.pop();
                
            }
            countOfDepth = Math.max(countOfDepth,st.size());
        }

        
        return countOfDepth;
    }
}