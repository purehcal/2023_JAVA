import java.util.Arrays;

interface ArrayProcessing {
    double apply(double[] array);
}

public class LambdaTest {
    public static final ArrayProcessing maxer = array -> {
        double max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    };

    public static final ArrayProcessing miner = array -> {
       double min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    };

    public static final ArrayProcessing sumer = array -> {
        if (array.length == 0) {
            return 0.0;
        }
        double sum = Arrays.stream(array).sum();
        return sum / array.length;
    };

    public static void main(String[] args) {
        double[] numbers = { 10.5, 3.0, 7.2, 1.8, 9.6 };

        double maxResult = maxer.apply(numbers);
        System.out.println("Max: " + maxResult);

        double minResult = miner.apply(numbers);
        System.out.println("Min: " + minResult);

        double sumResult = sumer.apply(numbers);
        System.out.println("Average: " + sumResult);
    }
}
