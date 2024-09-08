//Day 44 of #CrackYourInternship
class GfG
{
    int maxLen(int arr[], int n)
    {
        // Your code here
        int maxi = 0;
        int sum = 0;
        Map<Integer, Integer> hash = new HashMap<>();
        hash.put(0, -1);
    
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (hash.containsKey(sum)) {
                int prevIndex = hash.get(sum);
                maxi = Math.max(maxi, i - prevIndex);
            } else {
                hash.put(sum, i);
            }
        }
    
        return maxi;

    }
}
