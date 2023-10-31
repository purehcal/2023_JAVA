package Array;

public class Book {
    private String bookName; // 도서 제목을 저장하는 멤버 변수
    private String author; // 저자를 저장하는 멤버 변수
    
    // 기본 생성자 (매개변수 없는 생성자)
    public Book() {}
    
    // 도서 제목과 저자를 초기화하는 생성자
    public Book(String bookName, String author) {
        this.bookName = bookName;
        this.author = author;
    }
    
    // 도서 제목 Getter 메서드
    public String getBookName() {
        return bookName;
    }
    
    // 도서 제목 Setter 메서드
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    
    // 저자 Getter 메서드
    public String getAuthor() {
        return author;
    }
    
    // 저자 Setter 메서드
    public void setAuthor(String author) {
        this.author = author;
    }
    
    // 도서 정보를 출력하는 메서드
    public void showBookInfo() {
        System.out.println(bookName + ", " + author);
    }
}
