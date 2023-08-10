package com.point.www.board.paging;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaginationInfo {
    //이 클래스는 화면 하단의 페이지 번호를 계산하는 용도

    /** 페이징 계산에 필요한 파라미터들이 담긴 클래스 */
    private Criteria criteria;

    /** 전체 데이터 개수 */
    private int totalRecordCount;

    /** 전체 페이지 개수 */
    private int totalPageCount;

    /** 페이지 리스트의 첫 페이지 번호 */
    private int firstPage;

    /** 페이지 리스트의 마지막 페이지 번호 */
    private int lastPage;

    /** SQL의 조건절에 사용되는 첫 RNUM */
    private int firstRecordIndex;

    /** SQL의 조건절에 사용되는 마지막 RNUM */
    private int lastRecordIndex;

    /** 이전 페이지 존재 여부 */
    private boolean hasPreviousPage;

    /** 다음 페이지 존재 여부 */
    private boolean hasNextPage;

    //생성자 : 잘못된 값이 들어오면 if문으로 기본값 설정한다.
    public PaginationInfo(Criteria criteria) {
        //페이징 파라미터의 현재 페이지번호가 1보다 작으면 1로 넣는다
        if (criteria.getCurrentPageNo() < 1) {
            criteria.setCurrentPageNo(1);
        }

        //페이지당 출력할 데이터 갯수가 1보다 작거나(데이터 없음) , 100보다 크면 10넣기
        if (criteria.getRecordsPerPage() < 1 || criteria.getRecordsPerPage() > 100) {
            criteria.setRecordsPerPage(10);
        }

        //하단의 보여지는 숫자가 5보다 작거나 20보다 크면 10넣기
        if (criteria.getPageSize() < 5 || criteria.getPageSize() > 20) {
            criteria.setPageSize(5);
        }

        // 요청정보를 가진 criteria를 PaginationInfo클래스의 criteria로 저장, 그래야 페이지 번호 계산할수있음
        this.criteria = criteria;
    }

    //파라미터로 넘어온 전체 데이터수를 PaginationInfo클래스의 전체 데이터 개수에 저장
    public void setTotalRecordCount(int totalRecordCount) {
        this.totalRecordCount = totalRecordCount;

        if (totalRecordCount > 0) {
            //데이터가 1개이상 있으면 페이지 번호계산하는 아래 메소드 실행
           // calculation();
        }
    }






}
