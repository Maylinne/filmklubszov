package fksz.home.view.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import fksz.home.view.model.LanguageUrlMapping;
import fksz.i18n.service.LanguageCode;

@Component
public class LocalizationUrlBuilder {
	public static final String LANGUAGE_PARAM_NAME = "language";

	public List<LanguageUrlMapping> buildAccessibleLanguageSelectors(List<LanguageCode> accessibleLanguages) {
		List<LanguageUrlMapping> result = new ArrayList<LanguageUrlMapping>();
		for (LanguageCode languageCode : accessibleLanguages) {
			result.add(new LanguageUrlMapping(getDisplayName(languageCode), buildUrl(languageCode)));
		}
		return result;
	}

	private String getDisplayName(LanguageCode languageCode) {
		return languageCode.name();
	}

	private String buildUrl(LanguageCode languageCode) {
		return String.format("/?%s=%s", LANGUAGE_PARAM_NAME, languageCode.getCode());
	}
}
