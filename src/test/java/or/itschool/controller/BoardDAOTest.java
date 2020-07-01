package or.itschool.controller;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.event.TransactionalEventListener;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import or.itschool.mapper.BoardMapper;
import or.itschool.model.BoardVO;
import or.itschool.repository.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardDAOTest {

	@Setter(onMethod_ = @Autowired )
	private BoardMapper boardDAO;
	
	//�Խù���� �׽�Ʈ
	@Test
	public void insertTest() throws Exception {
		
		for(int i=1; i <=3000; i++) {
			BoardVO vo = new BoardVO();
			vo.setTitle(i + "���� �׽�Ʈ �Խù� !!");
			vo.setContent(i + "��° �Խù� �����Դϴ�!");
			vo.setWriter("user" + i);
			boardDAO.insert(vo);
			log.info(log);
		}
	}
	//���� �Խù� ��ȸ �׽�Ʈ
	//100��° �Խù� ��ȸ
	@Test
	public void selectOneTest() throws Exception {
		log.info(boardDAO.getArticle(100).toString() +"\n");
	}
	
	//�Խù� ���� �׽�Ʈ
	@Test
	public void updateTest() throws Exception{
		BoardVO article = new BoardVO();
		
		//1�� �Խù� ����
		article.setBoardNo(1);
		article.setTitle("�� ���� ����!");
		article.setContent("�� ���� ����");
		boardDAO.update(article);
		
		log.info(boardDAO.getArticle(1).toString()+"\n");
	}
	
	//�Խù� ���� �׽�Ʈ
	
	@Test
	public void deleteTest() throws Exception {
		boardDAO.delete(10);
	}
	// ��� �Խù� ��ȸ �׽�Ʈ
	@Test
	public void selectAllTests() throws Exception{
		List<BoardVO> articles = boardDAO.getAllArticles();
		for(BoardVO article : articles) {
			log.info(article.toString());
		}
	}
}
