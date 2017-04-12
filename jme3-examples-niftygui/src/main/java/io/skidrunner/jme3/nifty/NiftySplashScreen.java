package io.skidrunner.jme3.nifty;

import de.lessvoid.nifty.Nifty;
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
public class NiftySplashScreen implements ScreenController, KeyInputHandler {
    
    private Nifty nifty;
    
    @Override
    public void bind(@Nonnull final Nifty nifty, @Nonnull final Screen screen) {
        this.nifty = nifty;
    }

    @Override
    public void onStartScreen() {
        nifty.gotoScreen("loading");
    }

    @Override
    public void onEndScreen() {
    }

    @Override
    public boolean keyEvent(NiftyInputEvent inputEvent) {
        if (inputEvent == NiftyStandardInputEvent.Escape) {
            nifty.setAlternateKey("exit");
            nifty.gotoScreen("loading");
            return true;
        }
        return false;
    }
}
