package vigenere;

public class Vigenere {
	protected char[][] square = new char[26][26];
	protected String msg, key;
	
	public Vigenere() {
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
	
	public void setMsgAndKey(String inMsg, String inKey) {
		this.msg = inMsg.toUpperCase();
		inKey = inKey.toUpperCase();
		
		StringBuilder tempKey = new StringBuilder();
		
		for (int i=0; i<inMsg.length(); i++) {
			tempKey.append(inKey.charAt(i % inKey.length()));
		}
		this.key = tempKey.toString();
	}

	
	public void getSquare() {
		for (int i=0; i<26; i++) {
			for (int j=0; j<26; j++) {
				System.out.print(square[i][j]);
			}
			System.out.print('\n');
		}
	}
	
	public void encode() {
		int x = 0;
		int y = 0;
		StringBuilder builder = new StringBuilder();
		
		// row of the key char and column of the msg char
		for (int i=0; i<this.msg.length(); i++) {
			char keyChar = this.key.charAt(i);
			char msgChar = this.msg.charAt(i);
			for (int j=0; j<square.length; j++) {
				if (square[j][0] == keyChar) {
					x = j;
					break;
				}
			}
			for (int k=0; k<square.length; k++) {
				if (square[0][k] == msgChar) {
					y = k;
					break;
				}
			}
			builder.append(square[x][y]);
		}
		System.out.println(builder.toString());
	}
	
	public static void main(String[] args) throws Exception {
		Vigenere vig = new Vigenere();
		vig.getSquare();
		vig.setMsgAndKey("meetatthesecretspot", "lalilulelo");
		vig.encode();
	}
}
