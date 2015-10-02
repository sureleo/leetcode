public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int rect1 = (C-A) * (D-B);
        int rect2 = (G-E) * (H-F);
        int op1 = 0;
        int op2 = 0;
        if (G >= C && E <= A) {
            op1 = C - A;
        } else if (G <= C && E >= A) {
            op1 = G - E;
        } else if (C <= E || G <= A) {
            op1 = 0;
        } else {
            op1 = Math.min(Math.abs(C-E), Math.abs(A-G));
        }
        
        if (H >= D && F <= B) {
            op2 = D - B;
        } else if (H <= D && B <= F) {
            op2 = H - F;
        } else if (F >= D || B >= H) {
            op2 = 0;
        } else {
            op2 = Math.min(Math.abs(H-B), Math.abs(D-F));
        }
        
        return rect1 + rect2 - op1 * op2;
    }
}
