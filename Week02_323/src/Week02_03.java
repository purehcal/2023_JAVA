// Animal 인터페이스 선언
interface Animal {
    void walk();
    void fly();
    void sing();
}

// Bird 클래스는 Animal 인터페이스를 구현함
class Bird implements Animal {
    @Override
    public void walk() {
        System.out.println("걸을 수 있음.");
    }

    @Override
    public void fly() {
        System.out.println("날을 수 있음.");
    }

    @Override
    public void sing() {
        System.out.println("노래 부를 수 있음.");
    }
}

public class Week02_03 {
    public static void main(String[] args) {
        // Bird 클래스의 인스턴스 생성
        Bird bird = new Bird();

        // Bird 클래스의 메서드를 호출하여 각 능력을 출력
        bird.walk();
        bird.fly();
        bird.sing();
    }
}
