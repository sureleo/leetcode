class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        int resultWithoutSwapFirst = findRotation(A, B);
        
        int temp = A[0];
        A[0] = B[0];
        B[0] = temp;
        
        int resultWithSwapFirst = findRotation(A, B);
        
        if (resultWithoutSwapFirst == -1) {
            return resultWithSwapFirst;
        } else if (resultWithSwapFirst == -1) {
            return resultWithoutSwapFirst;
        } else {
            return Math.min(resultWithoutSwapFirst, resultWithSwapFirst + 1);
        }
    }
    
    private int findRotation(int[] A, int[] B) {
        int result = A.length + 1;
        
        int moveUp = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] != A[0]) {
                if (B[i] == A[0]) {
                    moveUp ++;
                } else {
                    moveUp = -1;
                    break;
                }
            }
        }
        
        if (moveUp != -1) {
            result = Math.min(moveUp, result);
        }
        
        int moveDown = 0;
        for (int i = 1; i < B.length; i++) {
            if (B[i] != B[0]) {
                if (A[i] == B[0]) {
                    moveDown ++;
                } else {
                    moveDown = -1;
                    break;
                }
            }
        }
        
        if (moveDown != -1) {
            result = Math.min(result, moveDown);
        }
        
        if (result == A.length + 1) {
            return -1;
        }
        
        return result;
    }
}
