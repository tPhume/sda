package lab1.pattern;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PieChartObserver extends JPanel implements Observer {
    public PieChartObserver(CourseData data) {
        data.attach(this);
        this.courseData = data.getUpdate();
        this.setPreferredSize(new Dimension(2 * LayoutConstants.xOffset
                + (LayoutConstants.barSpacing + LayoutConstants.barWidth)
                * this.courseData.size(), LayoutConstants.graphHeight + 2
                * LayoutConstants.yOffset));
        this.setBackground(Color.white);
    }


    public void paint(Graphics g) {
        super.paint(g);
        Integer[] data = new Integer[courseData.size()];

        for (int i = 0; i < courseData.size(); i++) {
            data[i] = courseData.get(i).getNumOfStudents();
        }

        int radius = 100;
        //first compute the total number of students
        double total = 0.0;
        for (int i = 0; i < data.length; i++) {
            total += data[i];
        }

        //if total == 0 nothing to draw
        if (total != 0) {
            double startAngle = 0.0;
            for (int i = 0; i < data.length; i++) {
                double ratio = (data[i] / total) * 360.0;
                //draw the arc
                g.setColor(LayoutConstants.courseColours[i%LayoutConstants.courseColours.length]);
                g.fillArc(LayoutConstants.xOffset, LayoutConstants.yOffset, 2 * radius, 2 * radius, (int) startAngle, (int) ratio);
                startAngle += ratio;
            }
        }
    }

    public void update(ArrayList<CourseRecord> courseRecords) {
        courseData = courseRecords;
        this.setPreferredSize(new Dimension(2 * LayoutConstants.xOffset
                + (LayoutConstants.barSpacing + LayoutConstants.barWidth)
                * this.courseData.size(), LayoutConstants.graphHeight + 2
                * LayoutConstants.yOffset));
        this.revalidate();
        this.repaint();
    }

    private ArrayList<CourseRecord> courseData;
}
