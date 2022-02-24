package com.payment.requests;

import lombok.Data;

@Data
public class PaymentRequestBody {
	
	String requestType="Payment";
	String mid;
	String orderId;
	String websiteName;
	String callbackUrl;
	TxnAmount txnAmount;
	UserInfo userInfo;
	
}
