package client.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

public class ClientMainView extends JFrame {

	public ClientMainView(AffectiveView affectiveView, ExpressiveView effectiveView, MenuBarView menuBarView) {
		setTitle("CLIENT VIEW");
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.addTab("Expressive", effectiveView);
		tabbedPane.addTab("Affective", affectiveView);
		tabbedPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new BorderLayout());
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1300, 700);
		centerGUI(this);
		setJMenuBar(menuBarView);
		add(tabbedPane, BorderLayout.CENTER);
		setResizable(true);
		setVisible(true);
	}

	/**
	 * centerGUI method setup the client window dimensions
	 * 
	 * @param frame
	 *            JFrame object on which attributes have to be setup
	 */
	private void centerGUI(JFrame frame) {
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int w = frame.getSize().width;
		int h = frame.getSize().height;
		int x = (d.width - w) / 2;
		int y = (d.height - h) / 2;
		frame.setLocation(x, y);
	}
}
