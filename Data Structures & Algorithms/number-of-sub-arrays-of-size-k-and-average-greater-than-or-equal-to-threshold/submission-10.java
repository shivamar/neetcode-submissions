class Solution {
public int numOfSubarrays(int[] arr, int k, int threshold) {
    int targetSum = threshold * k;
    int curSum = 0;
    int count = 0;
    for (int right = 0; right < arr.length; right++) {
        curSum += arr[right];
        if (right >= k - 1) {
            if (curSum >= targetSum) {
                count++;
            }
            curSum -= arr[right - k + 1];
        }
    }
    return count;
}
}