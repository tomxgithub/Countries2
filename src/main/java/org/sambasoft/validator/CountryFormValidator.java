package org.sambasoft.validator;

import org.sambasoft.entities.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

//http://docs.spring.io/spring/docs/current/spring-framework-reference/html/validation.html#validation-mvc-configuring
@Component
public class CountryFormValidator implements Validator {

	@Autowired
	// @Qualifier("emailValidator")
	EmailValidator emailValidator;

	// @Autowired
	// CountryService CountryService;

	@Override
	public boolean supports(Class<?> clazz) {
		return Country.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		Country Country = (Country) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.CountryForm.name");
		// ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email",
		// "NotEmpty.CountryForm.email");
		// ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address",
		// "NotEmpty.CountryForm.address");
		// ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
		// "NotEmpty.CountryForm.password");
		// ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword",
		// "NotEmpty.CountryForm.confirmPassword");
		// ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sex",
		// "NotEmpty.CountryForm.sex");
		// ValidationUtils.rejectIfEmptyOrWhitespace(errors, "country",
		// "NotEmpty.CountryForm.country");

		// if (!emailValidator.valid(Country.getEmail())) {
		// errors.rejectValue("email", "Pattern.CountryForm.email");
		// }

		if (Country.getName() == null) {
			errors.rejectValue("name", "NotEmpty.CountryForm.number");
		}

		// if (Country.getCountry().equalsIgnoreCase("none")) {
		// errors.rejectValue("country", "NotEmpty.CountryForm.country");
		// }

		// if (!Country.getPassword().equals(Country.getConfirmPassword())) {
		// errors.rejectValue("confirmPassword", "Diff.Countryform.confirmPassword");
		// }

		// if (Country.getFramework() == null || Country.getFramework().size() < 2) {
		// errors.rejectValue("framework", "Valid.CountryForm.framework");
		// }

		// if (Country.getSkill() == null || Country.getSkill().size() < 3) {
		// errors.rejectValue("skill", "Valid.CountryForm.skill");
		// }

	}

}