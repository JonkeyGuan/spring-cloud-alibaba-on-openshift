package com.demo.userservice;

import static com.demo.fraudverifier.VerificationResult.Status.VERIFICATION_PASSED;

import com.demo.fraudverifier.VerificationResult;
import com.demo.fraudverifier.user.UserRegistrationVerificationService;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class DefaultUserRegistrationService implements UserRegistrationService {

	@DubboReference
	private UserRegistrationVerificationService userRegistrationVerificationService;

	@Override
	public User registerUser(UserDto userDto) {
		User user = new User(userDto);
		verifyUser(user);
		return user;
	}

	private void verifyUser(User user) {
		VerificationResult verificationResult = userRegistrationVerificationService.verifyUser(user.getUuid(), user.getAge());
		user.setStatus(VERIFICATION_PASSED.equals(verificationResult.getStatus()) ? User.Status.OK : User.Status.FRAUD);
	}
}
