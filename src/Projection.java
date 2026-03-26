public class Projection {

    public static int[] project(double x, double y, double z) {
        double scale = 1 / (1 + z * 0.01);
        return new int[] {
                (int)(x * scale),
                (int)(y * scale)
        };
    }
}