package io.skidrunner.jme3.shooter;

/**
 *
 * @author skidrunner
 */
public class InputController {
    
    private static InputController instance;
    
    public InputController getInstance() {
        if(instance == null) {
            instance = new InputController();
        }
        return instance;
    }
    
    private float moveHorizontal;
    private float moveVertical;
    private float viewHorizontal;
    private float viewVertical;
    
    private InputController() { }
    
    public float getMoveHorizontal() {
        return moveHorizontal;
    }
    
    public void setMoveHorizontal(float moveHorizontal) {
        this.moveHorizontal = moveHorizontal;
    }
    
    public float getMoveVertical() {
        return moveVertical;
    }
    
    public void setMoveVertical(float moveVertical) {
        this.moveVertical = moveVertical;
    }
    
    public float getViewHorizontal() {
        return viewHorizontal;
    }
    
    public void setViewHorizontal(float viewHorizontal) {
        this.viewHorizontal = viewHorizontal;
    }
    
    public float getViewVertical() {
        return viewHorizontal;
    }
    
    public void setViewVertical(float viewVertical) {
        this.viewVertical = viewVertical;
    }
    
}
