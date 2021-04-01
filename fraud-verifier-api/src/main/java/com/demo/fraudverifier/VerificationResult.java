package com.demo.fraudverifier;

import java.io.Serializable;
import java.util.UUID;

public class VerificationResult implements Serializable{

	private static final long serialVersionUID = 1786788625957323161L;

	private UUID userId;
	private Status status;

	private VerificationResult(UUID userId, Status status) {
		this.userId = userId;
		this.status = status;
	}

	public VerificationResult() {
	}

	public static VerificationResult passed(UUID userId) {
		return new VerificationResult(userId, Status.VERIFICATION_PASSED);
	}

	public static VerificationResult failed(UUID userId) {
		return new VerificationResult(userId, Status.VERIFICATION_FAILED);
	}

	public UUID getUserId() {
		return userId;
	}

	public Status getStatus() {
		return status;
	}

	public enum Status {
		VERIFICATION_PASSED,
		VERIFICATION_FAILED
	}
	
}
