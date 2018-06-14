package com.kh.myapp.bbs.dto;

import java.sql.Date;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

//@Getter
//@Setter
//@ToString
//@AllArgsConstructor
@NoArgsConstructor //디폴트 생성자
@Slf4j //log 멤버변수 생성
@Data //getter, setter, toString, equals, hashCode 자동생성
public class BbsDTO {

	//@NotNull
	private int bNum;               // 게시글 번호
	private String bTitle; 					// 제목
  private String bId;             // 작성자ID
  private String bName;           // 작성자이름
  private Date bCdate;            // 작성일
  private Date bUdate;            // 수정일
  private int bHit;               // 조회수
  private String bContent;        // 글내용
	private int bGroup;             // 답글그룹
  private int bStep;              // 답글단계
  private int bIndent;            // 답글 들여쓰기
  
}
