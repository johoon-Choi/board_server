package test.com;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

import board.BoardDAO;
import board.BoardDAOimple;
import board.BoardVO;
/**
 * Servlet implementation class BoardController
 */
@WebServlet({"/index.do"
	, "/insert.do", "/insertOK.do"
	, "/delete.do", "/deleteOK.do"
	, "/update.do", "/updateOK.do"
	, "/selectOne.do", "/selectAll.do"
	, "/searchList.do"})

public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	BoardDAO dao = new BoardDAOimple();
		
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			String sPath = request.getServletPath();
			System.out.println("johoons bling bling Path:" + sPath);


			
			if (sPath.compareTo("/index.do") == 0) {
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
				
				
				
				
			} else if (sPath.compareTo("/insert.do") == 0) {
				RequestDispatcher rd = request.getRequestDispatcher("board/insert.jsp");
				
				System.out.println(" rd is " + rd);
				
				rd.forward(request, response);
				
				
				
				
			} else if (sPath.compareTo("/delete.do") == 0) {
				RequestDispatcher rd = request.getRequestDispatcher("board/delete.jsp");
				rd.forward(request, response);
				
				
				
				
			} else if (sPath.compareTo("/update.do") == 0) {
				RequestDispatcher rd = request.getRequestDispatcher("board/update.jsp");
				rd.forward(request, response);
				
				
				
				
			} else if (sPath.compareTo("/selectOne.do") == 0) {
				BoardVO vo = new BoardVO();
				String snum = request.getParameter("num") == null ? "999999" : request.getParameter("num");
				vo.setNum(Integer.parseInt(snum));
				
				BoardVO vo2 = dao.selectOne(vo);
				
				request.setAttribute("vo2", vo2);
				
				RequestDispatcher rd = request.getRequestDispatcher("board/selectOne.jsp");
				rd.forward(request, response);
				
				
				
				
				
			} else if (sPath.compareTo("/selectAll.do") == 0) {
				List<BoardVO> vos = dao.selectAll();
				
				for (BoardVO e :vos) {
					System.out.println(e);
				}
				
				request.setAttribute("vos", vos);
				
				RequestDispatcher rd = request.getRequestDispatcher("board/selectAll.jsp");
				rd.forward(request, response);
				
				
				
				
				
			} else if (sPath.compareTo("/insertOK.do") == 0) {
				// 모델 처리용 로직
				String title = request.getParameter( "title") == null ? "NO TITLE":request.getParameter("title");
				String content = request.getParameter("content") == null ? "NO CONTENT":request.getParameter("content");
				String author = request.getParameter("author") 	== null ? "NO AUTHOR":request.getParameter("author");

				System.out.println("[insertOK.do]");
				System.out.println("title : " + title);
				System.out.println("content : " + content);
				System.out.println("author : " + author);
				
				BoardVO vo = new BoardVO(0, title, content, author);
				
				int insert_result = dao.insert(vo);
				
				// 실행 후 뷰 설정된 서블릿으로 리다이렉트 처리를 해주면 된다.
				if(insert_result == 1){
					response.sendRedirect("selectAll.do");
				}else{
					response.sendRedirect("insert.do");
				}
				
				
				
				
				
				
			} else if (sPath.compareTo("/updateOK.do") == 0) {
				// 모델 처리용 로직
				String num = request.getParameter("num") == null ? "NO NUM" : request.getParameter("num");
				String title = request.getParameter("title") == null ? "NO TITLE":request.getParameter("title");
				String content = request.getParameter("content") == null ? "NO CONTENT":request.getParameter("content");
				String author = request.getParameter("author") 	== null ? "NO AUTHOR":request.getParameter("author");

				System.out.println("[updateOK.do]");
				System.out.println("title : " + title);
				System.out.println("content : " + content);
				System.out.println("author : " + author);
				
				BoardVO vo = new BoardVO(Integer.parseInt(num), title, content, author);
				
				int update_result = dao.update(vo);
				
				// 실행 후 뷰 설정된 서블릿으로 리다이렉트 처리를 해주면 된다.
				if(update_result == 1){
					response.sendRedirect("selectAll.do");
				}else{
					response.sendRedirect("update.do?num=" + num);
				}
				
				
				
				
			} else if (sPath.compareTo("/deleteOK.do") == 0) {
				// 모델 처리용 로직
				String num = request.getParameter("num") == null ? "999999":request.getParameter("num");
				System.out.println("num : " + num);
				
				BoardVO vo = new BoardVO();
				vo.setNum(Integer.parseInt(num));
				
				System.out.println("vo is " + vo);
				
				int delete_result = dao.delete(vo);
				
				// 실행 후 뷰 설정된 서블릿으로 리다이렉트 처리를 해주면 된다.
				if(delete_result == 1){
					response.sendRedirect("selectAll.do");
				}else{
					response.sendRedirect("delete.do?num=" + num);
				}
				
				
				
				
				
				
			} else if (sPath.compareTo("/searchList.do") == 0) {
				String searchKey = request.getParameter("searchKey");
				String searchWord = request.getParameter("searchWord");
				
				System.out.println("searchkey :" + searchKey);
				System.out.println("searchWord :" + searchWord);
				
				List<BoardVO> searchList = dao.searchList(searchKey, searchWord);
				for (BoardVO e : searchList) {
					System.out.println(e);
				}
				
				request.setAttribute("vos", searchList);
				
				RequestDispatcher rd = request.getRequestDispatcher("board/selectAll.jsp");
				rd.forward(request, response);
				
				
				
				
				
				
			}
	} // ============== end doGet ================

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
