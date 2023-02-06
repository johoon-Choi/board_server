package board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDAOimple implements BoardDAO  {
	// Model part : 기능 위주의 객체
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	// 커넥션 정보
	private final String url = "jdbc:mysql://localhost:3306/sds?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
	private final String user_id = "root";
	private final String user_pw = "1234";
	
	private final String SQL_INSERT = "INSERT INTO board(title, content, author) values(?, ?, ?)";
	private final String SQL_UPDATE = "UPDATE board SET title=?, content=?, author=? WHERE num=?";
	private final String SQL_DELETE = "DELETE FROM board WHERE num=?";
	private final String SQL_SELECT_ONE = "SELECT * FROM board WHERE num=?";
	private final String SQL_SELECT_ALL = "SELECT * FROM board";
	private final String SQL_SEARCH_TITLE = "SELECT * FROM board WHERE title LIKE ?";
	private final String SQL_SEARCH_CONTENT = "SELECT * FROM board WHERE content LIKE ?";
	private final String SQL_SEARCH_AUTHOR = "SELECT * FROM board WHERE author LIKE ?";
	
	public BoardDAOimple() {
		System.out.println("MemberDAOimpl()...");
		// 1. Driver 연동
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("driver successed...");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public int insert(BoardVO vo) {
		System.out.println(" @@@ insert function ...");
		int flag = 0;
		
		try {
			conn = DriverManager.getConnection(url, user_id, user_pw);
			System.out.println(" conn successed...");
			
			pstmt = conn.prepareStatement(SQL_INSERT);
			
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getAuthor());
			
			// 성공시 1, 실패시 0 return
			flag = pstmt.executeUpdate();		// insert, update, delete 용도(DML용)
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // pstmt, conn 닫아주기
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
      
        return flag;
	} // insert function

	@Override
	public int update(BoardVO vo) {
		System.out.println(" @@@ update function ...");
		
		int flag = 0;
        
        try {
			conn = DriverManager.getConnection(url, user_id, user_pw);
			System.out.println(" conn successed...");

			pstmt = conn.prepareStatement(SQL_UPDATE);
			
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getAuthor());
			pstmt.setInt(4, vo.getNum());
			
			flag = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
      
        return flag;
	} // update function

	@Override
	public int delete(BoardVO vo) {
		System.out.println(" @@@ delete function ...");
		int flag = 0;
        
        try {
			conn = DriverManager.getConnection(url, user_id, user_pw);
			System.out.println(" conn successed...");

			pstmt = conn.prepareStatement(SQL_DELETE);
			pstmt.setInt(1, vo.getNum());
			
			flag = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
      
        return flag;
	}

	@Override
	public BoardVO selectOne(BoardVO vo) {
		System.out.println(" @@@ selectOne function ...");
		
		BoardVO ret = null;

        try {
			conn = DriverManager.getConnection(url, user_id, user_pw);
			System.out.println("conn successed...");

			pstmt = conn.prepareStatement(SQL_SELECT_ONE);
			pstmt.setInt(1, vo.getNum());			
			rs = pstmt.executeQuery();		// DQL 용
			
			while(rs.next()) {
				ret = new BoardVO();
			    ret.setNum(rs.getInt("num"));
			    ret.setTitle(rs.getString("title"));
			    ret.setContent(rs.getString("content"));
			    ret.setAuthor(rs.getString("author"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			try {
				pstmt.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return ret;
	}

	@Override
	public List<BoardVO> selectAll() {
		System.out.println(" @@@ selectAll function ...");
		
		List<BoardVO> vos = new ArrayList<>();

        try {
			conn = DriverManager.getConnection(url, user_id, user_pw);
			System.out.println("conn successed...");

			pstmt = conn.prepareStatement(SQL_SELECT_ALL);			
			rs = pstmt.executeQuery();		// DQL 용
			
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setNum(rs.getInt("num"));
			    vo.setTitle(rs.getString("title"));
			    vo.setContent(rs.getString("content"));
			    vo.setAuthor(rs.getString("author"));
			    
			    vos.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			try {
				pstmt.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return vos;
	}

	@Override
	public List<BoardVO> searchList(String searchKey, String searchWord) {
		System.out.println(" @@@ searchList function ...");
		
		List<BoardVO> vos = new ArrayList<>();

		try {
			conn = DriverManager.getConnection(url, user_id, user_pw);
			String SQL="";
			if(searchKey.equals("title")) {
				SQL=SQL_SEARCH_TITLE;
			}
			else if(searchKey.equals("content")) {
				SQL=SQL_SEARCH_CONTENT;
			}
			else if(searchKey.equals("author")) {
				SQL=SQL_SEARCH_AUTHOR;
			}
			
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, "%" + searchWord + "%");

			rs = pstmt.executeQuery();// DML용
			while (rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setNum(rs.getInt("num"));
			    vo.setTitle(rs.getString("title"));
			    vo.setContent(rs.getString("content"));
			    vo.setAuthor(rs.getString("author"));
			    
				vos.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {// 예외처리가 발생여부를 떠나 무조건 실행하도록 하는 구문
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		return vos;
	}
}
