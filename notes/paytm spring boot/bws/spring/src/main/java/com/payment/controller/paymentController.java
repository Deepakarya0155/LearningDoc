package com.payment.controller;

//import static com.paytm.pg.merchant.PaytmChecksum.generateSignature;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.payment.requests.PaymentHeader;
import com.payment.requests.PaymentRequest;
import com.payment.requests.PaymentRequestBody;
import com.payment.requests.TxnAmount;
import com.payment.requests.UserInfo;
import com.paytm.pg.merchant.PaytmChecksum;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;

@RestController
public class paymentController {

	RestTemplate tm = new RestTemplate();

	@GetMapping("makepayment")
	public String makePayment() {

		ModelAndView modelAndView = new ModelAndView("redirect:");

		return "success";
	}

	@GetMapping("callback")
	public void callback(@RequestBody Object obj) {
		System.out.println(obj);
	}

	@GetMapping("test")
	public String initiateTrans() throws Exception {
		String url = "https://securegw-stage.paytm.in/theia/api/v1/initiateTransaction?mid=ByWzJP83299182909065&orderId=120";

		HttpHeaders heades = new HttpHeaders();

		PaymentRequestBody body = new PaymentRequestBody();
		PaymentHeader head = new PaymentHeader();

		UserInfo u = new UserInfo();
		u.setCustId("1");

		TxnAmount amount = new TxnAmount();
		amount.setValue("1");

		body.setCallbackUrl("http://localhost:8080/callback");
		body.setOrderId("120");
		body.setMid("ByWzJP83299182909065");
		body.setUserInfo(u);

		body.setTxnAmount(amount);

//		head.setSignature();

		body.setWebsiteName("WEBSTAGING");

		System.out.println(body);
		System.out.println(head);

		PaymentRequest req = new PaymentRequest();
		req.setBody(body);
		req.setHead(head);

		Map h = new HashMap<String, String>();
		heades.add("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36");
		heades.add("signature", PaytmChecksum.generateSignature(body.toString(), "uVzCqtH3AP0DfcPI"));
		HttpEntity et = new HttpEntity(req, heades);

		h.put("mid", "ByWzJP83299182909065");
		h.put("orderId", body.getOrderId());
		return tm.exchange(url, HttpMethod.POST, et, String.class, new HashMap()).getBody().toString();
	}

	@GetMapping("link")
	public String createLink(@RequestHeader Map hmp) throws Exception {
		hmp.forEach((K, V) -> System.out.println(K + ":" + V));

		String url = "https://securegw-stage.paytm.in/link/create";
		HttpHeaders heades = new HttpHeaders();
		heades.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		JSONObject body = new JSONObject();
		body.put("mid", "ByWzJP83299182909065");
		body.put("linkType", "GENERIC");
		body.put("linkDescription", "Test Payment");
		body.put("linkName", "Test");

		JSONObject body = new JSONObject();
		
		heades.setContentType(MediaType.APPLICATION_JSON_UTF8);
		heades.add("tokenType", "AES");
		heades.add("signature", PaytmChecksum.generateSignature(body.toString(), "uVzCqtH3AP0DfcPI"));
		
	
		HttpEntity et = new HttpEntity(body, heades);
	
		RestTemplate tm = new RestTemplate();
		
		heades.forEach((K,V)->{
			System.out.println(K+" **** "+V);
		});

		ResponseEntity reset=tm.exchange(new URI(url), HttpMethod.POST, et, String.class);
		
	
//		ResponseEntity reset = tm.exchange(new URL(url), new URL(url), et, String.class, new HashMap());
		System.out.println(reset.getBody());
		return reset.getBody().toString();
	}

	@GetMapping("hash")
	public String getchecksum() throws Exception {
		TreeMap<String, String> body = new TreeMap<String, String>();

		body.put("mid", "ByWzJP83299182909065");
		body.put("linkType", "GENERIC");
//		body.put("linkDescription", "Test Payment");
//		body.put("linkName", "Test");
		return PaytmChecksum.generateSignature(body, "uVzCqtH3AP0DfcPI");

	}

