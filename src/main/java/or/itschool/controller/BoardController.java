package or.itschool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.log4j.Log4j;
import or.itschool.model.BoardVO;
import or.itschool.service.BoardService;

@Controller //��Ʈ�ѷ� �� ������ִ� ������̼�
@Log4j //log4j 1.2.17 �� ����: pom.xml
@RequestMapping("/board/*")
public class BoardController {

		//��Ʈ�ѷ��� ���񽺰� �������谡 �����Ǿ������� ������������ �ش�
	@Autowired
//  @setter(onMethod_ = @Autowired)
	private BoardService service;
	
	
	@RequestMapping(value = "/list" , method = RequestMethod.GET)
	public String list(Model model) throws Exception{
		log.info("/board/list : GET ��û �߻�!");
		System.out.println("�Խñ� ������ ���� ��û!");
		
		List<BoardVO> articles = service.getAllArticles();
		System.out.println("========================");
		for(BoardVO vo : articles)
			System.out.println("==================================");
		
		model.addAttribute("articles", service.getAllArticles());
		
		return "board/list";
	}
		
		@RequestMapping(value = "/write", method = RequestMethod.GET)
		public String write() {
			log.info("/board/write : GET��û �߻�");
			return "board/write";
		}
		
		@RequestMapping(value ="/content" , method = RequestMethod.GET)
		public String content(@RequestParam("boardNo") int boardNo, Model model) throws Exception {
			log.info("/board/content : GET ��û �߻� ! ");
			
			model.addAttribute("article", service.getArticle(boardNo));
			
			return "board/content";
	}
		
		@RequestMapping(value ="/modify", method = RequestMethod.GET)
		public String modify(@RequestParam("boardNo") int boardNo, Model model) throws Exception {
			
			log.info("/board/modify : GET ��û �߻�");
			model.addAttribute("article", service.getArticle(boardNo));
			return "board/modify";
		}
	
		@RequestMapping(value ="/write", method = RequestMethod.POST)
		public String write(BoardVO article, RedirectAttributes redirectAttr) throws Exception{
			
			log.info("/board/write : POST ��û !");
			log.info("������ �Խñ� Ȯ�� :" + article.toString());
			
			service.insert(article);
			
			redirectAttr.addFlashAttribute("message", "regSuccess");
			
			return "redirect:/board/list";
		}
		
		@RequestMapping(value="/modify", method = RequestMethod.POST)
		public String modify(BoardVO article, RedirectAttributes redirectAttr) throws Exception {
			log.info("/board/modify : POST ��û !");
			service.update(article);
			
			redirectAttr.addFlashAttribute("message", "modSuccess");
			
			return "redirect:/board/content?boardNo=" + article.getBoardNo();
		}
		
		@RequestMapping(value ="/delete", method = RequestMethod.POST)
		public String delete(@RequestParam("boardNo") int boardNo, 
				RedirectAttributes redirectAttr) throws Exception {
			
			log.info("/board/delete : POST ��û ~!");
					service.delete(boardNo);
					
					redirectAttr.addFlashAttribute("message", "delSuccess");
					return "redirect:/board/list";
							
		}
		
}
