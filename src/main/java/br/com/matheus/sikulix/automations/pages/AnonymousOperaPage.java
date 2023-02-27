package br.com.matheus.sikulix.automations.pages;

import org.sikuli.script.Key;
import org.sikuli.script.Pattern;

public class AnonymousOperaPage extends AbstractPage {

	private Pattern anonymousIcon = new Pattern("opera\\anonymous-icon.png");
	private Pattern inPrivateMode = new Pattern("opera\\in-private-mode.png");
	private Pattern searchInWeb = new Pattern("opera\\search-in-web.png");
	private Pattern searchBar = new Pattern("opera\\search-bar.png");
	
	public AnonymousOperaPage() {}
	
	public void search(String searchInput) {
		if(this.isOperaOnStart()) {
			super.click(searchBar);
			super.paste(searchInput);
			super.type(Key.ENTER);
		}
	}
	
	private boolean isOperaOnStart() { return isFirstStart() || isSecondStart(); }
	
	private boolean isFirstStart() { return isAnonymousIcon() && isInPrivateMode(); }
	
	private boolean isSecondStart() { return isAnonymousIcon() && isSearchInWeb(); }
	
	private boolean isAnonymousIcon() { return super.exists(anonymousIcon); }
	
	private boolean isInPrivateMode() {	return super.exists(inPrivateMode);	}
	
	private boolean isSearchInWeb() { return super.exists(searchInWeb);	}
}
