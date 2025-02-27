package example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCExample5 {
	public static void main(String[] args) {
		
		// 부서명을 입력 받아
		// 해당 부서에 근무하는 사원의
		// 사번, 이름, 부서명, 직급명을
		// 직급코드 오름차순 조회
		
		Scanner sc = new Scanner(System.in);
		
		Connection conn = null; // DB 연결 정보를 저장, 연결하는 객체
		Statement stmt = null; 	// SQL을 수행하고 결과를 반환받는 객체
		ResultSet rs = null; 		// SELECT 수행 결과 저장 객체
		
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			
			String type = "jdbc:oracle:thin:@";
			String host = "112.221.156.34";
			String port = ":12345";
			String dbName = ":XE";
			String userName = "KH17_LEB";
			String password = "KH1234";
			
			conn = DriverManager.getConnection(
					type + host + port + dbName, // DB URL 
					userName, 
					password);
			
			System.out.println("=== 해당 부서에서 근무하는 직원 조회 ===");
			System.out.print("부서명 입력 : ");
			String title = sc.next();
			sc.nextLine();
			
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT EMP_ID, EMP_NAME, D.DEPT_TITLE, J.JOB_NAME ");
			sb.append("FROM EMPLOYEE E ");
			sb.append("LEFT JOIN DEPARTMENT D ON (E.DEPT_CODE=D.DEPT_ID) ");
			sb.append("JOIN JOB J ON (E.JOB_CODE=J.JOB_CODE) ");
//			sb.append("WHERE D.DEPT_TITLE = '");
//			sb.append(title);
//			sb.append("' ORDER BY E.JOB_CODE ASC");
			
			sb.append("WHERE D.DEPT_TITLE = '" + title + "' ");
			sb.append("ORDER BY E.JOB_CODE ASC");
			
			String sql = sb.toString();
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				String empId = rs.getString("EMP_ID");
				String empName = rs.getString("EMP_NAME");
				String deptTitle = rs.getString("DEPT_TITLE");
				String jobName = rs.getString("JOB_NAME");
				
				System.out.printf("%s / %s / %s / %s \n",
						empId, empName, deptTitle, jobName);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			try {
				
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
