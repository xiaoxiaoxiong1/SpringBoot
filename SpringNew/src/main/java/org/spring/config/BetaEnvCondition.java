package org.spring.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class BetaEnvCondition  implements Condition  {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		Environment env = context.getEnvironment();
		env.getActiveProfiles();
		String evns= env.getProperty("spring.profiles.active");
		if("beta".equals(evns)) {
			return true;
		}
		return false;
	}

}
