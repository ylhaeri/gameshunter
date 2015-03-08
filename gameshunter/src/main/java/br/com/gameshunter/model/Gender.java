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
		// FIXME Isso tá meio estranho, deve estar errado lol Achei no SOF
		ResourceBundle bundle = ResourceBundle.getBundle("/WEB-INF/i18n/ValidationMessages",
				LocaleContextHolder.getLocale());
		return bundle.getString(code);
	}
}