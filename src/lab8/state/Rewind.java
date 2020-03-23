package lab8.state;


import state.RemoteDevice;

/**
 * Paused.java
 * 
 * This file represents the Rewind state.
 */

public class Rewind implements State {
	private RemoteDevice remote;
	
	public Rewind(RemoteDevice remote) {
		this.remote = remote;
	}

	// the Play button is pressed
	public boolean pressPlay() {
		System.out.println("The player cannot be played.");
                
		return false;
	}

	// the Pause button is pressed
	public boolean pressPause() {
		System.out.println("The player cannot be paused.");
                
		return false;
	}


	// the Stop button is pressed
	public boolean pressStop() {
		System.out.println("The player is now stopped.");
		remote.setState(remote.getStoppedState());
		remote.setPosition(0);
		
		return true;
	}
        
        // the  Rewind button is pressed
        public boolean pressRewind() {
		System.out.println("The player is already rewind.");
                
		return false;
        }
        
        // the  Lock button is pressed
        public boolean pressLock() {
		System.out.println("The player is locked.");
		remote.setState(remote.getLockedState());
		
		return true;
        }
}
