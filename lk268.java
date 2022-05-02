//只要把所有的元素和索引做异或运算，成对儿的数字都会消为 0，只有这个落单的元素会剩下
//位操作有点离谱
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int res = 0;//数组扩充一个新索引后，res索引所在位置的值是0
        res ^= n;//先和新补充索引异或一下
        for (int i = 0; i < n; i++)
            res ^= i ^ nums[i];
        return res;
    }
}

