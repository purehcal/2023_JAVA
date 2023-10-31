package Collection;

import java.util.ArrayList;

public class BookArrayList {
    private ArrayList<Book> arrayList; // 도서 목록을 저장하는 ArrayList

    public BookArrayList() {
        arrayList = new ArrayList<Book>(); // 생성자에서 ArrayList 초기화
    }

    // 도서를 목록에 추가하는 메서드
    public void addBook(Book book) {
        arrayList.add(book); // 전달된 도서 객체를 목록에 추가
    }

    // 도서를 목록에서 제거하는 메서드
    public boolean removeBook(int bookId) {
        for (int i = 0; i < arrayList.size(); i++) {
            Book book = arrayList.get(i);
            int tempId = book.getBookId();

            // 도서 ID가 일치하는 경우 도서를 목록에서 제거하고 true 반환
            if (tempId == bookId) {
                arrayList.remove(i);
                return true;
            }
        }

        // 도서 ID가 일치하지 않는 경우 메시지 출력하고 false 반환
        System.out.println(bookId + "가 존재하지 않습니다.");
        return false;
    }

    // 현재 도서 목록을 출력하는 메서드
    public void showAllBook() {
        for (Book book : arrayList) {
            System.out.println(book); // 도서 정보 출력
        }
        System.out.println(); // 목록 출력 후 줄바꿈
    }
}
