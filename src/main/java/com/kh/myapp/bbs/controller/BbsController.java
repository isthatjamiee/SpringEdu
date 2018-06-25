package com.kh.myapp.bbs.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.myapp.bbs.dto.BbsDTO;
import com.kh.myapp.bbs.service.BbsService;
import com.kh.myapp.util.FindCriteria;
import com.kh.myapp.util.PageCriteria;
import com.kh.myapp.util.RecordCriteria;

@Controller
@RequestMapping("/bbs")
public class BbsController {

	private static final Logger logger = LoggerFactory
			.getLogger(BbsController.class);

	@Autowired
	@Qualifier("bbsServiceImplXML")
	private BbsService bs;

	// 게시글쓰기 페이지 이동
	@RequestMapping(value = "/write", method = GET)
	public void writeGet(BbsDTO bbsdto, Model model) throws Exception {
		logger.info("write GET..");
	}

	// 게시글 등록
	@RequestMapping(value = "/write", method = POST)
	public String writePost(BbsDTO bbsdto, Model model) throws Exception {
		logger.info("write POST..");
		logger.info(bbsdto.toString());

		bs.write(bbsdto);
		return "redirect:/bbs/list";
	}

	// 전체 게시글 목록
	@RequestMapping(value = "/listAll", method = GET)
	public void listAll(Model model) throws Exception {
		logger.info("listAll GET..");		
		model.addAttribute("list", bs.list());
	}
	
	Authentication auth;
	// 요청페이지 게시글 목록
	@RequestMapping(value = "/list", method = GET)
	public void list(HttpServletRequest request, Model model) throws Exception {
		logger.info("list GET..");
		
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
//		logger.info(auth.getPrincipal().toString());	
		
		bs.list();
		
		int reqPage = 0;
		
		// 요청페이지가 없으면 1페이지로 이동
		if (request.getParameter("reqPage") == null ||
				request.getParameter("reqPage") == "") {
			reqPage = 1;
		}else {
			reqPage = Integer.parseInt(request.getParameter("reqPage"));
		}
		
		// 검색유무조건에 따라 분기
		String searchType = request.getParameter("searchType");
		String keyword	= request.getParameter("keyword");
		

		List<BbsDTO> list = null;
		PageCriteria pc = null;
		RecordCriteria rc = null;
		
		if(keyword == null || keyword.trim().equals("")) {
			// 검색조건이 없는 경우
			rc = new RecordCriteria(reqPage);		
			list = bs.list(rc);		
			int totalRec = bs.totalRec();
			pc = new PageCriteria(rc,totalRec);		
			
		}else {
			// 검색조건이 있는 경우
			rc = new FindCriteria(reqPage,searchType,keyword);
			list = bs.list((FindCriteria)rc);		
			int totalRec = bs.searchTotalRec((FindCriteria)rc);
			pc = new PageCriteria(rc,totalRec);	
			
			request.setAttribute("findCriteria", (FindCriteria)rc);			
		}	
				
		request.setAttribute("list", list);
		request.setAttribute("pageCriteria", pc);

	}

	// 게시글 보기
	@RequestMapping(value = "/view", method = GET)
	public void view(@RequestParam("bnum") int bnum,
			Model model) throws Exception{
		logger.info("게시글 보기");		
		model.addAttribute("view",bs.view(bnum));
		
	}
	
	// 답글 양식 페이지 이동
	@RequestMapping(value="/replyView", method=GET)
	public void replyfrom(@RequestParam("bnum") int bnum,
			BbsDTO bbsdto,Model model) throws Exception {
		logger.info("답글 양식 페이지 이동");
		model.addAttribute("replyView",bs.replyView(bnum));
	}
	
	// 답글등록
	@RequestMapping(value = "/reply", method = POST)
	public String reply(BbsDTO bbsdto, Model model) throws Exception {
		logger.info("답글등록:"+bbsdto);
		bs.reply(bbsdto);
		return "redirect:/bbs/list";
	}
	
	// 게시글 삭제
	@RequestMapping(value="/delete", method=GET)
	public String delete(@RequestParam("bnum") int bnum) throws Exception {
		logger.info("게시글삭제:"+bnum);
		bs.delete(bnum);		
		return "redirect:/bbs/list";
	}
	
	// 게시글 수정
	@RequestMapping(value="/modify", method=POST)
	public String modify(@RequestParam("bnum") int bnum,
			BbsDTO bbsdto, Model model) throws Exception {
		logger.info("게시글수정:"+bnum);
		bs.modify(bbsdto);
		model.addAttribute("view",bbsdto);
		return "redirect:/bbs/view?bnum="+bnum;
	}

	// 댓글 처리테스트 url
	@RequestMapping(value="/rereply", method=GET)
	public String rereply() {
		
		return "/bbs/reply";
	}
	
	// 댓글 처리테스트 url + 보안관련
	@RequestMapping(value="/rereply2", method=GET)
	public String rereply2() {
		
		return "/bbs/reply2";
	}
		
}





