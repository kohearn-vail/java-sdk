package com.vailsys.freeclimb.percl;

/**
 * SendDigits represents the {@code SendDigits} PerCL command. See the
 * SendDigits PerCL documentation for details.
 */
public class SendDigits extends PerCLCommand {

	private String digits;
	private Integer pauseMs;
	private Boolean privacyMode;

	public SendDigits(String digits) {
		this.setDigits(digits);
	}

	public String getDigits() {
		return this.digits;
	}

	public Integer getPauseMs() {
		return this.pauseMs;
	}

	public Boolean getPrivacyMode() {
		return this.privacyMode;
	}

	public void setDigits(String digits) {
		this.digits = digits;
	}

	public void setPauseMs(Integer pauseMs) {
		this.pauseMs = pauseMs;
	}

	public void setPrivacyMode(Boolean privacyMode) {
		this.privacyMode = privacyMode;
	}
}
