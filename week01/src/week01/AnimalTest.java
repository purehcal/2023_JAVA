package week01;

// Animal 클래스를 정의합니다.
class Animal {
    String name;

    // Animal 클래스의 생성자로 이름을 입력받습니다.
    public Animal(String name) {
        this.name = name;
    }

    // 동물이 잠자는 메서드를 정의합니다.
    public void sleep() {
        System.out.println(name + "이(가) 잠을 자고 있습니다");
    }

    // 동물이 먹는 메서드를 정의합니다.
    public void eat() {
        System.out.println(name + "이(가) 먹고 있습니다");
    }
}

// Animal 클래스를 확장한 Dog 클래스를 정의합니다.
class Dog extends Animal {
    
    // Dog 클래스의 생성자로 이름을 입력받습니다.
    public Dog(String name) {
        super(name); // 상위 클래스(Animal)의 생성자를 호출합니다.
    }

    // 개가 짖는 메서드를 정의합니다.
    public void bark() {
        System.out.println(name + "이(가) 짖고 있습니다");
    }
}

// Animal 클래스를 확장한 Cat 클래스를 정의합니다.
class Cat extends Animal {

    // Cat 클래스의 생성자로 이름을 입력받습니다.
    public Cat(String name) {
        super(name); // 상위 클래스(Animal)의 생성자를 호출합니다.
    }

    // 고양이가 놀고 있는 메서드를 정의합니다.
    public void play() {
        System.out.println(name + "이(가) 노는 중입니다");
    }
}

// 주요 실행 클래스인 AnimalTest 클래스입니다.
public class AnimalTest {

    public static void main(String[] args) {
        // "Luke"라는 이름을 가진 Dog 객체를 생성합니다.
        Dog dog = new Dog("Luke");
        
        // "Goyang"이라는 이름을 가진 Cat 객체를 생성합니다.
        Cat cat = new Cat("Goyang");
        
        // 각 메서드를 호출하여 개와 고양이의 활동을 표시합니다.
        dog.sleep();
        dog.eat();
        dog.bark();
        
        cat.sleep();
        cat.eat();
        cat.play();
    }
}
