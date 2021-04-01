package com.demo.fraudverifier.user;

import java.util.UUID;

import com.demo.fraudverifier.VerificationResult;

public interface UserRegistrationVerificationService {

	VerificationResult verifyUser(UUID uuid, int age);

}
