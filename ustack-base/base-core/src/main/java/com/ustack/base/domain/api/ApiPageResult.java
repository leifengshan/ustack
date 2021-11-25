package com.ustack.base.domain.api;

import lombok.Getter;
import lombok.Setter;

/**
 * Description: ApiPageResult
 *
 * @author ferris
 * @date 2021/7/20 15:48
 * @Version 1.0
 */
@Getter
@Setter
public class ApiPageResult extends com.ustack.base.domain.api.ApiResult {

    /** 总数 */
    private Integer total;

    /** 当前页 */
    private Integer pageNo;

    /** 每页数量 */
    private Integer pageSize;

    public void setPage(int total, int pageNo, int pageSize){
        this.total = total;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }
}
