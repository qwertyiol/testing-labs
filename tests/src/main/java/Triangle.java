public class Triangle {
    public static boolean Check(double A, double B, double C) {
        if (A > 0 && B > 0 && C > 0 && A + B > C && A + C > B && B + C > A) {
            return true;
        }
        return false;
    }
}
