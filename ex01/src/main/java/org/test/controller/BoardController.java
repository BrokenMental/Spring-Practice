package org.test.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.test.domain.BoardVO;
import org.test.service.BoardService;

/****************************************
 * 
 * Controller는 웹페이지의 전체적인 움직임을 조작하는 곳이다. 한개의 페이지 내에서의 움직임일 수 도 있고, 다른 페이지로 이동하는
 * 것일 수도 있다.
 * 
 ****************************************/

@Controller // 컨트롤러라는것을 나타내는 어노테이션
@RequestMapping("/board/*") // board경로 밑의 모든 파일에 대한 요청에 대해 적용한다.
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Inject
	private BoardService service;

	@RequestMapping(value = "/register", method = RequestMethod.GET) // register페이지내의
																		// GET하는
																		// 요소들에
																		// 대한 적용
	public void registerGET(BoardVO board, Model model) throws Exception {
		logger.info("register get ...........");
	}

	/*
	 * @RequestMapping(value = "/register", method = RequestMethod.POST) public
	 * String registPOST(BoardVO board, Model model) throws Exception {
	 * logger.info("regist post ..........."); logger.info(board.toString());
	 * 
	 * service.regist(board);
	 * 
	 * model.addAttribute("result", "success");
	 * 
	 * //return "/board/success"; return "redirect:/board/listAll"; }
	 */

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registPOST(BoardVO board, RedirectAttributes rttr) throws Exception {

		logger.info("regist post ...........");
		logger.info(board.toString());

		service.regist(board);

		rttr.addFlashAttribute("msg", "SUCCESS"); // RedirectAttributes의
													// addFlashAttribute를 이용하면
													// uri 뒤에붙는 부가정보를 가릴수 있다.
		return "redirect:/board/listAll";
	}

	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public void listAll(Model model) throws Exception {

		logger.info("show all list...........");
		model.addAttribute("list", service.listAll());

	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("bno") int bno, Model model) throws Exception { //@RequestParam은 jsp의 request.getParameter("")처럼 동작한다.
		model.addAttribute(service.read(bno));
	}
	
}
