package Collection2.copy;

public class Book {
    private int BookId;    // 도서의 고유한 ID
    private String BookName;    // 도서의 이름

    // Book 객체를 초기화하는 생성자
    public Book(int BookId, String BookName) {
        this.BookId = BookId;
        this.BookName = BookName;
    }

    // 도서의 ID 값을 반환하는 메서드
    public int getBookId() {
        return BookId;
    }

    // 도서의 ID 값을 설정하는 메서드
    public void setBookId(int BookId) {
        this.BookId = BookId;
    }

    // 도서의 이름을 반환하는 메서드
    public String getBookName() {
        return BookName;
    }

    // 도서의 이름을 설정하는 메서드
    public void setBookName(String BookName) {
        this.BookName = BookName;
    }

    // 도서 정보를 문자열로 반환하는 메서드 (toString 오버라이드)
    public String toString() {
        return BookName + " 도서의 아이디는 " + BookId + "입니다.";
    }
}
