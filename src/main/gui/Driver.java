package main.gui;

//import com.sun.jna.Native;

import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import main.Parser;
import main.obj.ShortcutItem;

public class Driver {
	public static void main (String args[]) {
		SwingUtilities.invokeLater(() -> {
			init("Power Shortcuts", Parser.parseShortcutsXML("shortcuts.xml"));
		});
	}
	
	private static final int HEIGHT = 582, WIDTH = 262;
	private static JFrame frame;
	private static ShortcutPanel panel;
	
	private static void init (String name, List<ShortcutItem> shortcuts) {
		/*CREATE*/
		frame = new JFrame(name);
		panel = new ShortcutPanel(shortcuts);
		/*MODIFY/ADD*/
		panel.setFocusable(true);
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setSize(WIDTH, HEIGHT);
		frame.setLocation(0, Toolkit.getDefaultToolkit().getScreenSize().height-(HEIGHT+2));
		frame.setVisible(false);
		frame.setResizable(false);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowDeactivated(WindowEvent e) {
				frame.setVisible(false);
			}
		});
		try {
			GlobalScreen.registerNativeHook();
		}
		catch (NativeHookException ex) {
			System.err.println("There was a problem registering the native hook.");
			System.err.println(ex.getMessage());
		}

		GlobalScreen.addNativeKeyListener(new GlobalKeyListener());
	}
	
	private void removeTrayIcon () {
		Arrays.asList(SystemTray.getSystemTray().getTrayIcons()).forEach(e -> SystemTray.getSystemTray().remove(e));
	}
	
	private static class GlobalKeyListener implements NativeKeyListener {

		@Override
		public void nativeKeyPressed(NativeKeyEvent e) {
			if (e.getModifiers() == 4 && e.getKeyCode() == NativeKeyEvent.VC_Z) {
				frame.setVisible(true);
			} else if (e.getKeyCode() == NativeKeyEvent.VC_ESCAPE) {
				frame.setVisible(false);
			}
		}

		//UNIMPLEMENTED
		@Override public void nativeKeyTyped(NativeKeyEvent nativeEvent) {}
		@Override public void nativeKeyReleased(NativeKeyEvent nativeEvent) {}
	}
}
