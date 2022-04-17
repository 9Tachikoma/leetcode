//力扣教大家用哈希表
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> index = new HashMap<>();
        for(int i =0 ;i < nums.length;i++){
            index.put(nums[i],i);
        }

        for(int i = 0;i<nums.length;i++){
            int other = target - nums[i];
            if(index.containsKey(other) && index.get(other)!=i)
                return new int[]{i,index.get(other)};
        }
        return new int[]{-1,-1};
    }
}