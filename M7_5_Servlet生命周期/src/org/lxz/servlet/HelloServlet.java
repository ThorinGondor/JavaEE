package org.lxz.servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletSystem
 */
@WebServlet("/ServletSystem")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Messege --- ��ʼ����HelloServlet��init()���������ã�");
	    super.init(config);
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		super.destroy();
		System.out.println("Messege --- �ͷ���Դ��HelloServlet��destroy()���������ã�");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Messege --- ��������HelloServlet��doGet()���������ã�");
		try{
			String initParam = getServletContext().getInitParameter("initParam");
			System.out.println("Message --- initParam��ֵ:"+initParam);
		}
		catch(NullPointerException e){
			System.out.println("ERROR --- Java��ָ���쳣��");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Messege --- ��������HelloServlet��doPost()���������ã�");
	}

}
