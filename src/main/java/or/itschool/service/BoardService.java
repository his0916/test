package or.itschool.service;

import java.util.List;

import or.itschool.model.BoardVO;

public interface BoardService {
	//1.�Խñ� ��� ��� �޼��� - �Խñ� �ϳ� �����ͼ� ���
		void insert(BoardVO article) throws Exception;
		
		//2.�ϳ��� �Խñ� ��ȸ ��� �޼��� - �ϳ��� ��ȸ�Ϸ���
		BoardVO getArticle(int boardNo) throws Exception;
		
		//3.�Խù� ���� ��� �޼��� - �Խù� ��ü ����
		void update(BoardVO article) throws Exception;
		
		//4.�Խù� ���� ��� �޼��� - �Խù� ��ȣ�l ���� �����Ѵ�
		void delete(int boardNo) throws Exception;
		
		//5.��� �Խù� ��ȸ ��� �޼���
		List<BoardVO> getAllArticles() throws Exception;
	
}
