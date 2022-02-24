package com.payment.requests;

import lombok.Data;

@Data
public class PaymentRequest {
		PaymentRequestBody body;
		PaymentHeader head;
}
