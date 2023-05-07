package br.com.matheus.sikulix.automations.pages;

import org.sikuli.script.Pattern;

public class YoutubeSearchResultPage extends AbstractPage {
	
	private Pattern searchVideoTitle = new Pattern("youtube\\search-video-title.png");

	public YoutubeSearchResultPage() {
		super.waitFor(searchVideoTitle);
	}

	public YoutubeVideoPage openVideo() {
		super.click(searchVideoTitle);
		return new YoutubeVideoPage();
	}
}
