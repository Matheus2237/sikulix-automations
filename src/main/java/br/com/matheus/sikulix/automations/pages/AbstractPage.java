package br.com.matheus.sikulix.automations.pages;

import org.sikuli.script.FindFailed;
import org.sikuli.script.ImagePath;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public abstract class AbstractPage {

	private Screen screen = new Screen();
	private static final double stdWaitTime = 0.8;
	private static final double biggerWaitTime = 5.0;
	
	protected AbstractPage type(String pressedKey) {
		screen.wait(stdWaitTime);
		screen.type(pressedKey);
		return this;
	}
	
	protected boolean exists(Pattern pattern) {
		return screen.exists(pattern) != null;
	}

	protected void rightClick(Pattern pattern) {
		screen.wait(stdWaitTime);
		try { screen.rightClick(pattern); } 
		catch(FindFailed ff) { throw new RuntimeException(); }
	}
	
	protected void click(Pattern pattern) {
		screen.wait(stdWaitTime);
		try { screen.click(pattern); }
		catch(FindFailed ff) { throw new RuntimeException(); }
	}
	
	protected void stdWait() {
		screen.wait(stdWaitTime);
	}
	
	protected void biggerWait() {
		screen.wait(biggerWaitTime);
	}
	
	protected AbstractPage paste(String pasteable) {
		screen.paste(pasteable);
		return this;
	}
	
	public static void setImagePath() {
		final String LOCAL_PROJECT_PATH = System.getenv("LOCAL_PROJECT_PATH");
		final String IMAGES_ROOT_PATH = "sikulix-automations\\src\\main\\resources\\sikuli-imgs\\";
		ImagePath.add(LOCAL_PROJECT_PATH.concat(IMAGES_ROOT_PATH));
	}
	
	protected void waitFor(Pattern... patterns) {
		while(!patternsIsShown(patterns))
			this.stdWait();
	}

	private boolean patternsIsShown(Pattern... patterns) {
		for (Pattern pattern : patterns)
			if(!this.exists(pattern))
				return false;
		return true;
	}
}
