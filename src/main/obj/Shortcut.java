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
	
	public void keyPress (char keyChar) {
		if (this.keyChar == keyChar)
			System.out.println("keyPress:" + keyChar);
	}
	
	public String toString() {
		return "Name: " + name + "\n" + 
				"Path: " + path.toString() + "\n" +  
				"Key: " + Character.toString(keyChar);
	}
}