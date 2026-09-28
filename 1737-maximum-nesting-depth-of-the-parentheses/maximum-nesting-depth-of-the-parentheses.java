class Solution {
    public int maxDepth(String s) {
        int countOfDepth = 0;
        int n = s.length();
        int count1 = 0;
        
        for(int i = 0; i < n; i++){
            
            char ch = s.charAt(i);

            if(ch == '(') {
                // st.push(ch);
                count1++;
            }
            else if(ch == ')') {
                count1--;
                
            }
            countOfDepth = Math.max(countOfDepth,count1);
        }

        return countOfDepth;
    }
}