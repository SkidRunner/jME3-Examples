package io.skidrunner.jme3.nifty;

import com.jme3.app.Application;
import com.jme3.app.state.BaseAppState;
import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.NiftyEventSubscriber;
import de.lessvoid.nifty.controls.ButtonClickedEvent;
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
public class MainScreen extends BaseAppState implements ScreenController, KeyInputHandler {

    private Nifty nifty;
    private Screen screen;

    private boolean popupExit;

    @Override
    protected void initialize(Application aplctn) {
        setEnabled(false);
    }

    @Override
    protected void cleanup(Application aplctn) {

    }

    @Override
    protected void onEnable() {

    }

    @Override
    protected void onDisable() {

    }

    @Override
    public void bind(@Nonnull final Nifty nifty, @Nonnull final Screen screen) {
        this.nifty = nifty;
        this.screen = screen;
    }

    @Override
    public void onStartScreen() {
        setEnabled(true);
    }

    @Override
    public void onEndScreen() {
        setEnabled(false);
    }

    @Override
    public boolean keyEvent(NiftyInputEvent inputEvent) {
        if (inputEvent == NiftyStandardInputEvent.Escape) {
            if (popupExit) {
                closePopupExit("no");
            } else {
                openPopupExit();
            }
            return true;
        }
        return false;
    }

    @NiftyEventSubscriber(id = "start")
    public void onStartButton(final String id, final ButtonClickedEvent event) {
        nifty.gotoScreen("game");
    }

    @NiftyEventSubscriber(id = "options")
    public void onOptionsButton(final String id, final ButtonClickedEvent ev) {
        openPopupOptions();
    }

    @NiftyEventSubscriber(id = "quit")
    public void onQuitButton(final String id, final ButtonClickedEvent ev) {
        openPopupExit();
    }

    public void openPopupOptions() {
        nifty.createPopupWithId("popupOptions", "popupOptions");
        nifty.showPopup(screen, "popupOptions", null);
        popupExit = true;
    }

    public void openPopupExit() {
        nifty.createPopupWithId("popupExit", "popupExit");
        nifty.showPopup(screen, "popupExit", null);
        popupExit = true;
    }

    public void closePopupExit(final String result) {
        nifty.closePopup("popupExit", () -> {
            popupExit = false;
            if ("yes".equals(result)) {
                nifty.setAlternateKey("fade");
                getApplication().stop();
            }
        });
    }

}
