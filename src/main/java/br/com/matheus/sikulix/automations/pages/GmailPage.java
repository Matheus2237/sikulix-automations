package br.com.matheus.sikulix.automations.pages;

import org.sikuli.script.Key;
import org.sikuli.script.Pattern;

public class GmailPage extends AbstractPage {

	private Pattern gmailLogo = new Pattern("gmail\\gmail-logo.png");
	private Pattern gmailCompose = new Pattern("gmail\\gmail-compose.png");
	private Pattern gmailTextArea = new Pattern("gmail\\gmail-text-area.png");
	private Pattern gmailSend = new Pattern("gmail\\gmail-send.png");
	private Pattern gmailActions = new Pattern("gmail\\gmail-actions.png");
	
	public GmailPage() {
		super.waitFor(gmailLogo, gmailActions);
	}
	
	public GmailPage composeEmail(String to, String subject, String body) {
		super.waitFor(gmailCompose);
		super.click(gmailCompose);
		this.writeEmail(to, subject, body);
		return this; 
	}
	
	private void writeEmail(String to, String subject, String body) {
		super.stdWait();
		super.click(gmailTextArea);
		super.paste(to).type(Key.TAB)
				.paste(subject).type(Key.TAB)
				.paste(body);
	}
	
	public void send() {
		super.click(gmailSend);
	}
}
