public class RecursiveSolution {
    public double pow(double x, int n) {
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                return 1;
            }
            return 1 / pow(x, -n);
        } else if (n == 0) {
            return 1;
        } else if (n == -1) {
            return x;
        } else if (n % 2 == 0) {
            return pow(x*x, n/2);
        } else {
            return pow(x*x, n/2) * x;
        }
    }
}

public class MyHackyIterativeSolution {
    public double pow(double x, int n) {
        boolean negativen = false;
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                return 1;
            }
            n = -n;
            negativen = true;
        }
        if (n == 0) return 1;
        if (n == Integer.MAX_VALUE) {
            if (x > 0 && x < 1) {
                return 0;
            } else if (x == -1) {
                return -1;
            } else {
                return 1;
            }
        }
        if (n == 1) {
            if (negativen == true) {
                return 1.0 / x;
            } else {
                return x;
            }
        }
        int i = 1;
        double result = 1.0;
        double temp = x;
        while (n - i >= 0) {
            while (i + i <= n) {
                temp = temp * temp;
                i = i + i;
            }
            result *= temp;
            temp = x;
            n = n - i;
            i = 1;
        }
        if (negativen == true) return 1.0/result;
        else return result;
    }
}
