package Generic;

class Container<T> {
    private T t; // 제네릭 타입을 이용한 데이터 멤버

    public T get() {
        return t; // 저장된 데이터 반환
    }

    public void set(T t) {
        this.t = t; // 데이터 설정
    }
}

public class Week05_01 {

    public static void main(String[] args) {
        // String 타입을 저장하는 Container 객체 생성
        Container<String> container1 = new Container<String>();
        container1.set("홍길동"); // 문자열 "홍길동"을 저장
        String str = container1.get(); // 저장된 문자열을 가져옴

        // Integer 타입을 저장하는 Container 객체 생성
        Container<Integer> container2 = new Container<Integer>();
        container2.set(6); // 정수 6을 저장
        int value = container2.get(); // 저장된 정수를 가져옴
    }
}
