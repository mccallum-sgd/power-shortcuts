package main;

import java.awt.SystemTray;
import java.util.Arrays;
import java.util.List;

import javax.swing.SwingUtilities;

import main.gui.ShortcutDialog;
import main.obj.Shortcut;

public class Driver {
	public static void main (String args[]) {
		SwingUtilities.invokeLater(() -> {
			init(Parser.parseShortcutsXML("shortcuts.xml"));
		});
	}
	
	private static final int HEIGHT = 582, WIDTH = 262;
	private static ShortcutDialog dialog;
	
	private static void init (List<Shortcut> shortcuts) {
		dialog = new ShortcutDialog(WIDTH, HEIGHT, shortcuts);
		NativeKeyboardHook.register(dialog, shortcuts);
		removeTrayIcon();
	}
	
	private static void removeTrayIcon () {
		Arrays.asList(SystemTray.getSystemTray().getTrayIcons())
						.forEach(e -> SystemTray.getSystemTray().remove(e));
	}
}
