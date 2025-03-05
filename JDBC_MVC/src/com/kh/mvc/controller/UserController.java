package com.kh.mvc.controller;

import java.util.List;

import com.kh.mvc.model.dao.UserDAO;
import com.kh.mvc.model.dto.UserDTO;
import com.kh.mvc.model.service.MemberService;

/**
 * VIEW에서 온 요청을 처리해주는 클래스입니다.
 * 메소드로 전달된 데이터값을 가공처리한 후 DAO로 전달합니다.
 * DAO로부터 반환받은 결과를 사용자가 보게될 VIEW(응답화면)에 반환합니다.
 */
public class UserController {

	private UserDAO userDao = new UserDAO();
	private MemberService userService = new MemberService();
	// 컨트롤러와 dao 사이의 중간다리를 하나 더 만들겠다 == service
	
	// view로 리스트를 담아서 보내줌(사라지기 전에 다시 list의 주소를 참조함)
	public List<UserDTO> findAll() {
		 return userService.findAll();
		 // dao -> service
	}
	
	// requestParameter, 요청 시 전달값
	// 어떤 값이 넘어올지 알 수 없지만 타입은 알 수 있음 (매개"변수", 파라미터)
	public int insertUser(String userId, String userPw, String userName) {
		UserDTO user = new UserDTO();
		user.setUserId(userId);
		user.setUserPw(userPw);
		user.setUserName(userName);
		
		//userDao.insertUser(userId, userPw, userName);
		return userDao.insertUser(user);
		// 성공 실패 여부 view까지 전달
	}
	
	
	
	
	
	
	
	
	
	
}
