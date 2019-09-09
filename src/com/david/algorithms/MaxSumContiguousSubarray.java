package com.david.algorithms;

import java.util.Arrays;
import java.util.List;

/**
 * https://www.interviewbit.com/problems/max-sum-contiguous-subarray/
 * https://leetcode.com/problems/maximum-subarray/
 *
 * <p>Example:
 *
 * <p>Input: [-2,1,-3,4,-1,2,1,-5,4],
 *
 * <p>IOutput: 6 Explanation: [4,-1,2,1] has the largest sum = 6.
 */
public class MaxSumContiguousSubarray {
  public static void main(String[] args) {
    System.out.println(maxSubArray(Arrays.asList(1, 2, 3, 4, -10)));
    System.out.println(maxSubArray(Arrays.asList(-2, 1, -3, 4, -1, 2, 1, -5, 4)));
  }

  // DO NOT MODIFY THE LIST. IT IS READ ONLY
  public static int maxSubArray(final List<Integer> A) {
    // The first element is the current and the max subarray, this is for A.length == 1
    int subArraySum = A.get(0);
    int max = A.get(0);

    // Iterate from second element to the end, It's because I already have the first one
    for (int i = 1; i < A.size(); i++) {

      // if the current element is greater than the sum of current + previous, That's means previous
      // sum was negative
      if (A.get(i) > (subArraySum + A.get(i))) {
        // Subarray sum is just the current element
        subArraySum = A.get(i);
      } else {
        // The subArraySum is increasing with the current element
        subArraySum = subArraySum + A.get(i);
      }
      // Store the maximum sum until now
      max = Math.max(max, subArraySum);
    }
    return max;
  }
}
