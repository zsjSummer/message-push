package com.zms.push.messagepush.dto;

import java.io.Serializable;

/**
 * @ClassName ResultDto
 * @Author zmszsj
 * @Version 1.0.0
 * @Description 返回值包装类
 * @CreateTime 2019/1/16 13:00
 */
public class ResultDto<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	// 自定义的状态码
	private int code;

	// 返回的数据
	private T data;

	// 返回的自定义消息
	private String message;

	public ResultDto() {
	}

	public ResultDto(int code, T data, String message) {
		this.code = code;
		this.data = data;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		ResultDto<?> resultDto = (ResultDto<?>) o;

		if (code != resultDto.code) return false;
		if (data != null ? !data.equals(resultDto.data) : resultDto.data != null) return false;
		return message != null ? message.equals(resultDto.message) : resultDto.message == null;
	}

	@Override
	public int hashCode() {
		int result = code;
		result = 31 * result + (data != null ? data.hashCode() : 0);
		result = 31 * result + (message != null ? message.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "ResultDto{" +
				"code=" + code +
				", data=" + data +
				", message='" + message + '\'' +
				'}';
	}
}
