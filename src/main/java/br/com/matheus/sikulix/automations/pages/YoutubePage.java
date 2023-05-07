package br.com.matheus.sikulix.automations.pages;

import org.sikuli.script.Key;
import org.sikuli.script.Pattern;

public class YoutubePage extends AbstractPage {

	private Pattern logo = new Pattern("youtube\\youtube-logo.png");
	private Pattern searchBar = new Pattern("youtube\\youtube-search-bar.png");

	public YoutubePage() {
		super.waitFor(logo, searchBar);
	}
	
	public YoutubeSearchResultPage searchVideo(String search) {		
		super.click(searchBar);
		super.paste(search).type(Key.ENTER);
		return new YoutubeSearchResultPage();
	}
}
