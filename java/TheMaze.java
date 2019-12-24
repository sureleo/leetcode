import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class TheMaze {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int row = maze.length;
        int col = maze[0].length;

        Quad[][] quads = new Quad[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                quads[i][j] = new Quad();
            }
        }

        fillQuadLeft(maze, quads);
        fillQuadUp(maze, quads);
        fillQuadRight(maze, quads);
        fillQuadDown(maze, quads);

        Queue<String> queue = new LinkedList<>();
        String startString = start[0] + "," + start[1];
        String endString = destination[0] + "," + destination[1];

        Set<String> visited = new HashSet<>();

        queue.offer(startString);

        while (!queue.isEmpty()) {
            String curr = queue.poll();

            if (curr.equals(endString)) {
                return true;
            }

            visited.add(curr);
            String[] coordinate = curr.split(",");
            int x = Integer.parseInt(coordinate[0]);
            int y = Integer.parseInt(coordinate[1]);

            if (quads[x][y].left != -1) {
                int newY = quads[x][y].left;
                String newNode = x + "," + newY;
                if (!visited.contains(newNode)) {
                    queue.offer(newNode);
                }
            }

            if (quads[x][y].right != -1) {
                int newY = quads[x][y].right;
                String newNode = x + "," + newY;
                if (!visited.contains(newNode)) {
                    queue.offer(newNode);
                }
            }

            if (quads[x][y].up != -1) {
                int newX = quads[x][y].up;
                String newNode = newX + "," + y;
                if (!visited.contains(newNode)) {
                    queue.offer(newNode);
                }
            }

            if (quads[x][y].down != -1) {
                int newX = quads[x][y].down;
                String newNode = newX + "," + y;
                if (!visited.contains(newNode)) {
                    queue.offer(newNode);
                }
            }
        }

        return false;
    }

    private void fillQuadRight(int[][] maze, Quad[][] quads) {
        int row = maze.length;
        int col = maze[0].length;

        for (int i = 0; i < row; i++) {
            int rightMost = -1;
            for (int j = col - 1; j >= 0; j--) {
                if (maze[i][j] == 0 && rightMost == -1) {
                    rightMost = j;
                } else {
                    if (maze[i][j] == 0) {
                        quads[i][j].right = rightMost;
                    } else {
                        rightMost = -1;
                    }
                }
            }
        }
    }

    private void fillQuadDown(int[][] maze, Quad[][] quads) {
        int row = maze.length;
        int col = maze[0].length;

        for (int j = 0; j < col; j++) {
            int downMost = -1;
            for (int i = row - 1; i >= 0; i--) {
                if (maze[i][j] == 0 && downMost == -1) {
                    downMost = i;
                } else {
                    if (maze[i][j] == 0) {
                        quads[i][j].down = downMost;
                    } else {
                        downMost = -1;
                    }
                }
            }
        }
    }

    private void fillQuadLeft(int[][] maze, Quad[][] quads) {
        int row = maze.length;
        int col = maze[0].length;

        for (int i = 0; i < row; i++) {
            int leftMost = -1;
            for (int j = 0; j < col; j++) {
                if (maze[i][j] == 0 && leftMost == -1) {
                    leftMost = j;
                } else {
                    if (maze[i][j] == 0) {
                        quads[i][j].left = leftMost;
                    } else {
                        leftMost = -1;
                    }
                }
            }
        }
    }

    private void fillQuadUp(int[][] maze, Quad[][] quads) {
        int row = maze.length;
        int col = maze[0].length;

        for (int j = 0; j < col; j++) {
            int upMost = -1;
            for (int i = 0; i < row; i++) {
                if (maze[i][j] == 0 && upMost == -1) {
                    upMost = i;
                } else {
                    if (maze[i][j] == 0) {
                        quads[i][j].up = upMost;
                    } else {
                        upMost = -1;
                    }
                }
            }
        }
    }

    class Quad {
        public int left;
        public int up;
        public int right;
        public int down;

        public Quad() {
            left = -1;
            up = -1;
            right = -1;
            down = -1;
        }
    }

    @Test
    public void test() {
        int[][] maze = {{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}};
        int[] start = {0, 4};
        int[] destination = {3, 2};

        TheMaze theMaze = new TheMaze();
        boolean hasPath = theMaze.hasPath(maze, start, destination);

        Assert.assertFalse(hasPath);
    }

    @Test
    public void test2() {
        int[][] maze = {
                {0, 0, 0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1},
                {0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 1},
                {0, 0, 0, 0, 1, 0, 0}
        };
        int[] start = {0, 0};
        int[] destination = {8, 6};

        TheMaze theMaze = new TheMaze();
        boolean hasPath = theMaze.hasPath(maze, start, destination);

        Assert.assertTrue(hasPath);
    }
}
