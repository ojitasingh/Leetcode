class Solution {
  public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
    List<Integer> keyIndices = new ArrayList<>();
    List<Integer> result = new ArrayList<>();

    // Step 1: Find all indices where nums[i] == key
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == key) {
        keyIndices.add(i);
      }
    }

    // Step 2: For each index i, check if it's within k distance of any key index
    for (int i = 0; i < nums.length; i++) {
      for (int j : keyIndices) {
        if (Math.abs(i - j) <= k) {
          result.add(i);
          break; // No need to check further key indices for this i
        }
      }
    }

    return result;
  }
}
