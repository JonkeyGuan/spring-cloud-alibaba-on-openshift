package com.demo.cardservice.application;

import java.util.UUID;

import com.demo.fraudverifier.VerificationResult;
import com.demo.fraudverifier.card.CardApplicationVerificationService;
import com.demo.userservice.User;
import com.demo.userservice.UserRegistrationService;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

@Service
class CardApplicationService {

	@DubboReference(check = false)
	private UserRegistrationService userRegistrationService;

	@DubboReference(check = false)
	private CardApplicationVerificationService cardApplicationVerificationService;

	public CardApplication registerApplication(CardApplicationDto applicationDTO) {
		User user = userRegistrationService.registerUser(applicationDTO.user);
		CardApplication application = new CardApplication(UUID.randomUUID(), user, applicationDTO.cardCapacity);
		if (User.Status.OK != user.getStatus()) {
			application.setApplicationResult(ApplicationResult.rejected());
			return application;
		}
		VerificationResult verificationResult = cardApplicationVerificationService.verify(application.getUuid(),
				application.getCardCapacity());
		if (!VerificationResult.Status.VERIFICATION_PASSED.equals(verificationResult.getStatus())) {
			application.setApplicationResult(ApplicationResult.rejected());
		} else {
			application.setApplicationResult(ApplicationResult.granted());
		}
		return application;
	}
}
