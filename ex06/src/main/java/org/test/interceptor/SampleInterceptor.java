package org.test.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SampleInterceptor extends HandlerInterceptorAdapter {

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("post handle..........."); // preHandle -> 실행하려는 페이지의 controller -> postHanlde 순으로 실행된다.
		
		Object result = modelAndView.getModel().get("result"); //modelAndView가 사용된 컨트롤러중에 "result"라는 값이 있으면 가져온다.
		
		if(result != null){
			request.getSession().setAttribute("result", result);
			response.sendRedirect("/doA");
		}

		/* super.postHandle(request, response, handler, modelAndView); */
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("pre handle..........."); //특정 controller를 캐치하는것을 설정하지 않으면 가장 먼저 실행된다.
		
		HandlerMethod method = (HandlerMethod) handler;
		Method methodObj = method.getMethod();
		
		System.out.println("Bean: " + method.getBean());
		System.out.println("Method: " + methodObj);

		return true;
		/* return super.preHandle(request, response, handler); */
	}

}
