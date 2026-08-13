class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> st = new ArrayDeque<>();
        for(String s : tokens){
            if(isOperator(s)){
                int a = st.pop();
                int b = st.pop();
                switch(s){
                    case "+":
                        st.push(a+b);
                        break;
                    
                    case "-":
                    st.push(b-a);
                    break;

                    case "*":
                    st.push(a*b);
                    break;

                    case "/":
                    st.push(b/a);
                    break;
                }

            }
            else{
                st.push(Integer.parseInt(s));
            }
        }
        return st.pop();
    }
    public boolean isOperator(String s){
        if(s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")) return true;
        return false;
    }
}