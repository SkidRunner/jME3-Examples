package io.skidrunner.jme3.shooter;

import com.jme3.app.SimpleApplication;
import com.jme3.font.BitmapFont;
import com.jme3.font.BitmapText;
import com.jme3.material.Material;
import com.jme3.material.RenderState;
import com.jme3.math.ColorRGBA;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.queue.RenderQueue;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.scene.shape.Quad;

/**
 * This is the Main Class of your Game. You should only do initialization here.
 * Move your Logic into AppStates or Controls
 * @author normenhansen
 */
public class MainApplication extends SimpleApplication {

    public static void main(String[] args) {
        MainApplication app = new MainApplication();
        app.start();
    }

    @Override
    public void simpleInitApp() {
        Geometry displayHealth = new Geometry("DisplayOverlay", new Quad(110, 29));
        displayHealth.setLocalTranslation(38, 84, 0);
        displayHealth.setQueueBucket(RenderQueue.Bucket.Gui);
        Material displayHealthMaterial = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        displayHealthMaterial.setTexture("ColorMap", assetManager.loadTexture("Textures/DisplayHealthBar.png"));
        displayHealthMaterial.getAdditionalRenderState().setBlendMode(RenderState.BlendMode.Alpha);
        displayHealth.setMaterial(displayHealthMaterial);
        guiNode.attachChild(displayHealth);
        
        Geometry displayCrosshairs = new Geometry("DisplayOverlay", new Quad(64, 64));
        displayCrosshairs.setLocalTranslation((cam.getWidth() - 64) / 2, (cam.getHeight() - 64) / 2, 0);
        displayCrosshairs.setQueueBucket(RenderQueue.Bucket.Gui);
        Material displayCrosshairsMaterial = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        displayCrosshairsMaterial.setTexture("ColorMap", assetManager.loadTexture("Textures/DisplayCrosshairs.png"));
        displayCrosshairsMaterial.getAdditionalRenderState().setBlendMode(RenderState.BlendMode.Alpha);
        displayCrosshairs.setMaterial(displayCrosshairsMaterial);
        guiNode.attachChild(displayCrosshairs);
        
        Geometry displayOverlay = new Geometry("DisplayOverlay", new Quad(256, 128));
        displayOverlay.setQueueBucket(RenderQueue.Bucket.Gui);
        Material displayOverlayMaterial = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        displayOverlayMaterial.setTexture("ColorMap", assetManager.loadTexture("Textures/DisplayOverlay.png"));
        displayOverlayMaterial.getAdditionalRenderState().setBlendMode(RenderState.BlendMode.Alpha);
        displayOverlay.setMaterial(displayOverlayMaterial);
        guiNode.attachChild(displayOverlay);
        
        Geometry displayRockets = new Geometry("DisplayOverlay", new Quad(244, 62));
        displayRockets.setLocalTranslation(0, 6, 0);
        displayRockets.setQueueBucket(RenderQueue.Bucket.Gui);
        Material displayRocketsMaterial = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        displayRocketsMaterial.setTexture("ColorMap", assetManager.loadTexture("Textures/Rockets/DisplayRocket-21.png"));
        displayRocketsMaterial.getAdditionalRenderState().setBlendMode(RenderState.BlendMode.Alpha);
        displayRockets.setMaterial(displayRocketsMaterial);
        guiNode.attachChild(displayRockets);
        
        BitmapFont lcdMono2 = assetManager.loadFont("Interface/Fonts/LCDMono2.fnt");
        BitmapText displayAmmo = new BitmapText(lcdMono2);
        displayAmmo.setLocalTranslation(190, 107, 0);
        guiNode.attachChild(displayAmmo);
        displayAmmo.setText("0000");
        
        Box b = new Box(1, 1, 1);
        Geometry geom = new Geometry("Box", b);

        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.Blue);
        geom.setMaterial(mat);

        rootNode.attachChild(geom);
    }

    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}
