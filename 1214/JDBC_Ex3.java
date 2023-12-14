import java.io.*;
import java.sql.*;

public class JDBC_Ex3 {
	public static void main(String[] args) {
		Connection conn;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 로드
			conn = DriverManager.getConnection(// JDBC 연결, password는 root 계정 패스워드 입력
					"jdbc:mysql://localhost:3306/sampledb", "root", "1234");

			System.out.println("DB 연결 완료");
			stmt = conn.createStatement(); // SQL문 처리용 Statement 객체 생성
			stmt.executeUpdate(
					"insert into student (name, id, dept) values('아무개', '0893012', '컴퓨터공학');"); // 레코드 추가
			printTable(stmt);
			stmt.executeUpdate(
					"update student set id='0189011' where name='아무개'"); // 데이터 수정

			printTable(stmt);
			stmt.executeUpdate(
					"delete from student where name='아무개'");
// 레코드 삭제

			printTable(stmt);
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 로드 에러");
		} catch (SQLException e) {
			System.out.println("SQL 실행 에러");
		}
	}

// 레코드의 각 열의 값 화면에 출력
	private static void printTable(Statement stmt) throws SQLException {
		ResultSet srs = stmt.executeQuery("select * from student");
		while (srs.next()) {
			System.out.print(new String(srs.getString("name")));
			System.out.print("\t|\t" + srs.getString("id"));
			System.out.println("\t|\t" + new String(srs.getString("dept")));
		}
	}
}