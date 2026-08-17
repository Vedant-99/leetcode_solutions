class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] secretCount = new int[10];
        int[] guessCount = new int[10];
        for(int i=0;i<secret.length();i++){
            char s = secret.charAt(i);
            char t = guess.charAt(i);
            if(s==t) bulls++;
            else{
                secretCount[s-'0']++;
                guessCount[t-'0']++;
            }
        }
        for(int i=0;i<secretCount.length;i++){
            cows+=Math.min(secretCount[i],guessCount[i]);
        }
        return bulls+"A"+cows+"B";
    }
}