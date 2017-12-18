package util;

public class PRSMaintinenceReturn {
	private String result;
	private String message;
	public static final String SUCCESS="success";
	public static final String FAILURE="failure";
	
	public PRSMaintinenceReturn() {
		result = "Initialized result, not yet set.";
		message = "Initialized message, not yet set.";
	}
	public PRSMaintinenceReturn(String result, String message) {
		super();
		this.result = result;
		this.message = message;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public static PRSMaintinenceReturn getMaintReturn(Object obj) {
		PRSMaintinenceReturn r = new PRSMaintinenceReturn();
		if (obj!=null) {
			r.setResult(SUCCESS);
			r.setMessage(obj.getClass().getSimpleName()+" maintenance success");
		}
		else {
			r.setResult(FAILURE);
			r.setMessage("Not found");
		}
		return r;

	}
}