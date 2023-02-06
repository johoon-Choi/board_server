package board;

import java.util.List;

public interface BoardDAO  {
	// 실제론 DB와 연동 해야하지만, 아직 모르므로 변수를 선언해서 해 보았습니다.
	public int insert(BoardVO vo);

	public int update(BoardVO vo) ;

	public int delete(BoardVO vo);
	
	public BoardVO selectOne(BoardVO vo) ;

	public List<BoardVO> selectAll() ;
	
	public List<BoardVO> searchList(String searchKey, String searchWord) ;
}
