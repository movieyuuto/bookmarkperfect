package bookmark;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/urlT")
public class urlT extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public urlT() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		urlTDAO urltdao = new urlTDAO();
		urlTDAO2 urltdao2 = new urlTDAO2();
		session.setAttribute("all", urltdao.findAll());
		session.setAttribute("all2", urltdao2.findAll2());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/bookmark/bm.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String action = request.getParameter("action");

		if (action.equals("create")) {
			String number = request.getParameter("number");
			String urls = request.getParameter("urls");
			System.out.printf("%s %s \n", number, urls);
			urlTDAO urltdao = new urlTDAO();
			boolean success = urltdao.create(Integer.parseInt(number), urls);
			if (success) {
				session.setAttribute("message", "create成功");
			} else {
				session.setAttribute("message", "create失敗");
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/bookmark/bmresult.jsp");
			dispatcher.forward(request, response);
		}
		else if (action.contentEquals("delete")) {
			String number = request.getParameter("number");
			urlTDAO urltdao = new urlTDAO();
			boolean success = urltdao.delete(Integer.parseInt(number));
			System.out.println(1);
			if (success) {
				session.setAttribute("message", "delete成功");
			} else {
				session.setAttribute("message", "delete失敗");
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/bookmark/bmresult.jsp");
			dispatcher.forward(request, response);
		}


		else if (action.equals("create2")) {
			String number = request.getParameter("number");
			String urls = request.getParameter("urls");
			System.out.printf("%s %s \n", number, urls);
			urlTDAO2 urltdao2 = new urlTDAO2();
			boolean success = urltdao2.create2(Integer.parseInt(number), urls);
			if (success) {
				session.setAttribute("message", "create成功");
			} else {
				session.setAttribute("message", "create失敗");
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/bookmark/bmresult.jsp");
			dispatcher.forward(request, response);
		}

		else if (action.contentEquals("delete2")) {
			String number = request.getParameter("number");
			urlTDAO2 urltdao2 = new urlTDAO2();
			boolean success = urltdao2.delete2(Integer.parseInt(number));
			System.out.println(1);
			if (success) {
				session.setAttribute("message", "delete成功");
			} else {
				session.setAttribute("message", "delete失敗");
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/bookmark/bmresult.jsp");
			dispatcher.forward(request, response);
		}
	}
}
