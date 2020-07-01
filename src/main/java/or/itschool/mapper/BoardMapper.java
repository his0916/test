package or.itschool.mapper;

import java.util.List;

import or.itschool.model.BoardVO;

public interface BoardMapper {
	//1.게시글 등록 기능 메서드 - 게시글 하나 가져와서 등록
	void insert(BoardVO article) throws Exception;
	
	//2.하나의 게시글 조회 기능 메서드 - 하나를 조회하려면
	BoardVO getArticle(int boardNo) throws Exception;
	
	//3.게시물 수정 기능 메서드 - 게시물 전체 정보
	void update(BoardVO article) throws Exception;
	
	//4.게시물 삭제 기능 메서드 - 게시물 번호릐 글을 삭제한다
	void delete(int boardNo) throws Exception;
	
	//5.모든 게시물 조회 기능 메서드
	List<BoardVO> getAllArticles() throws Exception;
}
