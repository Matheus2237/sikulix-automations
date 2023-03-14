package br.com.matheus.sikulix.automations.pages;

import org.sikuli.script.Key;
import org.sikuli.script.Pattern;

public class YoutubePage extends AbstractPage {

	private Pattern logo = new Pattern("youtube\\youtube-logo.png");
	private Pattern searchBar = new Pattern("youtube\\youtube-search-bar.png");

	public YoutubePage() {
		while(!isYoutubeLoaded()) {
			super.stdWait();
		}
	}
	
	protected boolean isYoutubeLoaded() {
		return super.exists(logo) && super.exists(searchBar);
	}

	public YoutubeSearchResultPage searchVideo(String search) {		
		super.click(searchBar);
		super.paste(search).type(Key.ENTER);
		return new YoutubeSearchResultPage();
	}
}
