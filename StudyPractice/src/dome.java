public class dome {
    public static void main(String[] args) {
        int[] array = new int[30];
        array[0] = 1;
        array[1] = 1;
        for (int i = 2; i < array.length; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        int j = 0;
        for (int port : array) {
            j++;
            System.out.print(port + "\t");
            while (j > 4) {
                System.out.println();
                j = 0;
            }
        }
    }
}
