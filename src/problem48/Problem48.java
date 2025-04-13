package problem48;

public class Problem48 {
    public int mySqrtNaive(int x) {
        int i = 0;
        while (i * i <= x) {
            i++;
        }
        return i - 1;
    }

    public int mySqrtOptimized(int x) {
        int lb = 0;
        int ub = x;
        while (lb < ub) {
            int mid = (lb + ub) / 2;
            long sqr = (long) mid * mid;
            if (sqr < x) {
                long sqrMore = (long) (mid + 1) * (mid + 1);
                if (sqrMore > x) {
                    return mid;
                }
                lb = mid + 1;
            } else if (sqr > x) {
                long sqrLess = (long) (mid - 1) * (mid - 1);
                if (sqrLess < x) {
                    return mid - 1;
                }
                ub = mid - 1;
            } else {
                return mid;
            }
        }
        return (lb + ub) / 2;
    }
}
