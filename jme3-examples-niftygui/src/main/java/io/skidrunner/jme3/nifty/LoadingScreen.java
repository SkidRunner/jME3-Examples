/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.skidrunner.jme3.nifty;

import com.jme3.app.Application;
import com.jme3.app.state.AppStateManager;
import com.jme3.app.state.BaseAppState;
import com.jme3.asset.AssetManager;
import com.jme3.bullet.BulletAppState;
import com.jme3.light.DirectionalLight;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.Camera;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.CameraNode;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.shadow.DirectionalLightShadowRenderer;
import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.controls.ProgressBar;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author skidrunner
 */
public class LoadingScreen extends BaseAppState implements ScreenController {

    private final Node gameRoot;
    
    private Nifty nifty;
    private Screen screen;
    
    private volatile int progress;
    private float currentProgress;
    
    private ProgressBar progressBar;

    public LoadingScreen() {
        gameRoot = new Node("Game Root");
    }

    @Override
    protected void initialize(Application application) {
        // setEnabled(false) should be replaced with load(); for faster loading.
        setEnabled(false);
    }

    @Override
    protected void cleanup(Application application) {

    }

    @Override
    protected void onEnable() {

    }

    @Override
    public void update(float tpf) {
        if (progress >= 100) {
            progressBar.setProgress(100);
            nifty.gotoScreen("main");
        } else if (currentProgress < progress) {
            currentProgress += tpf;
            progressBar.setProgress(currentProgress);
        } else {
            currentProgress = progress;
        }
    }

    @Override
    protected void onDisable() {

    }

    @Override
    public void bind(Nifty nifty, Screen screen) {
        this.nifty = nifty;
        this.screen = screen;
        progressBar = screen.findNiftyControl("progressbar", ProgressBar.class);
    }

    @Override
    public void onStartScreen() {
        setEnabled(true);
        // Only Here for example progress bar example.
        load();
    }

    @Override
    public void onEndScreen() {
        setEnabled(false);
    }

    private void load() {
        Application application = getApplication();
        AppStateManager stateManager = application.getStateManager();
        AssetManager assetManager = application.getAssetManager();
        ViewPort viewPort = application.getViewPort();
        Camera camera = application.getCamera();
        
        for (Spatial scene : viewPort.getScenes()) {
            if (scene instanceof Node) {
                ((Node) scene).attachChild(gameRoot);
                break;
            }
        }
        
        new Thread(() -> {
            try {
                progress = 25;
                progressBar.setText("Initializint camera...");
                CameraNode cameraNode = new CameraNode("camera", camera);
                progress = 30;
                progressBar.setText("Initializint skybox...");
                Spatial skyBox = assetManager.loadModel("Models/Skybox.j3o");
                skyBox.setLocalScale(camera.getFrustumFar());
                cameraNode.attachChild(skyBox);
                progress = 40;
                progressBar.setText("Initializint sunlight...");
                DirectionalLight sun = new DirectionalLight();
                sun.setDirection((new Vector3f(-0.5f, -0.5f, -0.5f)).normalizeLocal());
                sun.setColor(ColorRGBA.White);
                progress = 50;
                progressBar.setText("Initializint shadows...");
                DirectionalLightShadowRenderer dlsr = new DirectionalLightShadowRenderer(assetManager, 1024, 2);
                dlsr.setLight(sun);
                progress = 70;
                progressBar.setText("Initializint Bullet...");
                BulletAppState bulletAppState = new BulletAppState();
                stateManager.attach(bulletAppState);
                progress = 99;
                progressBar.setText("Queueing Changes...");
                application.enqueue(() -> {
                    gameRoot.attachChild(cameraNode);
                    gameRoot.addLight(sun);
                    viewPort.addProcessor(dlsr);
                    progress = 100;
                    return null;
                }).get();
                
            } catch (InterruptedException | ExecutionException ex) {
                Logger.getLogger(LoadingScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }).start();
    }
}
