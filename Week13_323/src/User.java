// 사용자 정보를 담는 User 클래스입니다.
public class User {
    private String userId;       // 사용자 아이디
    private String userName;     // 사용자 이름
    private String userPassword; // 사용자 비밀번호
    private int userAge;         // 사용자 나이
    private String userEmail;    // 사용자 이메일

    // 아이디(getter)를 반환하는 메서드
    public String getUserId() {
        return userId;
    }

    // 아이디(setter)를 설정하는 메서드
    public void setUserId(String userId) {
        this.userId = userId;
    }

    // 이름(getter)을 반환하는 메서드
    public String getUserName() {
        return userName;
    }

    // 이름(setter)을 설정하는 메서드
    public void setUserName(String userName) {
        this.userName = userName;
    }

    // 비밀번호(getter)를 반환하는 메서드
    public String getUserPassword() {
        return userPassword;
    }

    // 비밀번호(setter)를 설정하는 메서드
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    // 나이(getter)를 반환하는 메서드
    public int getUserAge() {
        return userAge;
    }

    // 나이(setter)를 설정하는 메서드
    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    // 이메일(getter)을 반환하는 메서드
    public String getUserEmail() {
        return userEmail;
    }

    // 이메일(setter)을 설정하는 메서드
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    // 객체의 문자열 표현을 반환하는 toString() 메서드
    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userAge=" + userAge +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }
}
