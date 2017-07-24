package main;

import java.nio.file.Path;

import javax.swing.JOptionPane;

public class Executor {
	public static void run (Path path) {
		try
		{
		    Process p = Runtime.getRuntime().exec("S:/Program Files/Notepad++/notepad++.exe");
		}
		catch(Exception e)
		{
		    JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
}