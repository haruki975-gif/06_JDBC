package com.kh.mvc.run;

import com.kh.mvc.view.UserView;

public class Run {

	public static void main(String[] args) {
		
		// 프로그램 실행 시 진입점(JVM이 Main 메서드 호출)
		// EntryPoint
		
		/* 
		 * Model      : 데이터 관련된 모든 작업
		 * View       : 화면 입/출력(얘는 힘 안 줄 것)
		 * Controller : View에서의 요청을 받아서 처리해주는 역할
		 */
		
		new UserView().mainMenu();
		
	}

}
