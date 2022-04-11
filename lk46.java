class Solution {
    List<List<Integer>> res =new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        //用于track路径
        LinkedList<Integer> track = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums,track,used);
        return res;
    }

    void backtrack(int[] nums, LinkedList<Integer> track, boolean[] used) {
        //base case
        if (track.size() == nums.length) {
            //语言特性， track 是一个外部引用，在遍历过程中track 中的数据会不断变化，
            // 所以装入 res 的时候应该把 track 里面的值做一次拷贝。
            // Java 可以这样用 new 实现拷贝的效果，其他语言各有自己的方式。
            res.add(new LinkedList(track));
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }

            track.add(nums[i]);
            used[i] = true;
            backtrack(nums, track, used);
            track.removeLast();
            used[i] = false;
        }
    }
}