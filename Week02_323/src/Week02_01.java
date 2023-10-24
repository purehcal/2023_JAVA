class Circle {
    protected int radius;

    // Circle 클래스의 생성자
    public Circle(int r) {
        radius = r;
    }
}

class Pizza extends Circle {
    String p;

    // Pizza 클래스의 생성자
    public Pizza(String p, int r) {
        super(r); // 상위 클래스 Circle의 생성자 호출
        this.p = p;
    }

    // print 메서드: 원의 반지름과 피자 이름을 출력하는 메서드
    public void print() {
        System.out.println(radius + " is the radius of " + p);
    }
}

public class Week02_01 {
    public static void main(String[] args) {
        // Pizza 객체 생성 및 초기화
        Pizza obj = new Pizza("Pepperoni", 20);
        obj.print(); // print 메서드 호출하여 정보 출력
    }
}
