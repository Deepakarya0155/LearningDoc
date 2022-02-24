package com.payment.requests;

import lombok.Data;

@Data
public class TxnAmount {
	
	String value;
	String currency="INR";
}
