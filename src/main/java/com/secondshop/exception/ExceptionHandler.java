package com.secondshop.exception;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class ExceptionHandler implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		ex.printStackTrace();
		System.out.println();
		try {
			request.getRequestDispatcher("/WEB-INF/views/home/error.jsp")
					.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
