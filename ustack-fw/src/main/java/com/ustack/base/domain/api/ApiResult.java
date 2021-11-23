package com.ustack.base.domain.api;

import com.ustack.base.domain.BaseDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * Description: ApiParam 用于标识API出参
 *
 * @author ferris
 * @date 2021/7/6 17:41
 * @Version 1.0
 */
@Getter
@Setter
public class ApiResult extends BaseDTO {

    private Boolean result = Boolean.TRUE;

}
