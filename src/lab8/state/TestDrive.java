package lab8.state;


public class TestDrive {
	public static void main(String[] args) {
		
		// what about a singleton here???
                RemoteDevice remote = new RemoteDevice();
		
		remote.pressPlay();
                remote.pressRewind();
		
		remote.pressPause();
                remote.pressRewind();
		
		remote.pressStop();
                remote.pressRewind();
                
                remote.pressRewind();
		
		remote.pressPlay();
                
                remote.pressStop();
		remote.pressPlay();
                
                remote.pressLock();
                remote.pressPlay();
                remote.pressPause();
                remote.pressStop();
                remote.pressRewind();
                remote.pressLock();
                
                remote.pressPlay();

	}

}
