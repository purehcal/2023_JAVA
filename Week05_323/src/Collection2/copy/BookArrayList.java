package Collection2.copy;

import java.util.ArrayList;

public class BookArrayList {
    private ArrayList<Book> arrayList;

    // 생성자: Book 객체를 저장할 ArrayList를 초기화
    public BookArrayList() {
        arrayList = new ArrayList<Book>();
    }

    // 새로운 도서를 목록에 추가
    public void addBook(Book book) {
        arrayList.add(book);
    }

    // 도서 ID를 기반으로 도서를 목록에서 제거
    public boolean removeBook(int bookId) {
        for (int i = 0; i < arrayList.size(); i++) {
            Book book = arrayList.get(i);
            int tempId = book.getBookId();
            if (tempId == bookId) {
                arrayList.remove(i);
                return true;
            }
        }
        System.out.println(bookId + "가 존재하지 않습니다.");
        return false;
    }

    // 특정 위치에 새로운 도서를 추가
    public void insertBook(int insertIndex, Book newBook) {
        arrayList.add(insertIndex, newBook);
    }

    // 현재 도서 목록을 출력
    public void showAllBook() {
        for (Book book : arrayList) {
            System.out.println(book);
        }
        System.out.println();
    }
}
