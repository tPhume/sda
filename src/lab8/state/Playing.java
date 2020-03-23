package lab8.state;


import state.RemoteDevice;

/**
 * Playing.java
 *
 * This file represents the Playing state
 */

public class Playing implements State {
	private RemoteDevice remote;
	
	public Playing(RemoteDevice remote) {
		this.remote = remote;
	}

	// the Play button is pressed
	public boolean pressPlay() {
		System.out.println("The player is already playing.");
		
		return false;
	}

	// the Pause button is pressed
	public boolean pressPause() {
		System.out.println("The player is paused.");
		remote.setState(remote.getPausedState());
		
		return true;
	}

	// the Stop button is pressed
	public boolean pressStop() {
		System.out.println("The player is stopped.");
		remote.setState(remote.getPlayingState());
		remote.setPosition(0);

		return true;
	}
        
        // the  Rewind button is pressed
        public boolean pressRewind() {
		System.out.println("The player cannot be rewind.");
                
		return false;
        }
        
        // the  Lock button is pressed
        public boolean pressLock() {
		System.out.println("The player is locked.");
		remote.setState(remote.getLockedState());
		
		return true;
        }
}
