//带备忘录的递归解法
class Solution {
    public int fib(int n) {
        int[] memo = new int[N + 1];
        return helper(memo,n);
    }

    public int helper(int[] memo,int n){
        if(n==0 || n==1) return 1;
        // 已经计算过，不用再计算了
        if(memo[n]!=0) return memo[n];
        memo[n] = helper(memo,n-1) + helper(memo,n-2);
        return memo[n];
    }
}