package year19;

import java.util.*;

/**
 * http://118.190.20.162/view.page?gpid=T89
 */
public class SmallMiddleBig {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = 0;
        String line1 = null;
        String line2 = null;
        while (scanner.hasNextLine()) {
            count++;
            if (count == 1) {
                line1 = scanner.nextLine();
            } else if (count == 2) {
                line2 = scanner.nextLine();
                break;
            }
        }

        int[] ints = new int[Integer.parseInt(line1)];
        String[] inputInts = line2.split(" ");
        for (int i = 0; i < inputInts.length; i++) {
            ints[i] = Integer.parseInt(inputInts[i]);
        }
        ShellSort(ints);
        int middle = 0;
        int length = ints.length;
        int max = ints[length - 1];
        int min = ints[0];
        if (length % 2 == 0) {
            int index1 = length / 2 - 1;
            int index2 = length / 2 ;
            //System.out.println(ints[index1]);
            //System.out.println(ints[index2]);
            middle = (ints[index1] + ints[index2]) / 2;
        } else {
            int index = length / 2;
            middle = ints[index];
        }

        int[] result = new int[]{max, min, middle};
        ShellSort(result);
        System.out.println(result[2] + " " + result[1] + " " + result[0]);


    }

    /**
     * 希尔排序
     *
     * @param array
     * @return
     */
    private static int[] ShellSort(int[] array) {
        int len = array.length;
        int temp, gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                temp = array[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && array[preIndex] > temp) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = temp;
            }
            gap /= 2;
        }
        return array;
    }
}
