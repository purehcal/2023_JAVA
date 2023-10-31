import java.util.*;
import java.util.stream.Collectors;

enum Type{
	MEAT, FISH, OTHER;
}


public class Week06_03 {
    public static void main(String[] args) {
        List<Food> foodList = new ArrayList<>(); // Food 객체를 저장할 리스트를 생성

        // 스트림을 사용하여 음식 리스트를 필터링하고, 저칼로리의 채식 음식의 이름만 모은 리스트 생성
        List<String> vegLowCalFoods = foodList.stream()
                .filter(food -> food.isVege() && food.getCalories() <= 300) // 조건에 맞는 음식만 필터링
                .map(Food::getName) // 음식 객체를 이름(String)으로 매핑
                .collect(Collectors.toList()); // 필터링된 결과를 리스트로 수집

        // vegLowCalFoods 리스트는 이제 채식이면서 300 칼로리 이하인 음식들의 이름을 포함합니다.
    }
}