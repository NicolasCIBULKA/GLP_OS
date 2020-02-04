package test;

import java.util.HashMap;

import data.*;

public class Test {

	public static void main(String[] args) {
		String idkeyboard = "kb";
		Interaction per = new Interaction();
		Keyboard kb = new Keyboard("kb_1");
		KeyboardDriver kbd = new KeyboardDriver("kbd_1", per, idkeyboard);
		String s;
		for(int i = 0; i<5 ; i++ ) {
			kb.keyinput("33");
		}
		System.out.println(kb.toString());
		 
		s = kb.toString();
		 
		System.out.println(kbd.translate(s));
	}

}
