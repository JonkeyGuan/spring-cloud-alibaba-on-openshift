package com.demo.fraudverifier.card;

import java.math.BigDecimal;
import java.util.UUID;

import com.demo.fraudverifier.VerificationResult;

import org.apache.dubbo.config.annotation.DubboService;


@DubboService
public class DefaultCardApplicationVerificationService implements CardApplicationVerificationService{

	private static final BigDecimal LIMIT = new BigDecimal("9000");

	@Override
	public VerificationResult verify(UUID uuid, BigDecimal cardCapacity) {
		if (isOutOfRange(cardCapacity)) {
			return VerificationResult.failed(uuid);
		}
		return VerificationResult.passed(uuid);
	}

	private boolean isOutOfRange(BigDecimal cardCapacity) {
		return cardCapacity.compareTo(LIMIT) > 0;
	}
}
