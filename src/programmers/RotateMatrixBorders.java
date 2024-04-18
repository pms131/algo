package programmers;

/**
 * 행렬 테두리 회전하기
 *
 * @see <a href = "https://school.programmers.co.kr/learn/courses/30/lessons/77485">행렬 테두리 회전하기</a>
 */
public class RotateMatrixBorders {
    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] matrix = new int[rows + 1][columns + 1];

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                matrix[i][j] = (i - 1) * columns + j;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            answer[i] = dfs(queries[i], matrix, new int[]{queries[i][0], queries[i][1]}, 0, rows * columns + 1, matrix[queries[i][0]][queries[i][1]]);
        }

        return answer;
    }

    private int dfs(int[] query, int[][] matrix, int[] position, int index, int min, int nextNum) {
        int row = position[0];
        int col = position[1];
        int startRow = query[0];
        int startCol = query[1];
        int endRow = query[2];
        int endCol = query[3];

        if (row == startRow && col == startCol && index > dx.length - 1) {
            return min;
        }

        if (matrix[row][col] < min) {
            min = matrix[row][col];
        }

        int nextRow = row + dy[index];
        int nextCol = col + dx[index];

        if (nextRow > endRow || nextCol > endCol || nextRow < startRow || nextCol < startCol) {
            return dfs(query, matrix, new int[]{row, col}, index + 1, min, nextNum);
        } else {
            int tmp = matrix[nextRow][nextCol];
            matrix[nextRow][nextCol] = nextNum;
            nextNum = tmp;

            return dfs(query, matrix, new int[]{nextRow, nextCol}, index, min, nextNum);
        }
    }
}
