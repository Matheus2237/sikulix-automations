package br.com.matheus.sikulix.automations.pages;

import org.sikuli.script.Pattern;

public class GmailLoginPage extends AbstractPage {

	private Pattern startPoint = new Pattern("gmail\\login-start-point.png");
	private Pattern emailOrTelephone = new Pattern("gmail\\login-email-or-telephone.png");
	private Pattern nextButton = new Pattern("gmail\\login-next.png");
	private Pattern typeYourPassword = new Pattern("gmail\\login-type-your-password.png");
	private Pattern showPassword = new Pattern("gmail\\login-show-password.png");
	private Pattern twoStepsVerfication = new Pattern("gmail\\login-two-steps-verification.png");
	
	public GmailLoginPage() {
		while(!isLoginAtStart()) {
			super.stdWait();
		}
	}
	
	public void login(String user, String password) {
		this.fillField(emailOrTelephone, user);
		while(!isLoginAtPassword()) {
			super.stdWait();
		}
		this.fillField(typeYourPassword, password);
	}
	
	private void fillField(Pattern field, String information) {
		super.click(field);
		super.paste(information).click(nextButton);
	}
	
	public GmailPage waitForVerification() {
		while(super.exists(twoStepsVerfication)) {
			super.stdWait();
		}
		return new GmailPage();
	}
	
	private boolean isLoginAtStart() {
		return super.exists(startPoint) && super.exists(emailOrTelephone) && hasNextButton();
	}
	
	private boolean isLoginAtPassword() {
		return super.exists(typeYourPassword) && super.exists(showPassword) && hasNextButton();
	}
	
	private boolean hasNextButton() { return super.exists(nextButton); }
}
