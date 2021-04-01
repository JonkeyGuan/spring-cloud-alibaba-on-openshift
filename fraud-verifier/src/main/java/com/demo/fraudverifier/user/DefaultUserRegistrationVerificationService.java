package com.demo.fraudverifier.user;

import java.util.UUID;

import com.demo.fraudverifier.VerificationResult;

import org.apache.dubbo.config.annotation.DubboService;


@DubboService
public class DefaultUserRegistrationVerificationService implements UserRegistrationVerificationService {

	@Override
	public VerificationResult verifyUser(UUID uuid, int age) {
		if (age < 18 || age > 99) {
			return VerificationResult.failed(uuid);
		}
		return VerificationResult.passed(uuid);
	}

}
