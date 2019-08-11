package _05_Enum_Stuff;

import javax.swing.JOptionPane;

public class _00_Horoscope {
	// 1. Create an enum in a separate file called Zodiac that contains a category
	// for
	// all 12 zodiac signs.

	// 2. Write a method that takes in a Zodiac enum object and uses a JOPtionPane
	// to display
	// a different horoscope based on the Zodiac's state.
	public static void horoscope(Zodiac z) {
		switch (z) {
		case AQUARIUS: {
			JOptionPane.showMessageDialog(null, "a");
			break;
		}
		case ARIES: {
			JOptionPane.showMessageDialog(null, "b");
			break;
		}
		case SCORPIO: {
			JOptionPane.showMessageDialog(null, "c");
			break;
		}
		
		}
	}

	// 3. Make a main method to test your method
	public static void main(String[] args) {
		horoscope(Zodiac.ARIES);
	}
}
