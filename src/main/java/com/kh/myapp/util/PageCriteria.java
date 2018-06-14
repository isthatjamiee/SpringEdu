package com.kh.myapp.util;

public class PageCriteria {

/*	private int pageNumPerPage = 10; //	한페이지에 보여줄 페이지수 
	private int startPage;			//	한페이지에  시작페이지
	private int endPage;				//	한페이지에  종료페이지
		
	private int totalRec;				// 전체 레코드수
	private int finalEndPage;		//	최종페이지
		
	private boolean prev;				//	이전페이지
	private boolean next;				//	다음페이지
	
	private RecordCriteria recordCriteria;		// 한 페이지에 보여줄 레코드수 ,요청페이지 참조 
	*/
	
	private int pageNumPerPage = 10; // 한 페이지에 보여줄 페이지 수
	/* private int curPage; //현재페이지 */
	private int startPage; // 한 페이지의 시작페이지
	private int endPage; // 한 페이지의 종료페이지
	private int reqPage;

	private int totalRec; // 전체 레코드 수
	private int finalEndPage; // 최종 페이지

	private boolean prev; // 이전페이지
	private boolean next; // 다음페이지

	private RecordCriteria recordCriteria; // 한 페이지에 보여 줄 레코드 수, 요청페이지 참조

	public PageCriteria(RecordCriteria recordCriteria) {
		this.recordCriteria = recordCriteria;
		/* this.setCurPage(recordCriteria.getReqPage()); */
	}

	public PageCriteria(RecordCriteria recordCriteria, int totalRec) {
		this.recordCriteria = recordCriteria;
		this.totalRec = totalRec;
		init();
	}
	/*
	 * public PageCriteria(RecordCriteria recordCriteria, int totalRec, int reqPage)
	 * { this(recordCriteria, totalRec); this.reqPage = reqPage; this.init(); }
	 */
	public PageCriteria(RecordCriteria recordCriteria, int totalRec, int pageNumPerPage) {
		this(recordCriteria);
		this.totalRec = totalRec;
		this.pageNumPerPage = pageNumPerPage;
		init();
	}


	private void init() {
		// 1) endPage 계산
		this.endPage = (int) (Math.ceil((double) this.recordCriteria.getReqPage() / this.pageNumPerPage)) * pageNumPerPage;

		// 2) startPage 계산
		this.startPage = (this.endPage - this.pageNumPerPage) + 1;

		// 3) finalEndPage 계산
		this.finalEndPage = (int) (Math.ceil(this.totalRec / (double) this.recordCriteria.getNumPerPage()));
		if (endPage > finalEndPage) {
			endPage = finalEndPage;
		}

		// 4) prev 계산
		this.prev = this.startPage == 1 ? false : true;

		// 5) next 계산
		this.next = (this.endPage * this.recordCriteria.getNumPerPage() >= this.totalRec) ? false : true;

	}

	// 미 검색용 파라미터 설정
	public String makeURL() {

		StringBuffer str = new StringBuffer();

		if (recordCriteria.getReqPage() != 0) {
			str.append("reqPage=" + recordCriteria.getReqPage());
		}
		return str.toString();
	}

	// 검색용 파라미터 설정
	public String makeSearchURL(int reqPage) {
		StringBuffer str = new StringBuffer();
		str.append("reqPage=" + reqPage);
		
		if (recordCriteria instanceof FindCriteria) {
			if (((FindCriteria) recordCriteria).getSearchType() != null || 
					!((FindCriteria) recordCriteria).getSearchType().trim().equals("")) {
				str.append("&searchType=" + ((FindCriteria) recordCriteria).getSearchType());
			}
			if (((FindCriteria) recordCriteria).getKeyword() != null ||
					!((FindCriteria) recordCriteria).getKeyword().trim().equals("")) {
				str.append("&keyword=" + ((FindCriteria) recordCriteria).getKeyword());
			}
		}
		return str.toString();
	}

	public void setRecordCriteria(RecordCriteria recordCriteria) {
		this.recordCriteria = recordCriteria;
	}

	/*
	 * public void setCurPage(int curPage) { this.curPage = curPage; }
	 */
	// 한 페이지에 보여 줄 시작페이지 계산
	public void setStartPage(int startPage) {
		this.startPage = endPage - pageNumPerPage + 1;
	}

	// 한 페이지에 보여줄 종료페이지 계산
	public void setEndPage(int endPage) {
	}

	// 전체 레코드 수(DAO에서 계산)
	public void setTotalRec(int totalRec) {
	}

	// 최종페이지 계산
	public void setFinalEndPage(int finalEndPage) {
	}

	// 이전 목록 페이지 보여줄지 판단
	public void setPrev(boolean prev) {
	}

	// 다음목록 페이지 보여줄지 판단
	public void setNext(boolean next) {
	}

	// getter
	public int getPageNumPerPage() {
		return pageNumPerPage;
	}

	/*
	 * public int getCurPage() { return curPage; }
	 */
	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public int getTotalRec() {
		return totalRec;
	}

	public int getFinalEndPage() {
		return finalEndPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public boolean isNext() {
		return next;
	}

	public RecordCriteria getRecordCriteria() {
		return recordCriteria;
	}

	@Override
	public String toString() {
		return "PageCriteria [pageNumPerPage=" + pageNumPerPage + ", curPage=" + /* curPage + */ ", startPage=" + startPage
				+ ", endPage=" + endPage + ", totalRec=" + totalRec + ", finalEndPage=" + finalEndPage + ", prev=" + prev
				+ ", next=" + next + ", recordCriteria=" + recordCriteria + "]";
	}

}
