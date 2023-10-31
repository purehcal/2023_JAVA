import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MethodReferenceLowerCase {

    public static void main(String[] args) {
        // 문자열 목록을 생성
        List<String> listOfNames = Arrays.asList(new String[]{"Apple", "Banana", "Cherry"});

        // 스트림을 사용하여 문자열 목록의 각 문자열을 소문자로 변환하고 새로운 목록으로 수집
        List<String> lowerCaseList = listOfNames.stream()
                .map(String::toLowerCase) // String::toLowerCase 메서드 참조를 사용하여 문자열을 소문자로 변환
                .collect(Collectors.toList());

        // 결과 출력
        System.out.println(lowerCaseList); // ["apple", "banana", "cherry"]
    }
}
