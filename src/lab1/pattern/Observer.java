package lab1.pattern;

import java.util.ArrayList;

/**
 * An interface for all Observers
 */
public interface Observer {
	public void update(ArrayList<CourseRecord> courseRecords);
}