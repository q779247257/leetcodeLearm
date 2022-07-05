## 旋转图像
![image.png](https://pic.leetcode-cn.com/1657010320-cMYact-image.png)



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

