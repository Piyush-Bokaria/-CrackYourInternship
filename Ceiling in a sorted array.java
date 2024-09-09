//Day 45 of #CrackYourInternship
class Main {
    static int ceilSearch(int arr[], int low, int high,
                          int x)
    {
        
        if (x == 0) {
            return -1;
        }
        while (low <= high) {
            int mid
                = low + (high - low) / 2; 
 
            if (x == arr[mid]) {
                return mid;
            }
            if (x < arr[mid]) {
                high = mid - 1;
            }
 
            else {
                low = mid + 1;
            }
        }
        return low;
    }
}
