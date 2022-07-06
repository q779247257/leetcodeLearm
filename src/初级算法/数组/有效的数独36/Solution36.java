
public class Solution36 {
    public static void main(String[] args) {
        System.out.println(4/3);

        char[][] board = new char[][]{
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };

        boolean validSudoku = isValidSudoku(board);
        System.out.println(validSudoku);

    }


    public static boolean isValidSudoku(char[][] board) {
        //9个  3*3的一个网格
        int[][][] boxes = new int[3][3][9];
         for (int i = 0; i < board.length; i++) {
            char[] lines = board[i];//一行

            //一行中的每个数字
            for (int j = 0; j < lines.length; j++) {
                char val = lines[j];
                if (val == '.'){
                    continue;//如果没有数字，那么直接跳过
                }

                //检查这一行有没有重复的
                for (int k = j+1; k < 9; k++) {
                    if (lines[k] == lines[j]) {
                        return false;
                    }
                }

                boolean added = false;
                //检查这一列有没有重复的
                for (int k = i+1; k < 9; k++) {
                    if (board[k][j] == val) {
                        return false;
                    }


                }

                //检查 3x3 是否出现
                int rowOfGrid;
                if (i < 3){
                    //0-2 网格在一行
                    rowOfGrid= 0;
                }else if ( i >=3 && i<6){
                    //3-5 网格在2行
                    rowOfGrid= 1;
                }else {
                    //其他的在第三行
                    rowOfGrid = 2;
                }

                int columnOfGrid;
                if (j < 3){
                    //0-2 网格在一列
                    columnOfGrid= 0;
                }else if ( j >=3 && j<6){
                    //3-5 网格在2列
                    columnOfGrid= 1;
                }else {
                    //其他的在第三列
                    columnOfGrid = 2;
                }
                for (int i1 = 0; i1 < boxes[rowOfGrid][columnOfGrid].length; i1++) {
                    if (boxes[rowOfGrid][columnOfGrid][i1] == val){
                        //所在网格有重复数字
                        return false;
                    }

                    //存储数字
                    if (!added && boxes[rowOfGrid][columnOfGrid][i1] == 0){
                        boxes[rowOfGrid][columnOfGrid][i1] = val;
                        added = true;
                    }

                }

            }
        }
         return true;
    }
}
