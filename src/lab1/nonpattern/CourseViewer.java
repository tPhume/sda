package lab1.nonpattern;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
 
/**
 * Presents a barchart view of a set of courses and their marks. No pattern is
 * used in this program.
 */
@SuppressWarnings("serial")
public class CourseViewer extends JFrame implements ActionListener,
		ChangeListener {

	/**
	 * Create a CourseViewer object
	 */
	public CourseViewer() {
		this.setTitle("Observer Pattern -- Non Pattern Version");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sliders = new ArrayList<JSlider>();
		sliderPanel = new JPanel();
		sliderPanel.setLayout(new GridBagLayout());
		sliderPanel.setBackground(Color.white);
		this.getContentPane().setLayout(new GridBagLayout());
		coursePanel = new JPanel();
		coursePanel.setBorder(new TitledBorder("Courses"));
		coursePanel.setLayout(new GridLayout(0, 1));
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.BOTH;

		scrollPane = new JScrollPane(coursePanel,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		// Layout code
		constraints.weightx = 0.0;
		constraints.weighty = 1.0;
		constraints.gridx = 0;
		constraints.gridy = 0;
		sliderPanel.add(scrollPane, constraints);

		button = new JButton("New Course");
		button.addActionListener(this);

		// Layout code
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		constraints.gridy = 1;
		sliderPanel.add(button, constraints);

		// Layout code
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		constraints.gridx = 0;
		constraints.gridy = 0;
		this.getContentPane().add(sliderPanel, constraints);

		// Layout code
		constraints.weightx = 1.0;
		constraints.weighty = 1.0;
		constraints.gridx = 1;
		constraints.gridy = 0;
		// the bar chart will be drawn over this panel
		this.getContentPane().add(new JPanel(), constraints);
		this.setVisible(true);
	}

	/**
	 * Add a new Course object
	 * 
	 * @param courseRecord
	 *            the CourseRecord to be added
	 */
	public void addCourse(CourseRecord courseRecord) {
		boolean alreadyExists = false;
		for (int i = 0; i < sliders.size(); i++) {
			JSlider slider = sliders.get(i);
			if (slider.getName().equals(courseRecord.getName())) {
				alreadyExists = true;
				JOptionPane
						.showMessageDialog(
								null,
								"Warning: Attempt to add new course with an already existing name",
								"alert", JOptionPane.ERROR_MESSAGE);
				i = sliders.size(); // exit the loop
			}
		}
		if (!alreadyExists) { // add the slider
			JSlider slider = new JSlider();
			slider.setBackground(Color.white);
			slider.setName(courseRecord.getName());
			slider.setValue(50);
			slider.setMinimum(0);
			slider.setMaximum(100);
			slider.setMajorTickSpacing(25);
			slider.setMinorTickSpacing(5);
			slider.setPaintTicks(true);
			slider.setPaintLabels(true);
			slider.setBorder(new TitledBorder(courseRecord.getName()));
			slider.addChangeListener(this);
			coursePanel.add(slider);
			coursePanel.revalidate();
			sliders.add(slider);
			this.setSize(LayoutConstants.xOffset + 50 + this.sliders.size()
					* (LayoutConstants.barWidth + LayoutConstants.barSpacing),
					(sliders.size() + 1) * 100 + this.button.getHeight());
			this.sliderPanel.revalidate();
			this.coursePanel.revalidate();
			this.repaint();
			this.setVisible(true);
		}
	}

	public void paint(Graphics g) {
		super.paint(g);
		Integer[] data = new Integer[sliders.size()];

		LayoutConstants.paintBarChartOutline(g, sliders.size());

		for (int i = 0; i < sliders.size(); i++) {
			data[i] = sliders.get(i).getValue();

			JSlider record = sliders.get(i);
			g.setColor(LayoutConstants.courseColours[i]);
			g.fillRect(
					LayoutConstants.xOffset + (i + 1)
							* LayoutConstants.barSpacing + i
							* LayoutConstants.barWidth, LayoutConstants.yOffset
							+ LayoutConstants.graphHeight
							- LayoutConstants.barHeight + 2
							* (LayoutConstants.maxValue - record.getValue()),
					LayoutConstants.barWidth, 2 * record.getValue());
			g.setColor(Color.red);
			g.drawString(record.getName(),
					LayoutConstants.xOffset + (i + 1)
							* LayoutConstants.barSpacing + i
							* LayoutConstants.barWidth, LayoutConstants.yOffset
							+ LayoutConstants.graphHeight + 20);
		}

		this.paintPie(g, data);
	}

	// draws piechart
	public void paintPie(Graphics g, Integer[] data) {
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
				g.fillArc(LayoutConstants.xOffset, LayoutConstants.yOffset + 300, 2 * radius, 2 * radius, (int) startAngle, (int) ratio);
				startAngle += ratio;
			}
		}
	}

	/**
	 * Manages the creation of a new course. Called when "New Course" button is pressed.
	 * 
	 * @param arg0
	 *            not used
	 */
	public void actionPerformed(ActionEvent arg0) {
		String input = JOptionPane
				.showInputDialog("Please enter the new course name:");
		if (input != null)
			this.addCourse(new CourseRecord(input, 50));
	}

	/**
	 * Handles the changing of the marks for a course (changing of a JSlider)
	 * 
	 * @param arg0
	 *            not used
	 */
	public void stateChanged(ChangeEvent arg0) {
		this.repaint();
	}

	
	/**
	 * Sets up an initial set of three courses
	 * 
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) {
		CourseViewer viewer = new CourseViewer();
		viewer.addCourse(new CourseRecord("Physics", 50));
		viewer.addCourse(new CourseRecord("Chemistry", 50));
		viewer.addCourse(new CourseRecord("Biology", 50));
	}
	
	// Frame contents
	private JPanel sliderPanel;

	private JPanel coursePanel;

	private ArrayList<JSlider> sliders;

	private JScrollPane scrollPane;

	private JButton button;
}