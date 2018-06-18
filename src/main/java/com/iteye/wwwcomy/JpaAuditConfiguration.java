package com.iteye.wwwcomy;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

@Configuration
public class JpaAuditConfiguration implements AuditorAware<String> {
	private static final String DEFAULT_AUDITOR = "N/A";

	@Override
	public String getCurrentAuditor() {
		return DEFAULT_AUDITOR;
	}
}