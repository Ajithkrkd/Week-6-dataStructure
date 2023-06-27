public class HeapSortSample {

    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = n/2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }

    }
    public void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = (i * 2) + 1;
        int right = (i * 2) + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }

    }
     public void covertAndprintToheap(int[] arr) {
        sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
    }

    public static void main(String[] args) {
        HeapSortSample h = new HeapSortSample();
        int[] arr = new int[] { -1, 0, 10, 9, 5, 6 };
        h.covertAndprintToheap(arr);
    }
}