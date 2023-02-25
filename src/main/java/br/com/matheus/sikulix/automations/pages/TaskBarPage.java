package br.com.matheus.sikulix.automations.pages;

import org.sikuli.script.Key;
import org.sikuli.script.Pattern;

public class TaskBarPage extends AbstractPage{

	private Pattern taskbar = new Pattern("taskbar\\taskbar").similar(0.6);
	private Pattern operaIcon = new Pattern("taskbar\\opera-icon");
	private Pattern newAnonymousGuide = new Pattern("taskbar\\opera-new-anonymous-window.png");
	
	public TaskBarPage() {}
	
	public void showTaskBar() {
		super.type(Key.WIN);
	}
	
	public void openAnonymousOpera() {
		if(isTaskBarVisible()) {
			super.rightClick(this.operaIcon);
		}
		super.click(this.newAnonymousGuide);
		super.biggerWait();
	}

	private boolean isTaskBarVisible() { return super.exists(this.taskbar); }
}
