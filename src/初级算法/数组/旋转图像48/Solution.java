package 初级算法.数组.旋转图像48;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 *
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[7,4,1],[8,5,2],[9,6,3]]
 * 示例 2：
 *
 *
 * 输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * 输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode.cn/leetbook/read/top-interview-questions-easy/xnhhkv/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Solution {



    public void rotate(int[][] matrix) {

        //变化前后 变化后的位置 row = col ， col = 长度-row-1

        /** 新数组填充*/
        int[][] newArrays = new int[matrix.length][matrix.length];

        for (int row = 0; row < matrix.length; row++) {
            int[] rows = matrix[row];
            for (int col = 0; col < rows.length; col++) {
                int newRow = col;
                int newCol = matrix.length-1-row;
                newArrays[newRow][newCol] = matrix[row][col];
            }
        }

        // 拷贝到原数组中
        for (int i = 0; i < newArrays.length; i++) {
            for (int j = 0; j < newArrays.length; j++) {
                matrix[i][j]=newArrays[i][j];
            }
        }
    }
}
