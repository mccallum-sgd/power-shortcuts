package main;

import java.awt.Window;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import main.obj.Shortcut;

public class NativeKeyboardHook {
	static void register(Window win, List<Shortcut> shortcuts) {
		/*REGISTER*/
		try {
			Logger.getLogger(GlobalScreen.class.getPackage().getName()).setLevel(Level.OFF);
			GlobalScreen.registerNativeHook();
		}
		catch (NativeHookException | NullPointerException e) {
			System.err.println("There was a problem registering the native hook.");
			System.err.println(e.getMessage());
		}
		
		/*ADD*/
		GlobalScreen.addNativeKeyListener(new NativeKeyListener(){
			@Override
			public void nativeKeyPressed(NativeKeyEvent e) {
				if (e.getModifiers() == 4 && e.getKeyCode() == NativeKeyEvent.VC_Z) {
					win.setFocusable(true);
					win.setFocusableWindowState(true);
					win.setVisible(true);
					win.requestFocus();
				} else if (e.getKeyCode() == NativeKeyEvent.VC_ESCAPE)
					win.setVisible(false);
			}
			//UNIMPLEMENTED
			@Override public void nativeKeyTyped(NativeKeyEvent nativeEvent) {}
			@Override public void nativeKeyReleased(NativeKeyEvent nativeEvent) {}
		});
	}
}