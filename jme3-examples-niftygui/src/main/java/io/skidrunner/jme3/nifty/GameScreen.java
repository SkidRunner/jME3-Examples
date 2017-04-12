/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.skidrunner.jme3.nifty;

import com.jme3.app.Application;
import com.jme3.app.state.BaseAppState;
import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.input.NiftyInputEvent;
import de.lessvoid.nifty.screen.KeyInputHandler;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;
import javax.annotation.Nonnull;

/**
 * 
 * @author skidrunner
 */
public class GameScreen extends BaseAppState implements ScreenController, KeyInputHandler {
    
    private Nifty nifty;
    private Screen screen;
    
    @Override
    protected void initialize(Application aplctn) {
        
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
    public boolean keyEvent(NiftyInputEvent nie) {
        return false;
    }
    
    void onStartButton() {

    }

    void onOptionsButton() {

    }

}
