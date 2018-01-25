package org.topics.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/TopicsServlet")
public class TopicsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TopicsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String opr = request.getParameter("opr");
		TopicsService TS = new TopicsServiceImple();
		
		if("del".equals(opr)){ //ɾ������
			String ID = request.getParameter("tid");
			int result = TS.deleteTopics(Integer.parseInt(ID));
			if(result==-1){
				System.out.println("���ϧ��ɾ��ʧ�ܣ�");
				out.println("<script type='text/javascript'>"+"alert('�Բ���û����Ҫɾ�������ű��!');"+"location.href='origin.jsp';</script>");
			}
			else{
				System.out.println("��ϲ�㣡ɾ���ɹ���");
				response.sendRedirect("origin.jsp");
			}
		}
		else if("update".equals(opr)){ //��������
			
		}
		else if("list".equals(opr)){ //��ȡ����
			List<Topic> list = new ArrayList<Topic>();
			list = TS.findAllTopics();
			request.setAttribute("LIST", list);
			request.getRequestDispatcher("topic_list.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
