package main.gui;

import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JDialog;

import main.obj.Shortcut;

public class ShortcutDialog extends JDialog {
	
	public ShortcutDialog (int WIDTH, int HEIGHT, List<Shortcut> shortcuts) {
		setFocusable(true);
		setUndecorated(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		if (shortcuts != null)
			shortcuts.forEach(a -> getContentPane().add(a));
		pack();
		setSize(WIDTH, HEIGHT);
		setLocation(0, Toolkit.getDefaultToolkit().getScreenSize().height-(HEIGHT+2));
		setVisible(false);
		setFocusable(true);
		setAlwaysOnTop(true);
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowDeactivated(WindowEvent e) {
				setVisible(false);
			}
		});
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed (KeyEvent e) {
				shortcuts.forEach(a -> a.keyPress(e.getKeyChar()));
			}
		});
	}
}