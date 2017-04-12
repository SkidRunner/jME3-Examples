package io.skidrunner.jme3.nifty;

import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.elements.Element;
import de.lessvoid.nifty.input.NiftyInputEvent;
import de.lessvoid.nifty.input.NiftyStandardInputEvent;
import de.lessvoid.nifty.screen.KeyInputHandler;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;

import javax.annotation.Nonnull;

/**
 * 
 * @author skidrunner
 */
public class JmonkeySplashScreen implements ScreenController, KeyInputHandler {

    private Nifty nifty;
    
    @Override
    public void bind(@Nonnull final Nifty nifty, @Nonnull final Screen screen) {
        this.nifty = nifty;
        Element element = screen.findElementById("logo");
        
        System.out.println("NIFTY: " + element.getX() + ", " + element.getY());
        System.out.println("NIFTY: " + element.getWidth()+ ", " + element.getHeight());
    }

    @Override
    public void onStartScreen() {
        nifty.gotoScreen("nifty-splash");
    }

    @Override
    public void onEndScreen() {
    }
    
    @Override
    public boolean keyEvent(NiftyInputEvent inputEvent) {
        if (inputEvent == NiftyStandardInputEvent.Escape) {
            nifty.setAlternateKey("exit");
            nifty.gotoScreen("nifty-splash");
            return true;
          }
        return false;
    }
}
