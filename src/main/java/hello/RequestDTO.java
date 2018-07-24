package hello;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.HashMap;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestDTO extends MainRequestDTO {
	private String accountId;
	private String cardId;
	private String requestGateWay;
	private String appId;
	private String deviceId;
	private String simId;
	private String extRefId;
	private String currentTime;
	private String requestId;
	private HashMap<String, Object> trackTime;	
	
	
	public String getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(String currentTime) {
		this.currentTime = currentTime;
	}

	public String getExtRefId() {
		return extRefId;
	}

	public void setExtRefId(String extRefId) {
		this.extRefId = extRefId;
	}

	public HashMap<String, Object> getTrackTime() {
		return trackTime;
	}

	public void setTrackTime(HashMap<String, Object> trackTime) {
		this.trackTime = trackTime;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getRequestGateWay() {
		return requestGateWay;
	}

	public void setRequestGateWay(String requestGateWay) {
		this.requestGateWay = requestGateWay;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getSimId() {
		return simId;
	}

	public void setSimId(String simId) {
		this.simId = simId;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	@Override
	public String toString() {
		return "RequestDTO [accountId=" + accountId + ", cardId=" + cardId + ", requestGateWay=" + requestGateWay
				+ ", appId=" + appId + ", deviceId=" + deviceId + ", simId=" + simId + ", extRefId=" + extRefId
				+ ", currentTime=" + currentTime + ", requestId=" + requestId + ", trackTime=" + trackTime + "]";
	}

}
