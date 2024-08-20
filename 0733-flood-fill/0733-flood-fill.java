class Solution {
    public static final int[] d = {0, 1, 0, -1, 0};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n= image[0].length;
        int pic = image[sr][sc];
        image[sr][sc] = color;
        // 시작 픽셀이 이미 목표 색상과 동일한 경우, 아무 작업도 필요 없음
        if (pic == color) return image;

        Deque<List<Integer>> queue = new ArrayDeque<>();
        List<Integer> pixel = Arrays.asList(sr, sc);
        queue.offer(pixel);

        while (!queue.isEmpty()) {
            List<Integer> start = queue.poll();
            Integer x = start.get(0);
            Integer y = start.get(1);

            for (int k = 0; k < 4; ++k) {
                int dx = x + d[k], dy = y + d[k + 1];
                if (0 <= dx && dx < m && 0 <= dy && dy < n && image[dx][dy]==pic) {
                    queue.offer(Arrays.asList(dx, dy));
                    image[dx][dy]=color;
                }
            }
        }

        return image;
    }
}