import java.util.Stack;

class IterativeQuickSort {
    // Driver code to test above
    public static void main(String args[]) {
        IterativeQuickSort ob = new IterativeQuickSort();
        int arr[] = {4, 3, 5, 2, 1, 3, 2, 3};
        ob.QuickSort(arr, 0, arr.length - 1);
        ob.printArr(arr, arr.length);
    }

    void swap(int arr[], int i, int j) {
        if (i!=j) {
            arr[i] = arr[i] ^ arr[j];
            arr[j] = arr[i] ^ arr[j];
            arr[i] = arr[i] ^ arr[j];
        }
    }

    /* This function is same in both iterative and
       recursive*/
    int partition(int arr[], int l, int h) {
        int pivotIndex = h;
        int i = l - 1;

        for (int j = l; j < h; j++) {
            if (arr[j] < arr[pivotIndex]) {
                i++;
                swap(arr, i, j);
            }
        }
        i++;
        swap(arr, i, pivotIndex);
        return i;
    }

    // Sorts arr[l..h] using iterative QuickSort
    void QuickSort(int arr[], int l, int h) {
        Stack<Integer> stack = new Stack<>();
        stack.push(l);
        stack.push(h);

        while (!stack.isEmpty()) {
            h = stack.pop();
            l = stack.pop();

            int partitionIndex = partition(arr, l, h);

            if (partitionIndex - 1 > l) {
                stack.push(l);
                stack.push(partitionIndex - 1);
            }
            if (partitionIndex + 1 < h) {
                stack.push(partitionIndex + 1);
                stack.push(h);
            }
        }
    }

    // A utility function to print contents of arr
    void printArr(int arr[], int n) {
        int i;
        for (i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
    }
}