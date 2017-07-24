package main.obj;
import java.nio.file.Path;

import javax.swing.JMenuItem;
import javax.swing.event.MenuKeyEvent;
import javax.swing.event.MenuKeyListener;

import main.Executor;

public class ShortcutItem extends JMenuItem {
	private String name;
	private Path path;
	private char keyChar;
	
	public ShortcutItem(String name, Path path, char keyChar) {
		super(name);
		this.name = name;
		this.path = path;
		this.keyChar = keyChar;
		addMenuKeyListener(new MenuKeyListener() {
			@Override
			public void menuKeyPressed(MenuKeyEvent e) {
				Executor.run(path);
			}
			@Override public void menuKeyTyped(MenuKeyEvent e) {}
			@Override public void menuKeyReleased(MenuKeyEvent e) {}
		});
	}
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public Path getPath() {return path;}
	public void setPath(Path path) {this.path = path;}
	public char getKeyChar() {return keyChar;}
	public void setKeyChar(char keyChar) {this.keyChar = keyChar;}
}