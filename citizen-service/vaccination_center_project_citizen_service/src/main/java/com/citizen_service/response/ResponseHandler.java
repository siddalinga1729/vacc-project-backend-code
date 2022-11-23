  package com.citizen_service.response;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {
  public static ResponseEntity<Object> responseBuilderTrue(boolean success,String message,Object responseObject,HttpStatus httpStatus){
	  Map<String,Object> response=new HashMap<>();
	  response.put("success", success);
	  response.put("message", message);
	  response.put("Data", responseObject);
	  
	  return new ResponseEntity<Object>(response,httpStatus);
  }
  
  public static ResponseEntity<?> responseBuilderFalse(boolean success,String message,HttpStatus httpStatus){
	  Map<String,Object> response=new HashMap<>();
	  response.put("success", success);
	  response.put("message", message);
	  
	  return new ResponseEntity<Object>(response,httpStatus); 
  }
}
