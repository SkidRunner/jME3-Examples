package io.skidrunner.jme3;

import com.jme3.app.SimpleApplication;
import com.jme3.niftygui.NiftyJmeDisplay;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Quad;
import de.lessvoid.nifty.screen.ScreenController;
import io.skidrunner.jme3.nifty.GameScreen;
import io.skidrunner.jme3.nifty.LoadingScreen;
import io.skidrunner.jme3.nifty.MainScreen;

/**
 * Nifty-GUI control and style examples.
 * 
 * @author skidrunner
 */
public class MainApplication extends SimpleApplication {
    
    public static void main(String[] args) {
        MainApplication app = new MainApplication();
        app.start();
    }
    
    @Override
    public void simpleInitApp() {
        flyCam.setEnabled(false);
        inputManager.deleteMapping(INPUT_MAPPING_EXIT);
        
        Geometry jmeGeometry = new Geometry("jME3 Branding", new Quad(1, 1));
        jmeGeometry.setLocalTranslation((cam.getWidth() - 690.0f) * 0.5f, (cam.getHeight() - 303.0f) * 0.5f, 0);
        jmeGeometry.setLocalScale(690, 303, 1);
        jmeGeometry.setMaterial(assetManager.loadMaterial("Materials/Logo-jME3.j3m"));
        guiNode.attachChild(jmeGeometry);
        
        System.out.println("JMONKEY : " + jmeGeometry.getLocalTranslation());
        
        LoadingScreen loadingScreen = new LoadingScreen();
        stateManager.attach(loadingScreen);
        MainScreen mainScreen = new MainScreen();
        stateManager.attach(mainScreen);
        GameScreen gameScreen = new GameScreen();
        stateManager.attach(gameScreen);
        
        new Thread(() -> {
            enqueue(() -> {
                NiftyJmeDisplay display = new NiftyJmeDisplay(assetManager, inputManager, audioRenderer, guiViewPort);
                display.getNifty().fromXml("Interface/nifty-screens.xml", "jmonkey-splash", loadingScreen, mainScreen, gameScreen);
                guiViewPort.addProcessor(display);
                jmeGeometry.removeFromParent();
            });
        }).start();
    }
    
}
