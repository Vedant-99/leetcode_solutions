class Solution {
    public String getHint(String secret, String guess) {
        int cows =0;
        int bulls =0;
        int[] count = new int[10];
        
        for(int i=0;i<secret.length();i++){

            int s = secret.charAt(i)-'0';
            int t = guess.charAt(i)-'0';

            if(s==t) bulls++;
            else{
                if(count[s]<0) cows++;
                if(count[t]>0) cows++;
                count[s]++;
                count[t]--;
            }
        }
        return bulls+"A"+cows+"B";
    }
}