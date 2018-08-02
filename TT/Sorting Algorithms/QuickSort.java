public class QuickSort {

    public static void executeSort(int[] input) {
        quickSort(input, 0, input.length - 1);
    }

    public static void quickSort(int[] input, int from, int to) {
        if (from < to) {
            int indexOfPivot = partition(input, from, to);
            quickSort(input, from, indexOfPivot - 1);
            quickSort(input, indexOfPivot + 1, to);
        }
    }

    public static int partition(int[] input, int from, int to) {
        int pivot = input[to];
        int wall = from;

        for (int i = from; i < to; i++) {
            if (input[i] <= pivot) {
                int temp = input[wall];
                input[wall] = input[i];
                input[i] = temp;
                wall++;
            }
        }

        input[to] = input[wall];
        input[wall] = pivot;

        return wall;
    }

    public static void main(String[] args) {
        int[] input = {10, 4, 15, 23, 3, 9, 1};
    }

}
