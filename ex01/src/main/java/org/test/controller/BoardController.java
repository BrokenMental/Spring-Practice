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
import org.test.domain.Criteria;
import org.test.domain.PageMaker;
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
													// 뒤의 항목은 "SUCCESS"라는
													// "msg"를 가린다 라고 해석 하면 된다.
		return "redirect:/board/listAll";
	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("bno") int bno, RedirectAttributes rttr) throws Exception {
		service.remove(bno);
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/board/listAll";
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOSt(BoardVO board, RedirectAttributes rttr) throws Exception {
		logger.info("mod post...........");

		service.modify(board);
		;
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/board/listAll";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET) // register페이지내의
																		// GET하는
																		// 요소들에
																		// 대한 적용
	public void registerGET(BoardVO board, Model model) throws Exception {
		logger.info("register get ...........");
	}

	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public void listAll(Model model) throws Exception {

		logger.info("show all list...........");
		model.addAttribute("list", service.listAll());

	}

	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyGET(int bno, Model model) throws Exception {
		model.addAttribute(service.read(bno));
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("bno") int bno, Model model) throws Exception { // @RequestParam은
																					// 동작한다.
		model.addAttribute(service.read(bno));
	}

	@RequestMapping(value = "/listCri", method = RequestMethod.GET)
	public void listAll(Criteria cri, Model model) throws Exception {
		logger.info("show list Page with Criteria...........");
		model.addAttribute("list", service.listCriteria(cri));
	}

	@RequestMapping(value = "/listPage", method = RequestMethod.GET)
	public void listPage(Criteria cri, Model model)throws Exception{
		logger.info(cri.toString());
		
		model.addAttribute("list", service.listCriteria(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(131);
		
		model.addAttribute("pageMaker", pageMaker);
	}
}
