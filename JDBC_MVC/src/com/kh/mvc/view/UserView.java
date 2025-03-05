package com.kh.mvc.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.kh.mvc.controller.UserController;
import com.kh.mvc.model.dto.UserDTO;

/**
 * MemberView 클래스는 JDBC실습을 위해 생성하였으며,
 * 사용자에게 입력 및 출력을 수행하는 메소드를 제공합니다.
 * 
 * @author : 종로 C강의장
 * @version : 0.1
 * @date : 2025-03-04
 */
public class UserView {
	
	private Scanner sc = new Scanner(System.in); 
	private UserController userController = new UserController();
	
	/**
	 * 프로그램 시작 시 사용자에게 보여줄 메인화면을 출력해주는 메소드
	 */
	public void mainMenu() {
		
		while(true) {
			System.out.println("--- USER테이블 관리 프로그램 ---");
			System.out.println("1. 회원 전체 조회");
			System.out.println("2. 회원 추가");
			System.out.println("9. 프로그램 종료");
			System.out.print("이용할 메뉴를 선택해주세요 > ");
			
			int menuNo = 0;
			
			try {
				menuNo = sc.nextInt();
				
			} catch(InputMismatchException e){
				sc.nextLine();
				continue;
			}
			
			sc.nextLine();
			
			switch(menuNo) {
				case 1: 
					findAll();
					break;
				case 9: 
					System.out.println("프로그램 종료~"); 
					return;
				default: System.out.println("잘못된 메뉴 선택입니다.");
			}
			
			
		}
		
	}
	
	// 회원 전체 정보를 조회해주는 기능
	// mainMenu를 통해서만 조회하니까 private로 숨겨주기
	private void findAll() {
		System.out.println("\n--- 회원 전체 목록 ---");
		
		// 연산코드는 무조건 userController로 보냄 => 회원 전체 목록 좀 가져와줘
		List<UserDTO> list = userController.findAll();
		
		System.out.println("\n조회된 총 회원의 수는 " + list.size() + "명 입니다.");
		
		if(list.isEmpty()) { 
			
		} else {
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
}
