package client.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import client.constants.ClientConstants;
import client.controller.ClientServerConnectionService;
import client.model.MenuBarModel;

public class MenuBarView extends JMenuBar {
	private JMenu menu;
	private JMenuItem launchServer;
	private JMenuItem connect;
	private JMenuItem reconnect;
	private JMenuItem stopWatch;
	private JMenuItem connectionLabel;
	private BufferedImage greenIcon, redIcon;
	ClientServerConnectionService clientServerConnectionService;

	public MenuBarView(MenuBarModel menuBarModel) {
		clientServerConnectionService = new ClientServerConnectionService();
		menu = new JMenu(ClientConstants.MENU);
		Border blackBorder = BorderFactory.createMatteBorder(5, 5, 5, 5, Color.LIGHT_GRAY);
		BufferedImage stopImage, redImage, greenImage;
		BufferedImage resizeStopImg = null;
		greenIcon = null;
		redIcon = null;
		try {
			InputStream inputStream1 = getClass().getClassLoader().getResourceAsStream(ClientConstants.CONNECTED_IMAGE);
			InputStream inputStream2 = getClass().getClassLoader()
					.getResourceAsStream(ClientConstants.NOT_CONNECTED_IMAGE);
			InputStream inputStream3 = getClass().getClassLoader()
					.getResourceAsStream(ClientConstants.STOP_WATCH_IMAGE);
			if (inputStream1 != null && inputStream2 != null && inputStream3 != null) {
				redImage = ImageIO.read(inputStream1);
				greenImage = ImageIO.read(inputStream2);
				stopImage = ImageIO.read(inputStream3);
				resizeStopImg = new BufferedImage(30, 30, BufferedImage.TYPE_INT_ARGB);
				redIcon = new BufferedImage(30, 30, BufferedImage.TYPE_INT_ARGB);
				greenIcon = new BufferedImage(30, 25, BufferedImage.TYPE_INT_ARGB);
				Graphics2D g3 = setGraphics(resizeStopImg, stopImage);
				Graphics2D g4 = setGraphics(redIcon, redImage);
				Graphics2D g5 = setGraphics(greenIcon, greenImage);
			}

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, ClientConstants.IMAGE_PATH_EXCEPTION_MESSAGE + "Hello");
		}
		menu.setHorizontalTextPosition(SwingConstants.CENTER);
		menu.setVerticalTextPosition(SwingConstants.BOTTOM);
		menu.setFont(ClientConstants.TEXT_FONT);
		menu.setBackground(Color.LIGHT_GRAY);
		launchServer = new JMenuItem(ClientConstants.LAUNCH_SERVER);
		setForegroundBackground(launchServer, blackBorder, ClientConstants.TEXT_FONT);
		JMenu connectMenu = new JMenu(ClientConstants.CONNECT);
		setForegroundBackground(connectMenu, blackBorder, ClientConstants.TEXT_FONT);
		connect = new JMenuItem(ClientConstants.CONNECT);
		reconnect = new JMenuItem(ClientConstants.RECONNECT);
		setForegroundBackground(connect, blackBorder, ClientConstants.TEXT_FONT);
		setForegroundBackground(reconnect, blackBorder, ClientConstants.TEXT_FONT);
		connectMenu.add(connect);
		connectMenu.add(new JPopupMenu.Separator());
		connectMenu.add(reconnect);
		stopWatch = new JMenuItem(ClientConstants.STOP_WATCH, new ImageIcon(resizeStopImg));
		connectionLabel = new JMenuItem();
		connectState(false);
		menu.add(launchServer);
		menu.add(new JPopupMenu.Separator());
		menu.add(connectMenu);
		setForegroundBackground(menu, blackBorder, ClientConstants.TEXT_FONT);
		add(menu);
		setForegroundBackground(stopWatch, ClientConstants.TEXT_FONT);
		add(stopWatch);
		setForegroundBackground(connectionLabel, ClientConstants.TEXT_FONT);
		add(connectionLabel);

	}

	public void addConnectionListener(ActionListener connectListener) {
		connect.addActionListener(connectListener);
		launchServer.addActionListener(connectListener);
	}

	/**
	 * connectState method changes the label and icon on menubar.
	 *
	 * @param flag
	 *            : boolean connected or not connected flag
	 */
	public void connectState(boolean flag) {
		if (flag) {
			connectionLabel.setIcon(new ImageIcon(greenIcon));
			connectionLabel.setText(ClientConstants.CONNECTED);
		} else {
			connectionLabel.setIcon(new ImageIcon(redIcon));
			connectionLabel.setText(ClientConstants.NOT_CONNECTED);
		}
	}

	/**
	 * setForegroundBackground method customizes appearance of items in menubar.
	 * 
	 * @param item
	 *            : Menu item to be configured
	 * @param blackBorder
	 *            : border to set
	 * @param font
	 *            : to set font of menu item
	 */
	public void setForegroundBackground(JMenu item, Border blackBorder, Font font) {
		item.setBackground(Color.LIGHT_GRAY);
		item.setForeground(Color.BLACK);
		item.setFont(font);
		item.setBorder(blackBorder);
		item.setOpaque(true);
	}

	/**
	 * setForegroundBackground method customizes appearance of items in menubar.
	 * 
	 * @param item
	 *            : Menu item to be configured
	 * @param blackBorder
	 *            : border to set
	 * @param font
	 *            : to set font of menu item
	 */
	public void setForegroundBackground(JMenuItem item, Border blackBorder, Font font) {
		item.setBackground(Color.LIGHT_GRAY);
		item.setForeground(Color.BLACK);
		item.setBorder(blackBorder);
		item.setFont(font);
		item.setOpaque(true);
	}

	/**
	 * setForegroundBackground method customizes appearance of items in menubar.
	 *
	 * @param item
	 *            : Menu item to be configured
	 * @param font
	 *            : to set font of menu item
	 */
	public void setForegroundBackground(JMenuItem item, Font font) {
		item.setBackground(Color.LIGHT_GRAY);
		item.setForeground(Color.BLACK);
		item.setFont(font);
		item.setOpaque(true);
	}

	/**
	 * setGraphics method creates a rendered image
	 * 
	 * @param resizeImg
	 *            : resized BufferedImage to be drawn on GUI
	 * @param menuImage
	 *            : original BufferedImage which is to be drawn on
	 * @return : Graphics2D object for reference
	 */
	public Graphics2D setGraphics(BufferedImage resizeImg, BufferedImage menuImage) {
		Graphics2D g2 = resizeImg.createGraphics();
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(menuImage, 0, 0, 30, 24, null);
		g2.dispose();
		return g2;
	}

	/**
	 * actionPerformed method handles the on click event from menu.
	 *
	 * @param e
	 *            : ActionEvent performed on MenuBar
	 */

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == launchServer) {
			try {
				clientServerConnectionService.initializeServer();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (e.getSource() == connect) {
			if (clientServerConnectionService != null) {
				launchDialogBox();
			}
		} else if (e.getSource() == reconnect) {

			// clientServerConnectionService.reconnectServer(null);
		}
	}

	/**
	 * launchDialogBox method provides a dialogue box for IP and port user inputs
	 */
	private void launchDialogBox() {
		JTextField ipField = new JTextField(15);
		JTextField ipPort = new JTextField(15);
		ipField.setText(ClientConstants.LOCALHOST);
		ipPort.setText(ClientConstants.PORT_NUMBER);
		JPanel myPanel = new JPanel();
		myPanel.add(new JLabel(ClientConstants.IP_STRING));
		myPanel.add(ipField);
		myPanel.add(Box.createHorizontalStrut(15));
		myPanel.add(new JLabel(ClientConstants.PORT_STRING));
		myPanel.add(ipPort);
		int result = JOptionPane.showConfirmDialog(null, myPanel, ClientConstants.ENTER_IP,
				JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION) {
			clientServerConnectionService.startServer("0.0.0.0", "8081");
		}
	}

	/**
	 * updateTimeValue method updates stop watch timer on menubar.
	 * 
	 * @param time
	 *            : stop watch time to update
	 */
	public void updateTimeValue(double time) {
		stopWatch.setOpaque(true);
		stopWatch.setText(String.valueOf(time));
		setForegroundBackground(stopWatch, ClientConstants.TEXT_FONT);
	}

	public void setConnectionLabel(boolean flag) {
		connectState(flag);
	}

}
