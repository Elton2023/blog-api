package paks.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.validation.FieldError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import paks.payloads.apiResponse;

@RestControllerAdvice //this will automatically transfer all exceptions from RestController to here where they can b handled
public class GlobalExceptionHandler {

	
	@ExceptionHandler(ResourceNotFoundException.class)//this annotation will capture eurro if its of a type in in its parameter
	public ResponseEntity<apiResponse>resourceNotFoundExceptionHandeler(ResourceNotFoundException ex){
		String message =ex.getMessage();
		apiResponse apiResponse =new apiResponse(message,false);
		return new ResponseEntity<apiResponse>(apiResponse,HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)//this is one handles illlegit arguments specially from validations
	public ResponseEntity<Map<String,String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException mx){
		 Map<String,String> resp=new HashMap<>();

		mx.getBindingResult().getAllErrors().forEach((error)->{
        String fieldname =    ((FieldError)error).getField();
        String errormessage =error.getDefaultMessage();
        resp.put(fieldname, errormessage); 
		});
		 return  new ResponseEntity<Map<String,String>>(resp,HttpStatus.BAD_REQUEST);
 	}
	
	@ExceptionHandler(ApiException.class)//this annotation will capture eurro if its of a type in in its parameter
	public ResponseEntity<apiResponse>JwtExceptionHandler(ApiException ae ){
		String message =ae.getMessage();
		apiResponse apiResponse =new apiResponse(message,false);
		return new ResponseEntity<apiResponse>(apiResponse,HttpStatus.BAD_REQUEST);
	}
	
//-x-x-x-x-x-x-x-x-x-x-x-x-xTHE END -x-x-x-x--xx--x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-	
}
