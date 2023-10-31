package Array;

public class BookArray {
    public static void main(String[] args) {
        // 도서 정보를 저장할 Book 객체 배열 생성
        Book[] library = new Book[5];

        // Book 객체를 배열의 각 요소에 할당
        library[0] = new Book("파우스트", "괴테");
        library[1] = new Book("황무지", "엘리엇");
        library[2] = new Book("변신", "카프카");
        library[3] = new Book("픽션들", "보르헤스");
        library[4] = new Book("안나 카레니나", "톨스토이");

        // 도서 정보 출력
        for (int i = 0; i < library.length; i++) {
            library[i].showBookInfo(); // 각 도서 정보 출력
        }

        // Book 클래스의 toString() 메서드를 통해 도서 정보 출력
        for (int i = 0; i < library.length; i++) {
            System.out.println(library[i]); // Book 클래스의 toString() 메서드를 통해 도서 정보 출력
        }
    }
}
