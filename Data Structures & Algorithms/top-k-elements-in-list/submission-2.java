class Solution {
  public int[] topKFrequent(int[] nums, int k) {
    PriorityQueue<int[]> minQueue = new PriorityQueue<int[]>((a, b) -> (a[1] - b[1]));
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int n : nums) {
      map.put(n, map.getOrDefault(n, 0) + 1);
    }

    int[] valu = new int[2];
    for (Map.Entry<Integer, Integer> eSet : map.entrySet()) {
      if (minQueue.size() == k) {
        if (eSet.getValue() < minQueue.peek()[1])
          continue;
        minQueue.poll();
      }
      valu = new int[] {eSet.getKey(), eSet.getValue()};
      minQueue.offer(valu);
    }

    int[] result = new int[k];

    for (int i = 0; i < k; i++) {
      if (minQueue.size() == 0)
        break;

      int[] val = minQueue.poll();
      result[i] = val[0];
    }

    return result;
  }
}
