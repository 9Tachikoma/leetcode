class Solution {
    public void moveZeroes(int[] nums) {
        int p = removeElement(nums,0);
        for(;p<nums.length;p++){
            nums[p] = 0;
        }
    }

    public int removeElement(int[] nums, int val) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}