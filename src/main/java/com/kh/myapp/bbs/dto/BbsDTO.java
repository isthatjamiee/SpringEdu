package com.kh.myapp.bbs.dto;

import java.sql.Date;

import javax.persistence.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

//@Getter
//@Setter
//@ToString
//@AllArgsConstructor
@Entity
@NoArgsConstructor //디폴트 생성자
@Slf4j //log 멤버변수 생성
@Data //getter, setter, toString, equals, hashCode 자동생성
public class BbsDTO {

	//@NotNull
	private int bnum;               // 게시글 번호
	private String btitle; 					// 제목
  private String bid;             // 작성자ID
  private String bname;           // 작성자이름
  private Date bcdate;            // 작성일
  private Date budate;            // 수정일
  private int bhit;               // 조회수
  private String bcontent;        // 글내용
	private int bgroup;             // 답글그룹
  private int bstep;              // 답글단계
  private int bindent;            // 답글 들여쓰기
  
}

/*
- 사용가능한 어노테이션

@Data : 모든 필드에 getter, setter를 생성하고 toString, equals, hashCode 메서드도 추가
         final로 지정된 필드가 있으면 생성자를 통해 데이터를 받을 수 있게 생성자를 생성하고
         이때 setter를 생성하지 않음
@Getter/@Setter : getter, setter를 생성할 수 있고 접근지정자를 명시할 수 있음.
                    예) @Getter(AccessLevel.PUBLIC)
@ToString : toString()를 재정의할 수 있음. 특정 필드를 제외할 수 있음
             예) @ToString(exclue={"name"})
@AllArgsConstructor : 모든 필드 값을 인자로 받는 생성자 생성, 접근지정자 명시 가능
                          예) @AllArgsConstructor(access=AccessLevel.PUBLIC)
@EqualsAndHashCode : equals, hashCode 메서드 생성, 특정 필드를 제외할 수 있음
                            예) @EqualsAndHashCode(exclude={"name"})
@Log : Log4j사용. private static final Logger logger 추가
@Slf4j : Slf4j사용. private static final Logger logger 추가

*/