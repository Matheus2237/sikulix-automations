package br.com.matheus.sikulix.automations.pages;

import org.sikuli.script.Key;
import org.sikuli.script.Pattern;

public class AnonymousOperaPage extends AbstractPage {

	private Pattern anonymousIcon = new Pattern("opera\\anonymous-icon.png");
	private Pattern inPrivateMode = new Pattern("opera\\in-private-mode.png");
	private Pattern searchInWeb = new Pattern("opera\\search-in-web.png");
	private Pattern searchBar = new Pattern("opera\\search-bar.png");
	private Pattern closeX = new Pattern("opera\\closeX.png");
	
	public AnonymousOperaPage() {
		this.waitForOperaPage();
	}

	public void search(String searchInput) {
		super.click(searchBar);
		super.paste(searchInput).type(Key.ENTER);
	}
	
	public void closeTab() {
		super.biggerWait();
		super.click(closeX);
	}
	
	private void waitForOperaPage() {
		while(!super.exists(anonymousIcon) &&
				!super.exists(inPrivateMode) &&
				!super.exists(searchInWeb))
			this.stdWait();
	}
}
