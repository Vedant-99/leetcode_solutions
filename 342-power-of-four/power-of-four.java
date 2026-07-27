class Solution {
    public boolean isPowerOfFour(int n) {
        if(n==0) return false;
        return isSquare(n) && power2(n);
    }
    public boolean isSquare(int n){
        int root = (int)Math.sqrt(n);
        if((root * root)==n) return true;
        return false;

    }
    public boolean power2(int n){
        return (n &(n-1))==0;
    }
}