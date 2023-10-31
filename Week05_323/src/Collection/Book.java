package Collection;

public class Book {
    private int BookId;    // 도서의 고유 식별자 (ID)
    private String BookName; // 도서의 이름

    // Book 클래스의 생성자
    public Book(int BookId, String BookName) {
        this.BookId = BookId;       // 생성자에서 BookId 초기화
        this.BookName = BookName;   // 생성자에서 BookName 초기화
    }

    // BookId의 값을 반환하는 메서드
    public int getBookId() {
        return BookId; // BookId 값을 반환
    }

    // BookId의 값을 설정하는 메서드
    public void setBookId(int BookId) {
        this.BookId = BookId; // BookId 값을 설정
    }

    // BookName의 값을 반환하는 메서드
    public String getBookName() {
        return BookName; // BookName 값을 반환
    }

    // BookName의 값을 설정하는 메서드
    public void setBookName(String setBookName) {
        this.BookName = BookName; // BookName 값을 설정
    }

    // 도서 정보를 문자열로 반환하는 메서드
    public String toString() {
        return BookName + " 도서의 아이디는 " + BookId + "입니다"; // 도서 정보를 문자열로 반환
    }
}