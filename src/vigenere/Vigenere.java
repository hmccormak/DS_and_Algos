package vigenere;

public class Vigenere {
	protected char[][] square = new char[26][26];
	String msg, key;
	
	public Vigenere(String msg, String key) {
		this.msg = msg.toUpperCase();
		this.key = key.toUpperCase();
		for (int i=0; i<26; i++) {
			char start = (char) ('A' + i);
			for (int j=0; j<26; j++) {
				if ((int) start + j > 90) {
					square[i][j] = (char) (start + j - 26);
				} else {
					square[i][j] = (char) (start + j);
				}
			}
		}
	}
	
	
	public void getSquare() {
		for (int i=0; i<26; i++) {
			for (int j=0; j<26; j++) {
				System.out.print(square[i][j]);
			}
			System.out.print('\n');
		}
	}
	
	public static void main(String[] args) throws Exception {
		Vigenere vig = new Vigenere("test", "key");
		vig.getSquare();
	}
}
