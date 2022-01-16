package com.example.demo.configuration;

import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

public class UserAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest, HttpservletResponse response, AuthenticationException exception) throws IOException, servletException {
		
		
		String msg ="로그인에 실패하였습니다.";
		
		if(exception instanceof InternalAuthenticationServiceException) {
			msg = exception.getMessage();
		}
		
		
		
		setUseForward(true);
		setDefaultFailureurl("/member/login?error=true");
		request.setAttribute("errorMessage", "로그인에 실패하였습니다.");
		
		System.out.println("로그인에 실패하였습니다.");
		
		
		
		super.onAuthenticationFailure(request, response, exception);
	}
}