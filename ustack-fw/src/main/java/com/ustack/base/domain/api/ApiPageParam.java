package com.ustack.base.domain.api;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * Description: ApiPageParam
 *
 * @author ferris
 * @date 2021/7/21 17:45
 * @Version 1.0
 */
@Getter
@Setter
public class ApiPageParam extends com.ustack.base.domain.api.ApiParam {

    @NotNull(message="当前页不能为空")
    private Integer pageNo = 1;

    @NotNull(message="每页数量不能为空")
    private Integer pageSize = 10;
}
