package fluEpidemic;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.awt.event.*;

/**
 * A frame for adjusting simulation settings
 */
public class Controls extends JFrame {
    // Panel that contains the speed slider
    private JPanel speedPanel;
    // Panel that contains the button group for neighbourhood selection
    private JPanel neighbourhoodPanel;
    private JSlider speedSlider;
    private ButtonGroup neighbourhoodRadioGroup;

    // The simulation object
    private Simulation simulation;
    
    /**
     * Create a control frame
     */
    public Controls(Simulation s) {
	this.simulation = s;
	setTitle("Control panel");
	
	Container contents = getContentPane();
	speedPanel = buildSpeedPanel();
	neighbourhoodPanel = buildNeighbourhoodPanel();
	
	contents.add(speedPanel, BorderLayout.NORTH);
	contents.add(neighbourhoodPanel, BorderLayout.SOUTH);
	pack();
	setVisible(true);
    }

    /**
     * @return 
     *        the panel for controlling simulation speed
     */
    private JPanel buildSpeedPanel() {
	JPanel panel = new JPanel();
	Border lowerEtched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
	panel.setBorder(BorderFactory.createTitledBorder(lowerEtched, "Simulation speed (ms/days)"));	
	speedSlider = new JSlider(JSlider.HORIZONTAL,
				  Simulation.MIN_SPEED_VALUE,
				  Simulation.MAX_SPEED_VALUE,
				  Simulation.MIN_SPEED_VALUE);
	speedSlider.setMajorTickSpacing(300);
	speedSlider.setMinorTickSpacing(10);
	speedSlider.setPaintTicks(true);
	speedSlider.setPaintLabels(true);
	
	speedSlider.addChangeListener(new ChangeListener() {
		public synchronized void stateChanged(ChangeEvent e) {
		    simulation.setDelay(speedSlider.getValue());
		}
	    });

	panel.add(speedSlider);
	return panel;
    }

    /**
     * @return 
     *        the panel for adjusting the neighbourhood computing
     */
    private JPanel buildNeighbourhoodPanel() {
	JPanel panel = new JPanel();
	Border lowerEtched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
	panel.setBorder(BorderFactory.createTitledBorder(lowerEtched, "Neighbourhood computing"));
	this.neighbourhoodRadioGroup = new ButtonGroup();
	JRadioButton neighbourhoodA = new JRadioButton("4-connected");
	neighbourhoodA.setActionCommand("4-connected");
	neighbourhoodA.addActionListener(new RadioNeighbourhoodListener());
	JRadioButton neighbourhoodB = new JRadioButton("8-connected");
	neighbourhoodB.setActionCommand("8-connected");
	neighbourhoodB.addActionListener(new RadioNeighbourhoodListener());
	neighbourhoodRadioGroup.add(neighbourhoodA);
	neighbourhoodRadioGroup.add(neighbourhoodB);
	neighbourhoodRadioGroup.setSelected(neighbourhoodA.getModel(), true);
	panel.add(neighbourhoodA);
	panel.add(neighbourhoodB);
	return panel;	
    }

    /**
     * A listener class for the radio buttons in the neighbourhood strategy panel
     */
    public class RadioNeighbourhoodListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
	    switch(neighbourhoodRadioGroup.getSelection().getActionCommand()) {
	    case "4-connected":
		simulation.setNeighbourHoodStrategy(new Neighbourhood4x4());
		break;
	    case "8-connected":
		simulation.setNeighbourHoodStrategy(new HeightConnectedNeighbourhood());
	    }
	}
    }
}

