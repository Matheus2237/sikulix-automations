package br.com.matheus.sikulix.automations.pages;

import org.sikuli.script.Pattern;

public class GmailLoginPage extends AbstractPage {

	private Pattern startPoint = new Pattern("gmail\\login-start-point.png");
	private Pattern emailOrTelephone = new Pattern("gmail\\login-email-or-telephone.png");
	private Pattern nextButton = new Pattern("gmail\\login-next.png");
	private Pattern typeYourPassword = new Pattern("gmail\\login-type-your-password.png");
	private Pattern showPassword = new Pattern("gmail\\login-show-password.png");
	private Pattern twoStepsVerfication = new Pattern("gmail\\login-two-steps-verification.png");
	
	public GmailLoginPage() {}
	
	public void login(String user, String password) {
		super.biggerWait();
		if (isLoginAtStart()) {
			this.fillField(emailOrTelephone, user);
		}
		if (isLoginAtPassword()) {
			this.fillField(typeYourPassword, password);
		}
	}
	
	private void fillField(Pattern field, String information) {
		super.click(field);
		super.paste(information);
		super.click(nextButton);
		super.stdWait();
	}
	
	public void waitForVerification() {
		while(super.exists(twoStepsVerfication)) {
			super.stdWait();
		}
	}
	
	private boolean isLoginAtStart() { return isStartPoint() && isEmailOrTelephone() && isNextButton(); }
	
	private boolean isLoginAtPassword() { return isTypeYourPassword() && isShowPassword() && isNextButton(); }
	
	private boolean isStartPoint() { return super.exists(startPoint); }
	
	private boolean isEmailOrTelephone() { return super.exists(emailOrTelephone); }
	
	private boolean isNextButton() { return super.exists(nextButton); }
	
	private boolean isTypeYourPassword() { return super.exists(typeYourPassword); }
	
	private boolean isShowPassword() { return super.exists(showPassword); }
}
