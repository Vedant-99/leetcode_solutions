class Solution {
    public boolean isPalindrome(String s) {
    s = s.toLowerCase();
    StringBuilder str = new StringBuilder();
    for(int i=0;i<s.length();i++){
        char ch = s.charAt(i);
        if(isAlpha(ch)) str.append(ch);
    }
    int start = 0, end = str.length()-1;
    while(start<=end){
        if(str.charAt(start)!=str.charAt(end)) return false;
        else{   
            start++;
            end--;
        }
    }
        return true;

    }
    public boolean isAlpha(char ch){
        if((ch>='A'&& ch<='Z')||(ch>='a'&& ch<='z')||(ch>='0' && ch<='9')) return true;
        return false;
    }

}