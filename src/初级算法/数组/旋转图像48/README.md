## 旋转图像
![image.png](https://pic.leetcode-cn.com/1657010320-cMYact-image.png)

### 方法一 辅助数组

作为例子，分析将图像旋转 90 度之后，这些数字出现在什么位置。

对于矩阵中的第一行而言，在旋转后，它出现在倒数第一列的位置：

![image.png](https://pic.leetcode-cn.com/1657072239-dRwywT-image.png)

并且，第一行的第 x*x* 个元素在旋转后恰好是倒数第一列的第 x*x* 个元素。

对于矩阵中的第二行而言，在旋转后，它出现在倒数第二列的位置：

![image.png](https://pic.leetcode-cn.com/1657072257-wctYiA-image.png)

因此，对于元素的位置  ***matrix* [row] [col]** ,在旋转之后，它的位置是   **matrix [col] [length-1-row]** .

因此，我们方法一的代码为：

```java
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
```



### 方法二 翻转代替旋转

​	我们也可以使用翻转来代替旋转，这样我们可以不用使用额外的空间

![image.png](https://pic.leetcode-cn.com/1657073204-SGuWcq-image.png)

​    我们先将它上下翻转，得到：

![image.png](https://pic.leetcode-cn.com/1657073319-DIfWKb-image.png)  

我们可以观察得到： ***matrix* [row] [col]**   翻转后  ***matrix* [length-1-row] [col]**

  然后我们再根据对角线进行翻转：

![image.png](https://pic.leetcode-cn.com/1657073336-UUslcc-image.png)

我们可以观察到对角线的等式为：***matrix* [row] [col]** = ***matrix* [col] [row]**

因此，我们的代码为

   

```java
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        //水平旋转 所以只循环一半即可
        for (int row = 0; row < length/2; row++) {
            for (int col = 0; col < length; col++) {
                int newRow = length-1-row;
                int newCol = col ;
                matrix[row][col] =matrix[row][col] ^ matrix[newRow][newCol];
                matrix[newRow][newCol] =matrix[row][col] ^ matrix[newRow][newCol];
                matrix[row][col] =matrix[row][col] ^ matrix[newRow][newCol];
            }
        }

        //对角线旋转 每次一行旋转的元素数量 = 当前行数
        for (int row = 0; row < length; row++) {
            for (int col = 0; col < row; col++) {
                int newRow =col;
                int newCol = row ;
                matrix[row][col] =matrix[row][col] ^ matrix[newRow][newCol];
                matrix[newRow][newCol] =matrix[row][col] ^ matrix[newRow][newCol];
                matrix[row][col] =matrix[row][col] ^ matrix[newRow][newCol];
            }
        }
    }
```



[代码示例(Java)](./Solution48.java)