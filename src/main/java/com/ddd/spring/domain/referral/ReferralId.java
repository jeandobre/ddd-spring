package com.ddd.spring.domain.referral;

import java.util.UUID;

public class ReferralId {
	private UUID value;

	public ReferralId(UUID value) {
		this.value = value;
	}

	public UUID uuid() {
		return value;
	}
}
