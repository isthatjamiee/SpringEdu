package com.kh.myapp.bbs.dao;

import java.util.List;

import com.kh.myapp.bbs.dto.BbsDTO;
import com.kh.myapp.util.FindCriteria;
import com.kh.myapp.util.PageCriteria;

public interface BbsDAO {

	// 글등록
	void write(BbsDTO bbsdto);

	// 선택한 글 읽어오기
	BbsDTO view(String bnum);

	// 조회수 증가
	void updateHit(int bHit);

	// 글 수정
	void modify(BbsDTO bbsdto);

	// 글 삭제
	void delete(int bNum);

	// 원글 읽어오기?
	BbsDTO replyView(int bNum);

	// 답글등록하기
	void reply(BbsDTO bbsdto);

	// 요청페이지 글목록 가져오기
	List<BbsDTO> list(PageCriteria pageCriteria);

	//게시글 총계
	int totalRec();

	// 검색 목록 가져오기
	List<BbsDTO> list(FindCriteria findCriteria);

	//검색결과 총계
	int searchTotalRec(FindCriteria findcriteria);

}