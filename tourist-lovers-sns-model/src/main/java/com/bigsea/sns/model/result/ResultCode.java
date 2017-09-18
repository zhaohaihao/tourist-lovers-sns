package com.bigsea.sns.model.result;
/**
 * 响应码
 * Created by zhh on 2017/09/18.
 */
public enum ResultCode {
	
	SUCCESS(200),	// 成功
	FAIL(400),		// 失败
	UNAUTHORIZED(401), // 未认证(签名错误)
	NOT_FOUND(404),	// 接口不存在
	INTERNAL_SERVER_ERROR(500); // 服务器内部错误
	
	public Integer code;
	
	ResultCode(Integer code) {
		this.code = code;
	}
}
