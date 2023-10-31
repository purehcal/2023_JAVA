import java.util.Arrays;

// 배열 처리 인터페이스 정의
interface ArrayProcessing {
    double apply(double[] array);
}

public class LambdaTest {
    // 최댓값 계산 람다
    public static final ArrayProcessing maxer = array -> {
        double max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    };

    // 최솟값 계산 람다
    public static final ArrayProcessing miner = array -> {
        double min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    };

    // 평균 계산 람다
    public static final ArrayProcessing sumer = array -> {
        if (array.length == 0) {
            return 0.0;
        }
        double sum = Arrays.stream(array).sum();
        return sum / array.length;
    };

    public static void main(String[] args) {
        double[] numbers = { 10.5, 3.0, 7.2, 1.8, 9.6 };

        // 최댓값 계산 및 출력
        double maxResult = maxer.apply(numbers);
        System.out.println("Max: " + maxResult);

        // 최솟값 계산 및 출력
        double minResult = miner.apply(numbers);
        System.out.println("Min: " + minResult);

        // 평균 계산 및 출력
        double sumResult = sumer.apply(numbers);
        System.out.println("Average: " + sumResult);
    }
}

