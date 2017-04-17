package io.skidrunner.jme3;

public class MouseLook {
	
	public static final float DEFAULT_SENSITIVITY_X = 2f;
	public static final float DEFAULT_SENSITIVITY_Y = 2f;
	
	public static final float DEFAULT_MINIMUM_VERTICAL_ANGLE = -FastMath.HALF_PI;
	public static final float DEFAULT_MAXIMUM_VERTICAL_ANGLE = FastMath.HALF_PI;
	
	private float sensitivityX;
	private float sensitivityY;
	
	private float minimumVerticalAngle;
	private float maximumVerticalAngle;
	
	private float inputX;
	private float inputY;
	
	private final Quaternion horizontalRotation = new Quaternion();
	private final Quaternion verticalRotation = new Quaternion();
	
	private final Quaternion targetHorizontalRotation = new Quaternion();
	private final Quaternion targetVerticalRotation = new Quaternion();
	
	private float horizontalAngle;
	private float verticalAngle;
	
	public MouseLook() { }
	
	public boolean isClampingEnabled() {
		return true;
	}
	
	public boolean setClampingEnabled(boolean enabled) {
	}
	
	public boolean isSmoothEnabled() {
		return false;
	}
	
	public void enableSmoothingEnabled(boolean enabled) {
		
	}
	
	/**
	 * @return X sensitivity factor
	 */
	public float getSensitivityX() {
		return sensitivityX;
	}
	
	/**
	 * @param X sensitivity factor
	 */
	public void setSensitivityX(float sensitivityX) {
		this.sensitivityX = sensitivityX;
	}
	
	/**
	 * @return Y sensitivity factor
	 */
	public float getSensitivityY() {
		return sensitivityY;
	}
	
	/**
	 * This perameter 
	 * @param Y sensitivity factor
	 */
	public void setSensitivityY(float sensitivityY) {
		this.sensitivityY = sensitivityY;
	}
	
	public float getMinimumVerticalAngle() {
		return minimumVerticalAngle;
	}
	
	public void setMinimumVerticalAngle(float minimumVerticalAngle) {
		this.minimumVerticalAngle = minimumVerticalAngle;
	}
	
	public float getMaximumVerticalAngle() {
		return maximumVerticalAngle;
	}
	
	public void setMaximumVerticalAngle(float maximumVerticalAngle) {
		this.maximumVerticalAngle = maximumVerticalAngle;
	}
	
	/**
	 * @return current input X value.
	 */
	public float getInputX() {
		return inputX;
	}
	
	/**
	 * @param current input X value.
	 */
	public void setInputX(float inputX) {
		this.inputX = inputX;
	}
	
	/**
	 * @return current input Y value.
	 */
	public float getInputY() {
		return inputY;
	}
	
	/**
	 * @param current input Y value.
	 */
	public void setInputY(float inputY) {
		this.inputY = inputY;
	}
	
	/**
	 * @return calculated horizontal rotation
	 */
	public Quaternion getHorizontalRotation() {
		return getHorizontalRotation(null);
	}
	
	/**
	 * @param Quaternion object to store calculated horizontal rotation
	 * @return calculated horizontal rotation
	 */
	public Quaternion getHorizontalRotation(Quaternion horizontalRotation) {
		if(horizontalRotation == null) {
			horizontalRotation = new Quaternion();
		}
		return horizontalRotation.set(this.horizontalRotation);
	}
	
	/**
	 * @return calculated horizontal direction
	 */
	public Vector3f getHorizontalDirection() {
		return getHorizontalDirection(null);
	}
	
	/**
	 * @param Quaternion object to store calculated horizontal direction
	 * @return calculated horizontal direction
	 */
	public Vector3f getHorizontalDirection(Vector3f horizontalDirection) {
		if(horizontalDirection == null) {
			horizontalDirection = new Vector3f();
		}
		horizontalDirection.set(Vector3f.UNIT_Z);
		return horizontalRotation.multLocal(horizontalDirection);
	}
	
	/**
	 * @return calculated vertical rotation
	 */
	public Quaternion getVerticalRotation() {
		return getVerticalRotation(null);
	}
	
	/**
	 * @param Quaternion object to store calculated vertical rotation
	 * @return calculated vertical rotation
	 */
	public Quaternion getVerticalRotation(Quaternion verticalRotation) {
		if(verticalRotation == null) {
			verticalRotation = new Quaternion();
		}
		return verticalRotation.set(this.verticalRotation);
	}
	
	/**
	 * @return calculated vertical direction
	 */
	public Vector3f getVerticalDirection() {
		return getVerticalDirection(null);
	}
	
	/**
	 * @param Quaternion object to store calculated vertical direction
	 * @return calculated vertical direction
	 */
	public Vector3f getVerticalDirection(Vector3f verticalDirection) {
		if(verticalDirection == null) {
			verticalDirection = new Vector3f();
		}
		verticalDirection.set(Vector3f.UNIT_Z);
		return horizontalRotation.multLocal(verticalDirection);
	}
	
	/**
	 * @param time between frames in seconds
	 */
	public void update(float time) {
		horizontalAngle += getInputX() * getSensitivityX();
		verticalAngle -= getInputY() * getSensitivityY();
		
		if(clampVerticalRotation()) {
			verticalAngle = FastMath.clamp(verticalAngle % FastMath.TWO_PI, getMinimumVerticalAngle(), getMaximumVerticalAngle());
		}
		
		targetHorizontalRotation.fromAngles(0f, horizontalAngle, 0f);
		targetVerticalRotation.fromAngles(verticalAngle 0f, 0f);
		
		if(!isSmoothEnabled()) {
			horizontalRotation.set(targetHorizontalRotation);
			verticalRotation.set(targetVerticalRotation);
		} else {
			
		}
	}
	
}
