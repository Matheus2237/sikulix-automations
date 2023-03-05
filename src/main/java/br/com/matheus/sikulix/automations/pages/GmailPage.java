package br.com.matheus.sikulix.automations.pages;

import org.sikuli.script.Key;
import org.sikuli.script.Pattern;

public class GmailPage extends AbstractPage {

	private Pattern gmailLogo = new Pattern("gmail\\gmail-logo.png");
	private Pattern gmailCompose = new Pattern("gmail\\gmail-compose.png");
	private Pattern gmailTextArea = new Pattern("gmail\\gmail-text-area.png");
	private Pattern gmailSend = new Pattern("gmail\\gmail-send.png");
	
	public GmailPage() {
		while(!isGmailPage()) {
			super.stdWait();
		}
	}
	
	public GmailPage enviarEmail(String to, String subject, String body) {
		super.stdWait();
		if(isGmailPage()) {
			super.click(gmailCompose);
			this.writeEmail(to, subject, body);
		}
		return this; 
	}
	
	private boolean isGmailPage() {
		return super.exists(gmailLogo) && super.exists(gmailCompose);
	}

	private void writeEmail(String to, String subject, String body) {
		super.stdWait();
		super.click(gmailTextArea);
		super.paste(to);
		super.type(Key.TAB);
		super.paste(subject);
		super.type(Key.TAB);
		super.paste(body);
	}
	
	public void send() {
		super.click(gmailSend );
	}
}
