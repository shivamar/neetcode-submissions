class Solution {
    public int orangesRotting(int[][] grid) {
        ArrayDeque<int[]> arrayDeq = new ArrayDeque<int[]>();
        int fresh = 0;

        // add all source
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    arrayDeq.offer(new int[] {i, j});
                }

                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int minute = 0;

        while (!arrayDeq.isEmpty() && fresh > 0) {
            int levelSize = arrayDeq.size();

            // loop through all rotten mango in 1 level fr 1 minute
            for (int k = 0; k < levelSize; k++) {
                int[] arr = arrayDeq.poll();
                int i = arr[0];
                int j = arr[1];

                for (int[] dir : dirs) {
                    if (dir[0] + i < 0 || dir[0] + i > grid.length - 1 || dir[1] + j < 0
                        || dir[1] + j > grid[0].length - 1 || grid[dir[0] + i][dir[1] + j] != 1)
                        continue;

                    arrayDeq.offer(new int[] {dir[0] + i, dir[1] + j});
                    grid[dir[0] + i][dir[1] + j] = 2; // rot it as u add to queue
                    fresh--;
                }
            }
            minute++;
        }

        return fresh == 0 ? minute : -1;
    }
}
