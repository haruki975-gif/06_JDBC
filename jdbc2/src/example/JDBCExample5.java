package example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class JDBCExample5 {
	public static void main(String[] args) throws ClassNotFoundException {
		
		// 아이디, 비밀번호, 새 비밀번호를 입력 받아
		// 아이디, 비밀번호가 일치하는 회원의 비밀번호 변경

		/* *** try-with-resources ***
		 * - try 선언 시 try() 괄호 내에 
		 * 	 try 구문에서 사용하고 반환할 자원을 선언하면 
		 *   종료 시 자동으로 해당 자원을 반환하는(close()) 코드를 수행
		 *   -> 메모리 누수 방지 효과
		 *   
		 *   (조건 : AutoCloseable을 구현한 객체만 자동 반환 가능)
		 *   - finally를 이용한 객체 자원 반환 구문 생략 가능!
		 */
		
		// 커넥션 생성
		String url = "jdbc:oracle:thin:@112.221.156.34:12345:XE";
		String userName = "KH17_LEB"; // 사용자 계정명
		String password = "KH1234"; // 계정 비밀번호
		
		// 드라이버 로드
		Class.forName("oracle.jdbc.OracleDriver");
		
		// SQL 작성
		String sql = """
					UPDATE TB_USER SET
						USER_PW = ?
					WHERE
						USER_ID = ?
					AND
						USER_PW = ?
					""";
		
		try(Connection conn = DriverManager.getConnection(url, userName, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			
			// 자동 커밋 끄기
			conn.setAutoCommit(false);
			
			
			Scanner sc = new Scanner(System.in);
			System.out.print("아이디 입력 : ");
			String id = sc.next();
			
			System.out.print("비밀번호 입력 : ");
			String pw = sc.next();
			
			System.out.println("새 비밀번호 입력 : ");
			String newPw = sc.next();
			
			pstmt.setString(1, newPw);
			pstmt.setString(2, id);
			pstmt.setString(3, pw);
			
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("수정 성공!");
				conn.commit();
			}else {
				System.out.println("입력하신 정보와 일치하는 사용자가 없습니다");
				conn.rollback();
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
