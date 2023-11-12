package paks.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	
	String resourceName;
	String fieldName;
	long fieldValue;
	String fieldValueChars;

	public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue) {
		super(String.format("%s not found with %s: %s", resourceName,fieldName,fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	
	
	public ResourceNotFoundException(String resourceName, String fieldName, String fieldValueChars) {
		super();
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValueChars = fieldValueChars;
	}


	public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue, String fieldValueChars) {
		super();
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
		this.fieldValueChars = fieldValueChars;
	}


	public ResourceNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResourceNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	public ResourceNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	public ResourceNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	public ResourceNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}


	public String getResourceName() {
		return resourceName;
	}


	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}


	public String getFieldName() {
		return fieldName;
	}


	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}


	public long getFieldValue() {
		return fieldValue;
	}


	public void setFieldValue(long fieldValue) {
		this.fieldValue = fieldValue;
	}


	public String getFieldValueChars() {
		return fieldValueChars;
	}


	public void setFieldValueChars(String fieldValueChars) {
		this.fieldValueChars = fieldValueChars;
	}
	
	
	

}
