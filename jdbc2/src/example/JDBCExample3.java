package example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class JDBCExample3 {
	public static void main(String[] args) {
		
		// 아이디, 비밀번호, 이름을 입력받아
		// 아이디, 비밀번호가 일치하는 사용자의 이름 수정(UPDATE)
		
		Connection conn = null;
		PreparedStatement pstmt = null; // ? 값을 대입할 준비가 되어있다
		
		// UPDATE는 수정된 행의 개수가 반환될 예정
		// -> ResultSet 불필요
		
		try {
			// 커넥션 생성
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@112.221.156.34:12345:XE";
			String userName = "KH17_LEB"; // 사용자 계정명
			String password = "KH1234"; // 계정 비밀번호
			conn = DriverManager.getConnection(url, userName, password);
			
			// 자동 커밋 끄기
			conn.setAutoCommit(false);
			
			// SQL 작성
			String sql = """
					UPDATE TB_USER SET 
						USER_NAME = ?
					WHERE 
						USER_ID = ? 
					AND 
						USER_PW = ?
					""";
			
			Scanner sc = new Scanner(System.in);
			System.out.print("아이디 입력 : ");
			String id = sc.next();
			
			System.out.print("비밀번호 입력 : ");
			String pw = sc.next();
			
			System.out.print("수정할 이름 입력 : ");
			String name = sc.next();
			
			/* sql을 전달하고 결과를 받아올 PreparedStatement 객체 생성 + ? 값 세팅 */
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, name);
			pstmt.setString(2, id);
			pstmt.setString(3, pw);
			
			/* SQL 수행 후 결과 반환 받기
			 * -SELECT : executeQuery() -> ResultSet 반환
			 * -DML : executeUpdate() -> 행의 개수(int)로 반환
			 */
			int result = pstmt.executeUpdate();
			
			/* (DML 수행 시)
			 * 6. SQL 수행 결과에 따른 처리 + 트랜잭션 제어 */
			if(result > 0) { // 1행 수정
				System.out.println("수정 성공!");
				conn.commit();
			} else {
				System.out.println("아이디 또는 비밀번호가 일치하지 않습니다");
				conn.rollback();
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			// 사용 완료된 JDBC 객제 자원 반환
			try {
				
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
	}
}
