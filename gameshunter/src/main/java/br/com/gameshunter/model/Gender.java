package br.com.gameshunter.model;

import java.util.ResourceBundle;

import org.springframework.context.i18n.LocaleContextHolder;

public enum Gender {

	Masculino("gender.male"), Feminino("gender.female");

	private String code;

	private Gender(String labelCode) {
		this.code = labelCode;
	}

	public String getLabel() {
		// TODO Temporário, achar maneira melhor de fazer isso.
		ResourceBundle bundle = ResourceBundle.getBundle("/WEB-INF/i18n/ValidationMessages",
				LocaleContextHolder.getLocale());
		return bundle.getString(code);
	}
}