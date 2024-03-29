package br.com.matheus.sikulix.automations;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import br.com.matheus.sikulix.automations.pages.AbstractPage;
import br.com.matheus.sikulix.automations.pages.AnonymousOperaPage;
import br.com.matheus.sikulix.automations.pages.TaskBarPage;
import br.com.matheus.sikulix.automations.pages.YoutubePage;
import br.com.matheus.sikulix.automations.pages.YoutubeSearchResultPage;
import br.com.matheus.sikulix.automations.pages.YoutubeVideoPage;

public class YoutubeAutomation {

	public static void main(String[] args) throws FindFailed {
		AbstractPage.setImagePath();
		YoutubeAutomation.minimize();
		
		TaskBarPage taskBarPage = new TaskBarPage();
		AnonymousOperaPage operaPage = taskBarPage.openAnonymousOpera();
		operaPage.search("youtube.com");
		
		YoutubePage youtubePage = new YoutubePage();
		YoutubeSearchResultPage searchResultPage = youtubePage.searchVideo("TesseracT - Juno");
		YoutubeVideoPage videoPage = searchResultPage.openVideo();
		videoPage.goFullScreen();
		videoPage.enhanceVideoQuality();
	}
	
	private static void minimize() throws FindFailed {	
		Screen screen = new Screen();
		Pattern minimize = new Pattern("eclipse\\window-menu.png").targetOffset(-45, 0);
		screen.click(minimize);
	}
}
