//暴力递归

class Solution {
    public int fib(int n) {
        if(n==1 || n==2) return 1;
        return fib(n-2) + fib(n-1);
    }
}