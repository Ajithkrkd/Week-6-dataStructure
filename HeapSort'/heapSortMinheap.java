
public class heapSortMinheap {

    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapfy(arr, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapfy(arr, i, 0);
        }
    }

    public void heapsortDecrese(int[] arr) {
        sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
    }

    public void heapfy(int[] arr, int n, int i) {
        int smallest = i;
        int left = (i * 2) + 1;
        int right = (i * 2) + 2;

        if (left < n && arr[left] < arr[smallest]) {
            smallest = left;
        }
        if (right < n && arr[right] < arr[smallest]) {
            smallest = right;
        }

        if (smallest != i) {
            int temp = arr[smallest];
            arr[smallest] = arr[i];
            arr[i] = temp;

            heapfy(arr, n, smallest);
        }

    }

    public static void main(String[] args) {
        heapSortMinheap h = new heapSortMinheap();
        int[] arr = new int[] { 6, 3, -1, 2, 4, 5 };
        h.heapsortDecrese(arr);
    }
}