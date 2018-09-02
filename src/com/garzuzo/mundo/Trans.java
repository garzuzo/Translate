package com.garzuzo.mundo;

import com.gtranslate.Language;
import com.gtranslate.Translator;

public class Trans {

	/*
	 * https://dictionary-api.cambridge.org/api/resources#java
	 * https://code.google.com/archive/p/java-google-translate-text-to-speech/
	 */
	public String translate(boolean eToS, String text) {
		Translator translate = Translator.getInstance();
		String ret = "";
		if (eToS) {
			ret = translate.translate(text, Language.ENGLISH, Language.SPANISH);
		} else {
			ret = translate.translate(text, Language.SPANISH, Language.ENGLISH);
		}
		return ret;
	}
}
