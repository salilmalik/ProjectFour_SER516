package client.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import client.controller.AffectiveContoller;

public class AffectiveView extends JPanel {

	public AffectiveView(AffectiveColorView affectiveColorView, AffectiveGraphView affectiveGraphView) {
		setLayout(new BorderLayout());
		setBackground(Color.BLUE);
		add(affectiveGraphView, BorderLayout.CENTER);
		add(affectiveColorView, BorderLayout.EAST);

	}

}
