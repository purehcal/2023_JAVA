public class Food {
    String name;       // 음식의 이름을 저장하는 멤버 변수
    boolean Vege;      // 채식 요리 여부를 나타내는 멤버 변수
    int calories;      // 음식의 칼로리를 저장하는 멤버 변수
    Type type;         // 음식의 유형을 저장하는 멤버 변수

    // Food 클래스의 생성자
    public Food(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.Vege = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    // 음식의 이름을 반환하는 메서드
    public String getName() {
        return name;
    }

    // 음식이 채식 요리인지 여부를 반환하는 메서드
    public boolean isVege() {
        return Vege;
    }

    // 음식의 채식 여부를 설정하는 메서드
    public void setVege(boolean vege) {
        Vege = vege;
    }

    // 음식의 칼로리를 반환하는 메서드
    public int getCalories() {
        return calories;
    }

    // 음식의 유형을 반환하는 메서드
    public Type getType() {
        return type;
    }

    // 객체를 문자열로 표시하기 위해 toString 메서드를 재정의
    public String toString() {
        return name;
    }
}
