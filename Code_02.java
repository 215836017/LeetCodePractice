package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
给定一个未排序的整数数组，找出最长连续序列的长度。

要求算法的时间复杂度为 O(n)。

示例:

输入: [100, 4, 200, 1, 3, 2]
输出: 4
解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
*/

public class Code_02 {

    public static void main(String[] args) {
        Code_02 code_02 = new Code_02();

        int[] src = {100, 4, 200, 1, 3, 2};
//        int[] src = {9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6};
//        int[] src = {9, 1, -3, 2, 4, 8, 3, -1, 6, -2, -4, 7};
//        int[] src = {7, -9, 3, -6, 3, 5, 3, 6, -2, -5, 8, 6, -4, -6, -4, -4, 5, -9, 2, 7, 0, 0};
//        int[] src = {100, 4, 200, 1, 3, 2, 101, 201, 102, 104, 103, 105, 104};
//        int[] src = {100, 4};
        code_02.test(src);
    }

    private int test(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }

        List<Integer> list = new ArrayList<Integer>();
        int[] buff = new int[nums.length];
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
                buff[j] = nums[i];
                j++;
            }
        }
        if (list.size() == 1) {
            return 1;
        }
        int[] dest = new int[list.size()];
        System.arraycopy(buff, 0, dest, 0, dest.length);
        Arrays.sort(dest);

        for (int i : dest) {
            System.out.println("test dest i = " + i);
        }

        int maxLength = 1;
        int lastMaxLength = 0;

        for (int i = 1; i < dest.length; i++) {
            if ((dest[i] - dest[i - 1]) == 1) {
                maxLength++;

            } else {
                System.out.println("test 444, maxLength = " + maxLength + ", lastMaxLength = " + lastMaxLength);

                if (maxLength >= lastMaxLength) {
                    lastMaxLength = maxLength;
                }
                maxLength = 1;
                System.out.println("test 55, maxLength = " + maxLength + ", lastMaxLength = " + lastMaxLength);
            }
        }

        maxLength = maxLength > lastMaxLength ? maxLength : lastMaxLength;
        System.out.println("maxLength = " + maxLength);

        return maxLength;
    }
}
