package com.vailsys.freeclimb.percl;

public class PlayEarlyMedia extends PerCLCommand {
	private String file;

	public PlayEarlyMedia(String file) {
		this.setFile(file);
	}

	public String getFile() {
		return this.file;
	}

	public void setFile(String file) {
		this.file = file;
	}
}
