class Solution {
    public int[] sortArray(int[] nums) {
        Quick.sort(nums);
        return nums;
    }
}

class Quick {
    public static void sort(int[] nums) {
        shuffle(nums);
        sort(nums, 0, nums.length - 1);
    }

    private static void sort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int p = partition(nums, lo, hi);
        sort(nums, lo, p - 1);
        sort(nums, p+1, hi);
    }

    private static int partition(int[] nums, int lo, int hi) {
        int pivot = nums[lo];
        //关于区间的边界控制需要格外小心，这里把i，j定义为开区间，同时定义：[lo,i) <= pivot,(j,hi] > pivot,维护它
        int i = lo + 1, j = hi;
        //i>j时结束循环，以保证区间[lo,hi]都被覆盖
        while (i <= j) {
            while (i < hi && nums[i] <= pivot) {
                i++;
            }
            while (j > lo && nums[j] > pivot) {
                j--;
            }

            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        //将pivot交换过去
        swap(nums, lo, j);
        return j;
    }

    private static void shuffle(int[] nums) {
        Random rand = new Random();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int r = i + rand.nextInt(n - i);
            swap(nums, i, r);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
