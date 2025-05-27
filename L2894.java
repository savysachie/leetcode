class Solution {
    public int differenceOfSums(int n, int m) {
        int sumDiv=0;
        int sumNoDiv=0;
        while(n>0){
            if(n%m==0) sumDiv+=n;
            else sumNoDiv+=n;
            n--;
        }
        return sumNoDiv-sumDiv;
    }
}