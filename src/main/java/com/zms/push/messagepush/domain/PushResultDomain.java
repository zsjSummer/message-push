package com.zms.push.messagepush.domain;

import java.io.Serializable;

/**
 * @ClassName PushResultDomain
 * @Description 推送结果bean
 * @Author zmszsj
 * @Date 2019/2/21 15:22
 * @Version 1.0
 **/
public class PushResultDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	public int total;
	public int successNum;
	public int failedNum;

	public PushResultDomain() {
	}

	public PushResultDomain(int total, int successNum, int failedNum) {
		this.total = total;
		this.successNum = successNum;
		this.failedNum = failedNum;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getSuccessNum() {
		return successNum;
	}

	public void setSuccessNum(int successNum) {
		this.successNum = successNum;
	}

	public int getFailedNum() {
		return failedNum;
	}

	public void setFailedNum(int failedNum) {
		this.failedNum = failedNum;
	}
}
