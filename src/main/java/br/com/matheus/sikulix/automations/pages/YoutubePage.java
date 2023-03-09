package br.com.matheus.sikulix.automations.pages;

import org.sikuli.script.Pattern;

public class YoutubePage extends AbstractPage {

	private Pattern logo = new Pattern("youtube\\youtube-logo.png");
	private Pattern searchBar = new Pattern("youtube\\youtube-search-bar.png");
	private Pattern searchButton= new Pattern("youtube\\youtube-search-button.png");

	public YoutubePage() {
		while(!isYoutubeAtStart()) {
			super.stdWait();
		}
	}
	
	private boolean isYoutubeAtStart() {
		return super.exists(logo) && super.exists(searchBar) && super.exists(searchButton);
	}

	public void searchVideo(String search) {		
		super.click(searchBar);
		super.paste(search).click(searchButton);
	}
}
