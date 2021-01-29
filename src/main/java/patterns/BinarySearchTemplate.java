package patterns;

public class BinarySearchTemplate {
    public boolean binarySearch(int []arr, int key) {
        int lo = 0, hi = arr.length -1;
        int mid;
        while(lo < hi) {
            mid = lo + (hi -lo)/2;

//            if(arr[mid] == key) {   // this condition is not needed as, we break at lo = high
//                return true;
//            }
            if(arr[mid] < key) {
                lo = mid + 1; // +1 avoids infinte loops
            } else {
                hi = mid;
            }

        }

        if(arr[lo] == key) {
            return true;
        } else {
            return false;
        }

    }

    boolean recursiveBinarySearch(int arr[],int lo, int hi, int key) {
        if(lo == hi) {
            if(arr[lo] == key) {
                return true;
            } else {
                return false;
            }
        }

        int mid = lo + (hi-lo)/2;
        if(key == arr[mid]) {
            return true;
        }
        if(arr[mid] < key) {
            return recursiveBinarySearch(arr, mid+1, hi, key);
        } else {
            return recursiveBinarySearch(arr, lo, mid -1, key);
        }

    }
}
