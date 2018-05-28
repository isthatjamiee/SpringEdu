package com.kh.myapp.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.myapp.member.service.MemberService;
import com.kh.myapp.member.vo.MemberVO;

@Controller
@RequestMapping(value="/member")
public class MemberController {
   
   // 로그 찍어볼 수 있는 인스턴스 .info로 출력됨. 
   private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
   
   @Autowired
   MemberService memberService;
   
   @RequestMapping(value="/memberJoin") // 주소값
   public void memJoin(Model model) {
      model.addAttribute("memberVO", new MemberVO());
   }
   
   //@Valid : 검증하는 것. 예전에 JSP, 자바스크립트로 유효성 체크했는데 얘로 back단에서 유효성체크 가능해짐. (hibernate.jar 3개 추가했음)
   //셧다운방식인 hibernate.. 
   //외국에서는 hibernate를 마이바티즈보다 더 많이 쓴다. 자바객체를 가지고 테이블하고 1:1로 매핑시키려고. = ORM 
   //마이바티즈방식은 테이블 먼저 설계하고 분류를 만들고... 개발방식이 다름. 우리나라에서는 마이바티즈 많이 사용.
   @RequestMapping(value="/memberJoinOK", method=RequestMethod.POST)
   public String memJoinOK(@Valid MemberVO memberVO, BindingResult result) {
     if(result.hasErrors()) {
    	 logger.info("회원가입 시 오류 발생");
    	 return "/member/memberJoin";
     }else {
    	 memberService.memberInsert(memberVO);
     }
     return "/member/memberList";
     
   }
   @RequestMapping(value="/memberModify/{id:.+}") //get 방식 대신 스프링에서 지원하는 방식 사용 
   public String memberModify(@PathVariable String id, Model model) {
  	 System.out.println("아이디"+id);
  	 logger.info("아이디"+id);
  	 model.addAttribute("memberVO", memberService.getByMemberID(id)); //해당 멤버 아이디를 가져온다
  	 return "/member/memberModify";
   }
   
   @RequestMapping(value="/membeModifyOK")
   public String memberModifyOK (@Valid MemberVO memberVO, BindingResult result) {
  	 if(result.hasErrors()) {
  		 return "/member/memberModify";
  	 }else {
  		 return "redirect:/";
  	 }
   }
   
   @RequestMapping(value="/memberDelete/{id:.+}")
   public String memberDelete(@PathVariable String id, Model model) {
  	 if(memberService.getByMemberID(id) != null) {
  		 memberService.memberDelete(id);
  	 }else {
  		 
  	 };
  	 return "redirect:/";
   }
   
   @RequestMapping(value="/memberList")
   public String memberList(Model model) {
      ArrayList<MemberVO> alist = memberService.getMemberAll();
      model.addAttribute("memberVOS", alist);
      return "/member/memberList";
   }
   
}