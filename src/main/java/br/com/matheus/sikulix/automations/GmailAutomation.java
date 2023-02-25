package br.com.matheus.sikulix.automations;

import org.sikuli.script.FindFailed;
import org.sikuli.script.ImagePath;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class GmailAutomation {

	public static void main(String[] args) throws FindFailed {
		GmailAutomation.setImagePath();
		GmailAutomation.minimize();
	}
	
	private static void setImagePath() {
		final String LOCAL_PROJECT_PATH = System.getenv("LOCAL_PROJECT_PATH");
		final String IMAGES_ROOT_PATH = "sikulix-automations\\src\\main\\resources\\sikuli-imgs\\";
		ImagePath.add(LOCAL_PROJECT_PATH.concat(IMAGES_ROOT_PATH));
	}
	
	private static void minimize() throws FindFailed {	
		Screen screen = new Screen();
		Pattern minimize = new Pattern("eclipse\\window-menu.png").targetOffset(-45, 0);
		screen.click(minimize);
	}
}
