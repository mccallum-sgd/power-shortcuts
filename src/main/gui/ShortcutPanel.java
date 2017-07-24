package main.gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import main.obj.ShortcutItem;

public class ShortcutPanel extends JPanel {
	List<ShortcutItem> shortcuts;
	
	public ShortcutPanel (List<ShortcutItem> shortcuts) {
		shortcuts = 
				(shortcuts == null) ? 
					new ArrayList<ShortcutItem>():
				new ArrayList<ShortcutItem>(shortcuts);
		
	}
	
	public void addAll(List<ShortcutItem> shortcuts) {
		shortcuts.addAll(shortcuts);
	}
	
	public void add(ShortcutItem item) {
		shortcuts.add(item);
	}
}