package com.example.Lee.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginRsltModel {
	private String RSLT_CD;

	public LoginRsltModel(String RSLT_CD) {
		this.RSLT_CD = RSLT_CD;
	}

	@JsonProperty("RSLT_CD")
	public String getRSLT_CD() {
		return RSLT_CD;
	}

	public void setRSLT_CD(String RSLT_CD) {
		this.RSLT_CD = RSLT_CD;
	}
}
