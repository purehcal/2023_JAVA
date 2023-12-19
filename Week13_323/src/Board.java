import java.sql.Date;
import com.mysql.cj.jdbc.Blob;

public class Board {
    private int bno;            // 게시물 번호
    private String btitle;      // 게시물 제목
    private String bcontent;    // 게시물 내용
    private String bwriter;     // 게시물 작성자
    private Date bdate;          // 게시물 작성일자
    private String bfilename;   // 첨부 파일 이름
    private Blob bfiledata;     // 첨부 파일 데이터

    // 각 필드에 대한 setter 메서드
    public void setBno(int bno) {this.bno = bno;}

    public void setBtitle(String btitle) {this.btitle = btitle;}

    public void setBcontent(String bcontent) {this.bcontent = bcontent;}

    public void setBwriter(String bwriter) {this.bwriter = bwriter;}

    public void setBdate(Date bdate) {this.bdate = bdate;}

    public void setBfilename(String bfilename) {this.bfilename = bfilename;}

    public void setBfiledata(java.sql.Blob blob) {this.bfiledata = (Blob) blob;}

    // 각 필드에 대한 getter 메서드
    public int getBno() {return bno;}

    public String getBtitle() {return btitle;}

    public String getBcontent() {return bcontent;}

    public String getBwriter() {return bwriter;}

    public Date getBdate() {return bdate;}

    public String getBfilename() {return bfilename;}

    public Blob getBfiledata() {return bfiledata;}
}
