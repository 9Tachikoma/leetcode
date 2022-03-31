/*题目：输入数组，最大的与第一个元素交换，最小的与最后一个元素交换，输出数组。

        思路分析: 1. 创建一个数组来装输入数字

        2. 找到最大值,和第一个元素交换

        3. 找到最小值, 和最后一个元素交换

        4. 输出数组*/
class Solution {
    public static void main(String[] args) {
        System.out.print("请输入您要输入的数字个数:");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(n <=0 ) {
            System.out.println("输入有误");
        } else {
            int[] arr = new int[n];
            System.out.println("请输入"+n+"个数字");
            for(int i=0; i<n; i++) {
                arr[i] = in.nextInt();
            }
            changeMin(arr);
            changeMax(arr);
            System.out.println(Arrays.toString(arr));
        }
        in.close();
    }
    //最大值与第一个元素交换
    public static void changeMax(int[] arr) {
        int max = 0;
        int index = 0;
        for(int i=0; i< arr.length; i++) {
            if(max < arr[i]) {
                max = arr[i];
                index = i;
            }
        }
        int temp = arr[0];
        arr[0] = max;
        arr[index] = temp;

    }
    //最后一个元素与最小值交换
    public static void changeMin(int[] arr) {
        int min = arr[arr.length-1];
        int index = 0;
        for(int i=0; i< arr.length; i++) {
            if(min > arr[i]) {
                min = arr[i];
                index = i;
            }
        }
        int temp = arr[arr.length -1];
        arr[arr.length -1] = min;
        arr[index] = temp;
    }
}