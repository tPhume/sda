package lab8.state;

/**
 * Stopped.java
 *
 * This file represents the Locked state.
 */

public class Locked implements State {
	private RemoteDevice remote;
	
	public Locked(RemoteDevice remote) {
		this.remote = remote;
	}

	// the Play button is pressed
	public boolean pressPlay() {
		System.out.println("The player is still locked.");
		
		return false;
	}

	// the Paused button is pressed
	public boolean pressPause() {
		System.out.println("The player is still locked.");
		
		return false;
	}

	// the  Stop button is pressed
	public boolean pressStop() {
		System.out.println("The player is still locked.");
		
		return false;
	}
        
        // the  Rewind button is pressed
        public boolean pressRewind() {
		System.out.println("The player is still locked.");
		
		return false;
        }
        
        // the  Lock button is pressed
        public boolean pressLock() {
		System.out.println("The player is now unlocked.");
		remote.setState(remote.getStoppedState());
		
		return true;
        }
        

}
