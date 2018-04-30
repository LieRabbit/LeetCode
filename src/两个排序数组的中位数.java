/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。
 * 请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。
 * 示例 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * 中位数是 2.0
 * 示例 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 中位数是 (2 + 3)/2 = 2.5
 */
public class 两个排序数组的中位数 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 < n2)
            return findMedianSortedArrays(nums2, nums1);
        int lo = 0, hi = n2 * 2;
        while (lo <= hi) {
            int mid2 = (lo + hi) >> 1;
            int mid1 = n1 + n2 - mid2;
            double L1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[(mid1 - 1) / 2];
            double L2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[(mid2 - 1) / 2];
            double R1 = (mid1 == n1 * 2) ? Integer.MAX_VALUE : nums1[mid1 / 2];
            double R2 = (mid2 == n2 * 2) ? Integer.MAX_VALUE : nums2[mid2 / 2];

            if (L1 > R2)
                lo = mid2 + 1;
            else if (L2 > R1)
                hi = mid2 - 1;
            else
                return (Math.max(L1, L2) + Math.min(R1, R2)) / 2;
        }

        return -1;
    }

    public static void main(String[] args) {
        两个排序数组的中位数 test = new 两个排序数组的中位数();
        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {5, 6, 7, 8};
        System.out.println(test.findMedianSortedArrays(nums1, nums2));
    }
}
