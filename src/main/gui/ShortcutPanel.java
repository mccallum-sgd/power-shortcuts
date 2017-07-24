package main.gui;

import java.util.List;

import javax.swing.JPanel;

import main.obj.Shortcut;

public class ShortcutPanel extends JPanel {
	
	public ShortcutPanel (List<Shortcut> shortcuts) {
		if (shortcuts != null)
			shortcuts.forEach(a -> add(a));
	}
}