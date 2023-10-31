package Generic;

class Container2<K, V> {
    private K key; // 키 타입
    private V value; // 값 타입

    public void set(K key, V value) {
        this.key = key; // 키와 값 설정
        this.value = value;
    }

    public K getKey() {
        return key; // 키 반환
    }

    public V getValue() {
        return value; // 값 반환
    }
}

public class Week05_02 {

    public static void main(String[] args) {
        // 두 가지 다른 타입의 컨테이너 객체 생성
        Container2<String, String> container1 = new Container2<String, String>();
        container1.set("홍길동", "도적"); // 문자열 키와 값 설정
        String name1 = container1.getKey(); // 키를 가져옴
        String job = container1.getValue(); // 값을 가져옴

        Container2<String, Integer> container2 = new Container2<String, Integer>();
        container2.set("홍길동", 35); // 문자열 키와 정수 값 설정
        String name2 = container2.getKey(); // 키를 가져옴
        int age = container2.getValue(); // 값(정수)을 가져옴
    }
}
