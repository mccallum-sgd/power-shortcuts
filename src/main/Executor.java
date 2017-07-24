package main;

import java.nio.file.Path;

import javax.swing.JOptionPane;

public class Executor {
	public static void run (Path path) {
		try
		{
		    Runtime.getRuntime().exec(path.toString());
		}
		catch(Exception e)
		{
		    JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
}