	@GetMapping("link2")
	public String getLink2() throws Exception {
		String r="";
		JSONObject paytmParams = new JSONObject();

		JSONObject body = new JSONObject();
		body.put("mid", "ByWzJP83299182909065");
		body.put("linkType", "GENERIC");
		body.put("linkDescription", "Test Payment");
		body.put("linkName", "Test");

		/*
		    * Generate checksum by parameters we have in body
		    * You can get Checksum JAR from https://developer.paytm.com/docs/v1/payment-gateway/#code
		    * Find your Merchant Key in your Paytm Dashboard at https://dashboard.paytm.com/next/apikeys
		    */
		String checksum = PaytmChecksum.generateSignature(body.toString(),"uVzCqtH3AP0DfcPI");

		JSONObject head = new JSONObject();
		head.put("tokenType", "AES");
		head.put("signature", checksum);

		paytmParams.put("body", body);
		paytmParams.put("head", head);

		String post_data = paytmParams.toString();

		/* for Staging */
		URL url = new URL("https://securegw-stage.paytm.in/link/create");

		/* for Production */
		// URL url = new URL("https://securegw.paytm.in/link/create);

		try {
		    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		    
		    
		
		    connection.setRequestMethod("POST");
		    connection.setRequestProperty("Content-Type", "application/json");
		    connection.setDoOutput(true);

		    DataOutputStream requestWriter = new DataOutputStream(connection.getOutputStream());
		    requestWriter.writeBytes(post_data);
		    requestWriter.close();
		    String responseData = "";
		    
		    connection.getHeaderFields().forEach((K,V)->{
		    			System.out.println(K);
		    			V.forEach(System.out::println);
		    			System.out.println("###################################");
		    });
		    InputStream is = connection.getInputStream();
		    BufferedReader responseReader = new BufferedReader(new InputStreamReader(is));
		    if ((responseData = responseReader.readLine()) != null) {
		        System.out.append("Response: " + responseData);
		        r+=responseData;
		    }
		    responseReader.close();
		} catch (Exception exception) {
		    exception.printStackTrace();
		}

		return r;

	}
	
	@GetMapping("link3")
	public String getLink3() throws Exception {
		String r="";
		JSONObject paytmParams = new JSONObject();

		JSONObject body = new JSONObject();
		body.put("mid", "ByWzJP83299182909065");
		body.put("linkType", "GENERIC");
		body.put("linkDescription", "Test Payment");
		body.put("linkName", "Test");

		/*
		    * Generate checksum by parameters we have in body
		    * You can get Checksum JAR from https://developer.paytm.com/docs/v1/payment-gateway/#code
		    * Find your Merchant Key in your Paytm Dashboard at https://dashboard.paytm.com/next/apikeys
		    */
		String checksum = PaytmChecksum.generateSignature(body.toString(),"uVzCqtH3AP0DfcPI");

		JSONObject head = new JSONObject();
		head.put("tokenType", "AES");
		head.put("signature", checksum);

		paytmParams.put("body", body);
		paytmParams.put("head", head);

//		String post_data = paytmParams;

		/* for Staging */
		URL url = new URL("https://securegw-stage.paytm.in/link/create");

		/* for Production */
		// URL url = new URL("https://securegw.paytm.in/link/create);
		HttpHeaders heades = new HttpHeaders();
		heades.setContentType(MediaType.APPLICATION_JSON_UTF8);
		HttpEntity et=new HttpEntity(paytmParams.toString(),heades);
		try {
		  RestTemplate rest=new RestTemplate();
		  
		 ResponseEntity<String> s= rest.exchange("https://securegw-stage.paytm.in/link/create", HttpMethod.POST,et, String.class, new HashMap());
		 System.out.println(s);
		} catch (Exception exception) {
		    exception.printStackTrace();
		}

		return r;

	}
}
