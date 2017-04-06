package io.skidrunner.nifty;

import com.jme3.app.SimpleApplication;
import com.jme3.niftygui.NiftyJmeDisplay;
import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.controls.ProgressBar;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;

import javax.annotation.Nonnull;

/**
 * Nifty-GUI control and style examples.
 * 
 * @author skidrunner
 */
public class MainApplication extends SimpleApplication implements ScreenController {

    private NiftyJmeDisplay display;
    private Nifty nifty;

    private ProgressBar progressBar;
    private float progress = -1;

    public static void main(String[] args) {
        MainApplication app = new MainApplication();
        app.start();
    }

    @Override
    public void simpleInitApp() {
        flyCam.setEnabled(false);

        display = new NiftyJmeDisplay(assetManager, inputManager, audioRenderer, guiViewPort);
        nifty = display.getNifty();
        nifty.fromXml("Interface/nifty-screens.xml", "start", this);

        guiViewPort.addProcessor(display);
    }

    @Override
    public void simpleUpdate(float tpf) {
        if(progress < 0) {
            return;
        }
        progress += tpf * 0.1f;
        if(progress > 1) {
            progress = 0;
        }
        progressBar.setProgress(progress);
        progressBar.setText((int)(progress * 100) + "/100");
    }

    @Override
    public void bind(@Nonnull Nifty nifty, @Nonnull Screen screen) {
        progressBar = screen.findNiftyControl("progressbar",ProgressBar.class);
    }

    @Override
    public void onStartScreen() {
        progress = 0f;
    }

    @Override
    public void onEndScreen() {

    }
    
}
