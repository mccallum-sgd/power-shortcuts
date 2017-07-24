package main.obj;
import java.nio.file.Path;

import javax.swing.JButton;

import main.Executor;

public class Shortcut extends JButton {
	private String name;
	private Path path;
	private char keyChar;
	
	public Shortcut(String name, Path path, char keyChar) {
		super(name);
		this.name = name;
		this.path = path;
		this.keyChar = keyChar;
		addActionListener(a -> {
			Executor.run(path);
		});
	}
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public Path getPath() {return path;}
	public void setPath(Path path) {this.path = path;}
	public char getKeyChar() {return keyChar;}
	public void setKeyChar(char keyChar) {this.keyChar = keyChar;}
	
	public String toString() {
		return "Name: " + name + "\n" + 
				"Path: " + path.toString() + "\n" +  
				"Key: " + Character.toString(keyChar);
	}
}