class Solution {
    public int integerBreak(int n) {
        if(n==2) return 1;
        if(n==3) return 2;
        int a=1;
        while(n>4){
            a*=3;
            n-=3;
        }
        return n*a;
    }
}