package br.com.matheus.sikulix.automations.pages;

import org.sikuli.script.Key;
import org.sikuli.script.Pattern;

public class TaskBarPage extends AbstractPage{

	private Pattern operaIcon = new Pattern("taskbar\\opera-icon");
	private Pattern newAnonymousGuide = new Pattern("taskbar\\opera-new-anonymous-window.png");
	
	public TaskBarPage() {}
	
	private void showTaskBar() {
		super.type(Key.WIN);
	}
	
	public AnonymousOperaPage openAnonymousOpera() {
		this.showTaskBar();
		super.rightClick(this.operaIcon);
		super.click(this.newAnonymousGuide);
		return new AnonymousOperaPage();
	}
}
