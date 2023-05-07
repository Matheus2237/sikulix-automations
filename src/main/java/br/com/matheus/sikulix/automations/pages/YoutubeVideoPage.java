package br.com.matheus.sikulix.automations.pages;

import org.sikuli.script.Pattern;

public class YoutubeVideoPage extends AbstractPage {
	
	private Pattern videoTitle = new Pattern("youtube\\video-title.png");
	private Pattern videoSettings = new Pattern("youtube\\video-settings.png");
	private Pattern videoQuality = new Pattern("youtube\\video-quality.png");
	private Pattern video1080p = new Pattern("youtube\\video-1080p.png");
		
	public YoutubeVideoPage() {
		super.waitFor(videoTitle);
	}

	public void goFullScreen() {
		super.type("f");
	}

	public void enhanceVideoQuality() {
		super.click(videoSettings);
		super.waitFor(videoQuality);
		super.click(videoQuality);
		super.click(video1080p);
	}
}
