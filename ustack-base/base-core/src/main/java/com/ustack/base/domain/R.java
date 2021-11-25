package com.ustack.base.domain;

import com.ustack.common.enums.ResultCode;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * Description: 响应信息主体
 *
 * @author Ferris
 * @Version 1.0
 */
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class R<T> implements Domain {

	@Getter
	@Setter
	private int code;

	@Getter
	@Setter
	private String msg;

	@Getter
	@Setter
	private T data;

	public static <T> R<T> OK() {
		return restResult(null, ResultCode.SUCCESS, ResultCode.SUCCESS.msg);
	}

	public static <T> R<T> OK(T data) {
		return restResult(data, ResultCode.SUCCESS, ResultCode.SUCCESS.msg);
	}

	public static <T> R<T> OK(T data, String msg) {
		return restResult(data, ResultCode.SUCCESS, msg);
	}

	public static <T> R<T> ERROR() {
		return restResult(null, ResultCode.FAIL, ResultCode.FAIL.msg);
	}

	public static <T> R<T> ERROR(String msg) {
		return restResult(null, ResultCode.FAIL, msg);
	}

	public static <T> R<T> ERROR(ResultCode code, String msg) {
		return restResult(null, code, msg);
	}

	public static <T> R<T> ERROR(T data) {
		return restResult(data, ResultCode.FAIL, ResultCode.FAIL.msg);
	}

	public static <T> R<T> ERROR(T data, String msg) {
		return restResult(data, ResultCode.FAIL, msg);
	}

	public static <T> R<T> DATA(T data) {
		return restResult(data, ResultCode.SUCCESS, null);
	}

	private static <T> R<T> restResult(T data, ResultCode code, String msg) {
		R<T> apiResult = new R<>();
		apiResult.setCode(code.code);
		apiResult.setData(data);
		apiResult.setMsg(msg);
		return apiResult;
	}
}
