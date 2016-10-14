package com.spring.Hit;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.Hit.dao.BoardIDao;

@Controller
@RequestMapping("/board")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	private BoardIDao dao;
	
	//�Խ��� ��Ϻ���
	@RequestMapping("/boardList")
	public String board(Model model, HttpServletRequest req) {
		
		model.addAttribute("req", req);
		model.addAttribute("list", dao.boardDao(model));	//������ ����Ʈ
		model.addAttribute("count", dao.boardCountDao());	//����¡ ó��
	//	model.addAttribute("tableName",dao.boardTName(req.getParameter("tName")));
		
		return "/board/board";
	}
	//�Խ��� �˻�
	@RequestMapping("/boardSearch")
	public String boardSearch(Model model, HttpServletRequest req) {
		model.addAttribute("req", req);
		model.addAttribute("list", dao.boardSearchDao(model));//����,����,�ۼ��ڷ� �˻�
		return "/board/board";
	}
	
	//�Խ��� �ۺ��� & �Խ��� ��ȸ�� ���� & ��� ����Ʈ ����
	@RequestMapping("/boardContent")
	public String boardContent(Model model, HttpServletRequest req) {
		model.addAttribute("req", req);
		dao.boardHitsUpDao(model);	//��ȸ�� ����
		model.addAttribute("dto", dao.boardContentDao(model));
		model.addAttribute("list", dao.boardReplyListDao(model));
		
		return "/board/boardContent";
	}
	//�Խñ� �� ����
	@RequestMapping("/boardWriteForm")
	public String boardWriteForm(Model model, HttpSession sess) {
		
		return "/board/boardWriteForm";
	}
	
	//�Խ��� �۵��
	@RequestMapping("/boardWrite")
	public String boardWrite(Model model, HttpServletRequest req) {
		
		model.addAttribute("req", req);		//req�� DAO���� ����ϱ� ���ؼ� model�� ��´�.
		model.addAttribute("num", dao.boardWriteDao(model));//DAO�� ȣ���ؼ� ��ȯ�� ���� model�� �ٽ� ��Ƽ� jsp���� �Ǵ��ϴ� ������ ����Ѵ�.
		
		return "/board/boardWriteForm";
	}
	//�Խ��� �� ���� ��
	@RequestMapping("/boardUpdateForm")
	public String boardUpdateForm(Model model, HttpServletRequest req) {
		
		model.addAttribute("req", req);		//req�� DAO���� ����ϱ� ���ؼ� model�� ��´�.
		model.addAttribute("dto", dao.boardUpdateFormDao(model));//DAO�� ȣ���ؼ� ��ȯ�� ���� model�� �ٽ� ��Ƽ� jsp���� �Ǵ��ϴ� ������ ����Ѵ�.
		
		return "/board/boardUpdateForm";
	}
	//�Խ��� �ۼ���
	@RequestMapping("/boardUpdate")
	public String boardUpdate(Model model, HttpServletRequest req) {
		
		model.addAttribute("req", req);		//req�� DAO���� ����ϱ� ���ؼ� model�� ��´�.
		model.addAttribute("num", dao.boardUpdateDao(model));//DAO�� ȣ���ؼ� ��ȯ�� ���� model�� �ٽ� ��Ƽ� jsp���� �Ǵ��ϴ� ������ ����Ѵ�.
		
		return "/board/boardUpdateForm";
	}
	//�Խ��� �ۻ���
	@RequestMapping("/boardDelete")
	public String boardDelete(Model model, HttpServletRequest req) {
		
		model.addAttribute("req", req);		//req�� DAO���� ����ϱ� ���ؼ� model�� ��´�.
		model.addAttribute("num", dao.boardDeleteDao(model));//DAO�� ȣ���ؼ� ��ȯ�� ���� model�� �ٽ� ��Ƽ� jsp���� �Ǵ��ϴ� ������ ����Ѵ�.
		
		return "redirect:boardList";
	}
	//�Խ��� ��� ����
	@RequestMapping("/boardReplyWrite")
	public String boardReplyWrite(Model model, HttpServletRequest req) {
		
		model.addAttribute("req", req);		//req�� DAO���� ����ϱ� ���ؼ� model�� ��´�.
		dao.boardReplyWriteDao(model);		//DAO�� ȣ���ؼ� ��ȯ�� ���� model�� �ٽ� ��Ƽ� jsp���� �Ǵ��ϴ� ������ ����Ѵ�.
		int board_no = Integer.parseInt(req.getParameter("board_no"));
		return "redirect:boardContent?board_no="+board_no;
	}
	
}
