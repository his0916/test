package or.itschool.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import or.itschool.mapper.BoardMapper;
import or.itschool.model.BoardVO;

public class BoardDAO implements BoardMapper {
	
	private final SqlSessionFactory sqlSession;
	private static final String NAMESPACE = "BoardMapper";
	
	@Autowired
	public BoardDAO(SqlSession sqlSession) {
		this.sqlSession = (SqlSessionFactory) sqlSession;
	}
	//�Խù� ���
	@Override
	public void insert(BoardVO article) throws Exception{
		((SqlSession) sqlSession).insert(NAMESPACE + ".insert",article);
	}
	//2. �ϳ��� �Խñ� ��ȸ ��� �޼���
	@Override
	public BoardVO getArticle(int boardNo) throws Exception{
		System.out.println("�Խñ� ��ȣ : " +boardNo);
		return ((SqlSession) sqlSession).selectOne(NAMESPACE + ".getArticle", boardNo);
	}
	//3. �Խù� ���� ��� �޼���- �Խù� ��ü ������ �����ͼ� �����ϴ�.
	@Override
	public void update(BoardVO article) throws Exception {
		((SqlSession) sqlSession).delete(NAMESPACE+"update",article);
	}
	//4. �Խù� ���� ��� �޼��� - �Խù� ��ȣ�� ���� �����Ѵ�.
	@Override
	public void delete(int boardNo) throws Exception{
		((SqlSession) sqlSession).delete(NAMESPACE+".delete",boardNo);
	}
	//5. ��� �Խù� ��ȸ ��� �޼���- ��� �Խù��� �����ͼ� ����Ʈ�� ��´�.
	@Override
	public List<BoardVO> getAllArticles() throws Exception{
		return((SqlSession) sqlSession).selectList(NAMESPACE+ ".getAllArticles");
	}
}
