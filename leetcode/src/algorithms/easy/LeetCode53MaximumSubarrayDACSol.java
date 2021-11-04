package algorithms.easy;

public class LeetCode53MaximumSubarrayDACSol {

    private int[] numsArray;

    public int maxSubArray(int[] nums) {
        numsArray = nums;

        // Our helper function is designed to solve this problem for
        // any array - so just call it using the entire input!
        return findBestSubarray(0, numsArray.length - 1);
    }

    private int findBestSubarray(int left, int right) {
        // Base case - empty array.
        if (left > right) {
            return Integer.MIN_VALUE;
        }

        int mid = Math.floorDiv(left + right, 2);
        int curr = 0;
        int bestLeftSum = 0;
        int bestRightSum = 0;

        // Iterate from the middle to the beginning.
        for (int i = mid - 1; i >= left; i--) {
            curr += numsArray[i];
            bestLeftSum = Math.max(bestLeftSum, curr);
        }

        // Reset curr and iterate from the middle to the end.
        curr = 0;
        for (int i = mid + 1; i <= right; i++) {
            curr += numsArray[i];
            bestRightSum = Math.max(bestRightSum, curr);
        }

        // The bestCombinedSum uses the middle element and the best
        // possible sum from each half.
        int bestCombinedSum = numsArray[mid] + bestLeftSum + bestRightSum;

        // Find the best subarray possible from both halves.
        int leftHalf = findBestSubarray(left, mid - 1);
        int rightHalf = findBestSubarray(mid + 1, right);

        // The largest of the 3 is the answer for any given input array.
        return Math.max(bestCombinedSum, Math.max(leftHalf, rightHalf));
    }

    public static void main(String[] args) {
        LeetCode53MaximumSubarrayDACSol maximumSubarray = new LeetCode53MaximumSubarrayDACSol();
        System.out.println(maximumSubarray.maxSubArray(new int[]{-84, -87, -78, -16, -94, -36, -87, -93, -50, -22, -63, -28, -91, -60, -64, -27, -41, -27, -73, -37, -12, -69, -68, -30, -83, -31, -63, -24, -68, -36, -30, -3, -23, -59, -70, -68, -94, -57, -12, -43, -30, -74, -22, -20, -85, -38, -99, -25, -16, -71, -14, -27, -92, -81, -57, -74, -63, -71, -97, -82, -6, -26, -85, -28, -37, -6, -47, -30, -14, -58, -25, -96, -83, -46, -15, -68, -35, -65, -44, -51, -88, -9, -77, -79, -89, -85, -4, -52, -55, -100, -33, -61, -77, -69, -40, -13, -27, -87, -95, -40}));

    }
}
