package br.com.matheus.sikulix.automations.pages;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public abstract class AbstractPage {

	private Screen screen = new Screen();
	private static final double stdWaitTime = 0.8;
	private static final double biggerWaitTime = 5.0;
	
	protected void type(String pressedKey) {
		screen.wait(stdWaitTime);
		screen.type(pressedKey);
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
	
	public void biggerWait() {
		screen.wait(biggerWaitTime);
	}
	
	protected void paste(String pasteable) {
		screen.paste(pasteable);
	}
}
