package br.com.matheus.sikulix.automations;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import br.com.matheus.sikulix.automations.pages.AbstractPage;

public class YoutubeAutomation {

	public static void main(String[] args) throws FindFailed {
		AbstractPage.setImagePath();
		YoutubeAutomation.minimize();
	}
	
	private static void minimize() throws FindFailed {	
		Screen screen = new Screen();
		Pattern minimize = new Pattern("eclipse\\window-menu.png").targetOffset(-45, 0);
		screen.click(minimize);
	}
}
