package paks.payloads;

public class apiResponse {
private String message;
private boolean suscessStatus;


public apiResponse() {
	super();
	// TODO Auto-generated constructor stub
}


public apiResponse(String message, boolean suscessStatus) {
	super();
	this.message = message;
	this.suscessStatus = suscessStatus;
}


public String getMessage() {
	return message;
}


public void setMessage(String message) {
	this.message = message;
}


public boolean isSuscessStatus() {
	return suscessStatus;
}


public void setSuscessStatus(boolean suscessStatus) {
	this.suscessStatus = suscessStatus;
}


 
 




}
