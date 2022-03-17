import java.util.Scanner;

public class SparseArray {
    /**
     * 剔除的默认值
     */
    static int defData = 0;

    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        System.out.println("请输入二维数组行数：");
        int row = scanner.nextInt();
        System.out.println("请输入二维数组列数：");
        int list = scanner.nextInt();
        int[][] twoDimArray = getTwoDimArray(row, list, scanner);*/
        int[][] twoDimArray = {
                {1,2,3},
                {4,5,6},
                {7,8,9},
        };
        showArray(twoDimArray);
        int[][] sparseArray = getSparseArray(twoDimArray);
        showArray(sparseArray);
        int[][] reductionArray = getReductionArray(sparseArray);
        showArray(reductionArray);
    }

    /**
     * 获取二维数组
     *
     * @param row
     * @param list
     * @param scanner
     * @return
     */
    public static int[][] getTwoDimArray(int row, int list, Scanner scanner) {
        int[][] twoDimArray = new int[row][list];
        for (int i = 0; i < row; i++) {
            System.out.println("请输入第" + (i + 1) + "行的数据");
            for (int j = 0; j < list; j++) {
                twoDimArray[i][j] = scanner.nextInt();
            }
        }
        return twoDimArray;
    }

    /**
     * 显示数组
     *
     * @param array
     */
    public static void showArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("------------------------------");
    }

    /**
     * 二维数组稀疏化
     *
     * @param towDimArray
     * @return
     */
    public static int[][] getSparseArray(int[][] towDimArray) {
        int num = 0;
        for (int[] arrRow : towDimArray) {
            for (int data : arrRow) {
                if (data != defData) {
                    num++;
                }
            }
        }
        int[][] sparseArray = new int[num + 1][3];
        sparseArray[0][0] = towDimArray.length;
        sparseArray[0][1] = towDimArray[0].length;
        sparseArray[0][2] = num;
        int count = 0;
        for (int i = 0; i < towDimArray.length; i++) {
            for (int j = 0; j < towDimArray[0].length; j++) {
                if (towDimArray[i][j] != defData) {
                    count++;
                    sparseArray[count][0] = i + 1;
                    sparseArray[count][1] = j + 1;
                    sparseArray[count][2] = towDimArray[i][j];
                }
            }
        }
        return sparseArray;
    }

    /**
     * 稀疏数组的还原
     *
     * @param sparseArray
     * @return
     */
    public static int[][] getReductionArray(int[][] sparseArray) {
        int row = sparseArray[0][0];
        int list = sparseArray[0][1];
        int[][] resultArray = new int[row][list];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < list; j++) {
                resultArray[i][j] = defData;
            }
        }
        for (int i = 1; i < sparseArray.length; i++) {
            row = sparseArray[i][0];
            list = sparseArray[i][1];
            resultArray[row-1][list-1] = sparseArray[i][2];
        }
        return resultArray;
    }
}