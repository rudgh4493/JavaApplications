import java.sql.*;

public class JDBC_Ex {
	public static void main(String[] args) {
		Connection conn;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 로드
			conn = DriverManager.getConnection(// JDBC 연결, password는 root 계정 패스워드 입력
					"jdbc:mysql:// localhost:3306/sampledb", "root", "1234");

			System.out.println("DB 연결 완료");
			stmt = conn.createStatement(); // SQL문 처리용 Statement 객체 생성
			ResultSet srs = stmt.executeQuery("select * from student");
			// 테이블의 모든 데이터 검색

			printData(srs, "name", "id", "dept");
			srs = stmt.executeQuery(
					"select name, id, dept from student where name='이기자'"); // name이 "이기자"인 레코드만 검색

			printData(srs, "name", "id", "dept");
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 로드 에러 : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("DB 연결 에러: " + e.getMessage());
		}

	}

	private static void printData(ResultSet srs, String col1, String col2, String col3) throws SQLException {

		while (srs.next()) {
			if (col1 != "")
				System.out.print(new String(srs.getString("name")));
			if (col2 != "")
				System.out.print("\t|\t" + srs.getString("id"));
			if (col3 != "")
				System.out.println("\t|\t" + new String(srs.getString("dept")));
			else
				System.out.println();
		}
	}
}