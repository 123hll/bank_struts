package cn.com.hll.util;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * �ַ��������filter
 * @author Administrator
 *
 */
public class CharsetEncodingFilter implements Filter {
	
	private String encoding;
	
	public void destroy() {
		System.out.println("CharsetEncodingFilter.destroy()");
	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)servletRequest;
		HttpServletResponse response = (HttpServletResponse)servletResponse;
		//System.out.println("CharsetEncodingFilter.doFilter()");
		//�����ַ���
		request.setCharacterEncoding(encoding);
		//System.out.println("--------doFilter begin----------");
		//�������ִ�������Ĳ�����������ʾ��ִ���������
		chain.doFilter(request, response);
		//System.out.println("--------doFilter end----------");
	}

	public void init(FilterConfig config) throws ServletException {
		encoding = config.getInitParameter("encoding");
		System.out.println("encoding=" + encoding);
	}

}
