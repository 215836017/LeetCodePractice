package com.test;

/*
输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。

示例 1：

输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]
示例 2：

输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 

限制：

0 <= matrix.length <= 100
0 <= matrix[i].length <= 100
*/
public class Code_01 {

    public static void main(String[] args) {
        Code_01 code_01 = new Code_01();

        int[][] src = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
                {17, 18, 19, 20}
        };
        code_01.test(src);
    }

    public int[] test(int[][] matrix) {

        int right = 0;
        int down = 1;
        int left = 2;
        int up = 3;
        int turnCorner = right;

        if(null == matrix ||matrix.length <=0){
            return new int[0];
        }

        int x_min = 0;
        int x_max = matrix[0].length;
        int y_min = 0;
        int y_max = matrix.length;

        int[] ret = new int[x_max * y_max];
        int count = 0;

        if (x_max < y_max) {
            while (x_max != x_min) {
                if (turnCorner == right) {
                    for (int i = x_min; i < x_max; i++) {
                        System.out.println("test 1,, " + matrix[y_min][i]);
                        ret[count] = matrix[y_min][i];
                        count++;
                    }
                    turnCorner = down;
                    y_min++;

                } else if (turnCorner == down) {
                    for (int i = y_min; i < y_max; i++) {
                        System.out.println("test 22,, " + matrix[i][x_max - 1]);
                        ret[count] = matrix[i][x_max - 1];
                        count++;
                    }
                    turnCorner = left;
                    x_max--;
                } else if (turnCorner == left) {
                    for (int i = x_max - 1; i >= x_min; i--) {
                        System.out.println("test 333,, " + matrix[y_max - 1][i]);
                        ret[count] = matrix[y_max - 1][i];
                        count++;
                    }
                    turnCorner = up;
                    y_max--;
                } else if (turnCorner == up) {
                    for (int i = (y_max - 1); i >= y_min; i--) {
                        System.out.println("test 4444,, " + matrix[i][x_min]);
                        ret[count] = matrix[i][x_min];
                        count++;
                    }
                    turnCorner = right;
                    x_min++;
                }
            }
        } else {
            while (y_max != y_min) {
                if (turnCorner == right) {
                    for (int i = x_min; i < x_max; i++) {
                        System.out.println("test 1,, " + matrix[y_min][i]);
                        ret[count] = matrix[y_min][i];
                        count++;
                    }
                    turnCorner = down;
                    y_min++;

                } else if (turnCorner == down) {
                    for (int i = y_min; i < y_max; i++) {
                        System.out.println("test 22,, " + matrix[i][x_max - 1]);
                        ret[count] = matrix[i][x_max - 1];
                        count++;
                    }
                    turnCorner = left;
                    x_max--;
                } else if (turnCorner == left) {
                    for (int i = x_max - 1; i >= x_min; i--) {
                        System.out.println("test 333,, " + matrix[y_max - 1][i]);
                        ret[count] = matrix[y_max - 1][i];
                        count++;
                    }
                    turnCorner = up;
                    y_max--;
                } else if (turnCorner == up) {
                    for (int i = (y_max - 1); i >= y_min; i--) {
                        System.out.println("test 4444,, " + matrix[i][x_min]);
                        ret[count] = matrix[i][x_min];
                        count++;
                    }
                    turnCorner = right;
                    x_min++;
                }
            }
        }


        for (int i : ret) {
            System.out.print(i + "  ");
        }
        return ret;
    }
}
