import java.util.ArrayList;

public class Assignment7 {

    public static void mergeSort(ArrayList<Integer> arr) {
        if (arr.size() < 2) {
            return;
        }
        int mid = arr.size() / 2;
        ArrayList<Integer> left = new ArrayList<>(arr.subList(0, mid));
        ArrayList<Integer> right = new ArrayList<>(arr.subList(mid, arr.size()));

        mergeSort(left);
        mergeSort(right);

        merge(arr, left, right);
    }

    public static void merge(ArrayList<Integer> arr, ArrayList<Integer> left, ArrayList<Integer> right) {
        int i = 0, j = 0, k = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i) <= right.get(j)) {
                arr.set(k, left.get(i));
                i++;
            } else {
                arr.set(k, right.get(j));
                j++;
            }
            k++;
        }
        while (i < left.size()) {
            arr.set(k, left.get(i));
            i++;
            k++;
        }
        while (j < right.size()) {
            arr.set(k, right.get(j));
            j++;
            k++;
        }
    }

    public static void bubbleSort(ArrayList<Integer> arr) {
        int n = arr.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr.get(j) > arr.get(j + 1)) {
                    // swap temp and arr[i]
                    int temp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, temp);
                }
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(64);
        arr.add(34);
        arr.add(25);
        arr.add(12);
        arr.add(22);
        arr.add(11);
        arr.add(90);

        System.out.println("Original array: " + arr);

        ArrayList<Integer> arr1 = new ArrayList<>(arr);
        mergeSort(arr1);
        System.out.println("Array after Merge Sort: " + arr1);

        ArrayList<Integer> arr2 = new ArrayList<>(arr);
        bubbleSort(arr2);
        System.out.println("Array after Bubble Sort: " + arr2);
    }
}
