package Collection2.copy;
import java.util.Scanner;

public class BookArrayListTest {

    public static void main(String[] args) {
        // BookArrayList 객체 생성
        BookArrayList bookArrayList = new BookArrayList();

        // 몇 권의 책을 초기 목록에 추가합니다.
        Book book1 = new Book(0001, "파우스트");
        Book book2 = new Book(0002, "황무지");
        Book book3 = new Book(0003, "변신");
        Book book4 = new Book(0004, "픽션들");
        Book book5 = new Book(0005, "톨스토이");

        // 각 책을 목록에 추가
        bookArrayList.addBook(book1);
        bookArrayList.addBook(book2);
        bookArrayList.addBook(book3);
        bookArrayList.addBook(book4);
        bookArrayList.addBook(book5);

        // 현재의 도서 목록을 출력
        bookArrayList.showAllBook();

        // 키보드로 입력 받은 위치에 새 책을 추가
        Scanner scanner = new Scanner(System.in);

        System.out.print("도서를 추가할 위치를 입력: ");
        int insertIndex = scanner.nextInt();

        System.out.print("책 ID 입력: ");
        int bookId = scanner.nextInt();
        scanner.nextLine(); // 개행 문자 처리
        System.out.print("책 제목 입력: ");
        String title = scanner.nextLine();

        // 새로운 도서 객체 생성
        Book newBook = new Book(bookId, title);
        
        // 입력 받은 위치에 새로운 책 추가
        bookArrayList.insertBook(insertIndex, newBook);

        // 수정된 도서 목록 출력
        bookArrayList.showAllBook();

        scanner.close();
    }
}
