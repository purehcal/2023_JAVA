import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestStream {
    public static void main(String[] args) {
        // 문자열 목록을 생성
        List<String> list = Arrays.asList("Kim", "Park", "Lee", "Choi", "Chee");

        // 스트림을 사용하여 목록에서 필터링, 정렬 및 수집을 수행
        List<String> sublist = list.stream()
                .filter(s -> s.startsWith("C")) // 문자열이 "C"로 시작하는 경우만 필터링
                .sorted() // 알파벳 순으로 정렬
                .collect(Collectors.toList()); // 결과를 새로운 목록으로 수집

        // 필터링 및 정렬된 결과 출력
        System.out.println(sublist); // ["Choi", "Chee"]
    }
}
