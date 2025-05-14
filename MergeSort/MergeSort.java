public class MergeSort {

    private static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] sortedArr = new int[right - left + 1];
        int i = left, j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            sortedArr[k++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= mid) {
            sortedArr[k++] = arr[i++];
        }
        while (j <= right) {
            sortedArr[k++] = arr[j++];
        }
        System.arraycopy(sortedArr, 0, arr, left, right - left + 1);
    }

}
