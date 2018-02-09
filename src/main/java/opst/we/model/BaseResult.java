package opst.we.model;

/**
 * Result对象
 * 
 * @author mark
 * 
 */
public class BaseResult {
	/**
	 * 代码
	 */
	private String status;
	/**
	 * 信息
	 */
	private String message;

	/**
	 * 附加内容
	 */
	private boolean success;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
}
