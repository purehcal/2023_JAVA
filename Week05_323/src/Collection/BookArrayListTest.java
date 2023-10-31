package Collection;

import Collection.Book;

public class BookArrayListTest {

    public static void main(String[] args) {
        // BookArrayList 객체 생성
        BookArrayList bookArrayList = new BookArrayList();

        // 도서 객체 생성
        Book book1 = new Book(0001, "파우스트");
        Book book2 = new Book(0002, "황무지");
        Book book3 = new Book(0003, "변신");
        Book book4 = new Book(0004, "픽션들");
        Book book5 = new Book(0005, "톨스토이");

        // 도서를 도서 목록에 추가
        bookArrayList.addBook(book1);
        bookArrayList.addBook(book2);
        bookArrayList.addBook(book3);
        bookArrayList.addBook(book4);
        bookArrayList.addBook(book5);

        // 모든 도서를 출력
        bookArrayList.showAllBook();

        // 도서를 도서 목록에서 제거 (예: book1)
        bookArrayList.removeBook(book1.getBookId());

        // 변경된 도서 목록을 출력
        bookArrayList.showAllBook();
    }
}
