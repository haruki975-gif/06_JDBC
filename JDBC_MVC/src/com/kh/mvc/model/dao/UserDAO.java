package com.kh.mvc.model.dao;

/**
 * DAO(Data Access Object)
 * 
 * 데이터베이스 관련된 작업(CRUD)을 전문적으로 담당하는 객체
 * DAO안에 모든 메소드들은 데이터베이스와 관련된 기능으로 만들 것
 * 
 * Controller를 통해 호출된 기능을 수행
 * DB에 직접 접근한 후 SQL문을 수행하고 결과 받기(JDBC)
 */
public class UserDAO {
	
	/* 
	 * JDBC 용 객체
	 * 
	 * -Connection : DB와의 연결정보를 담고있는 객체(IP주소, Port, 사용자명, 비밀번호)
	 * -Statement : Connection이 가지고 있는 연결정보 DB에 
	 * 							SQL문을 전달하고 실행하고 결과도 받아오는 객체
	 * -ResultSet : 실행한 SQL문이 SELECT문일 경우 조회된 결과가 처음 담기는 객체
	 * 
	 * -PreparedStatement : SQL문을 미리 준비하는 개념
	 * 											?(위치홀더)로 확보해놓은 공간을 사용자가 입력한 값들과 
	 * 											바인딩해서 SQL문을 수행
	 * 
	 * ** 처리 절차
	 * 1) JDBC Driver등록 : 해당 DBMC에서 제공하는 클래스를 동적으로 등록
	 * 2) Connection 객체 생성 : 접속하고자 하는 DB의 정보를 입력해서 생성
	 * 													 (URL, 사용자이름, 비밀번호)
	 * 3_1) PreparedStatement 객체 생성 :
	 * 			Connection 객체를 이용해서 생성(미완성된 SQL문을 미리 전달)
	 * 3_2) 미완성된 SQL문을 완성형태로 만들어주어야 함
	 * => 미완성된 경우에만 해당 / 완성된 경우에는 생략
	 * 4) SQL문을 실행 : executeXXX() => SQL을 인자로 전달하지 않음!!
	 * 									 > SELECT(DQL) : executeQuery()
	 * 									 > DML 				 : executeUpdate()
	 * 5) 결과받기 : 
	 * 								> SELECT : ResultSet타입 객체(조회 데이터 담김)
	 * 								> DML 	 : int(처리된 행의 개수 반환)
	 */
	
	public void findAll() {
		
	}
	
	
	
	
	
	
	
}
