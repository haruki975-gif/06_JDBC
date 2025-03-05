package com.kh.mvc.controller;

import java.util.List;

import com.kh.mvc.model.dao.UserDAO;
import com.kh.mvc.model.dto.UserDTO;

/**
 * VIEW에서 온 요청을 처리해주는 클래스입니다.
 * 메소드로 전달된 데이터값을 가공처리한 후 DAO로 전달합니다.
 * DAO로부터 반환받은 결과를 사용자가 보게될 VIEW(응답화면)에 반환합니다.
 */
public class UserController {

	private UserDAO userDao = new UserDAO();
	
	// view로 리스트를 담아서 보내줌(사라지기 전에 다시 list의 주소를 참조함)
	public List<UserDTO> findAll() {
		 return userDao.findAll();
	}
	
}
