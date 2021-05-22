package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface SistAction {
	
	/**
	 * 해당 Action이 수생한 후에 
	 * 어떤 jsp로 가야할 지 jsp파일이름(View)을 반환하는 일
	 * @return jsp파일 이름(View)
	 */
	//해당Action이 수행한 후에 
	//어떤jsp로 가야할지 jsp파일이름(View)을 반환하기로 합니다.
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
}
