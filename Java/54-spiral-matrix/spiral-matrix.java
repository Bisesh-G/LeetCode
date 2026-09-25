class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        int sI = 0;
        int sJ = 0;
        int eI = matrix.length - 1;
        int eJ = matrix[0].length - 1;

        List<Integer> A = new ArrayList<>();

        while (sI <= eI && sJ <= eJ) {
            for (int i = sJ; i <= eJ; i++) {
                A.add(matrix[sI][i]);
            }
            sI++;
            for (int i = sI; i <= eI; i++) {
                A.add(matrix[i][eJ]);
            }
            eJ--;
            if (sI <= eI) {
                for (int i = eJ; i >= sJ; i--) {
                    A.add(matrix[eI][i]);
                }
                eI--;
            }
            if (sJ <= eJ) {
                for (int i = eI; i >= sI; i--) {
                    A.add(matrix[i][sJ]);
                }
                sJ++;
            }
        }
        return A;
    }
}