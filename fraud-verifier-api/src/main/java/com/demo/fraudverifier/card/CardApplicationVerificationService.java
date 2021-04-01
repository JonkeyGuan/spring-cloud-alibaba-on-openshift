package com.demo.fraudverifier.card;

import java.math.BigDecimal;
import java.util.UUID;

import com.demo.fraudverifier.VerificationResult;

public interface CardApplicationVerificationService {

	VerificationResult verify(UUID uuid, BigDecimal cardCapacity);
}
