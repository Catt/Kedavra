package catt.kedavra.components;

/**
 * All movement-related components should extend this class. It contains variables and functions related to movement
 * that all movement-components will need to have.
 * @author AbsentMoniker
 *
 */
public abstract class CoMove extends Component {
	protected boolean isStunned = false;
	
	public boolean getStunned(){
		return isStunned;
	}
	public void setStunned(boolean state){
		isStunned = state;
	}
}
