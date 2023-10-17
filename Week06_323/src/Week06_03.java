import java.util.*;
import java.util.stream.Collectors;

enum Type{
	MEAT, FISH, OTHER;
}


public class Week06_03 {
    public static void main(String[] args) {
        List<Food> foodList = new ArrayList<>();List<String> vegLowCalFoods = foodList.stream()
                .filter(food -> food.isVege() && food.getCalories() <= 300)
                .map(Food::getName)
                .collect(Collectors.toList());
    }
}