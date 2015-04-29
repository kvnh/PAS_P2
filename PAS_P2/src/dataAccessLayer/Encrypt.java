package dataAccessLayer;


/**
 * This class resides between LoginBAL class in the businessLayer and LoginDA in
 * the DataAccess Layer
 * 
 * It takes an unencrypted password and username and encrypts the password only
 * that is passed to LoginDA The LoginDA method will only validate against an
 * encrypted password stored in the database. Therefore anybody accessing
 * database by utility etc will only see an encrypted password.
 * 
 * @author Andrew Walmsley
 *
 */

public class Encrypt {

	/**
	 * Default constructor
	 * TextField usernameBox, 
	 */

	public Encrypt() {

	}

	/**
	 * Encode or encrypts a given string
	 * 
	 * @param original
	 * @param key
	 *            1- 10
	 * @return
	 */
	public static String encode(String original) {
		int key = 4;
		char ch;
		String encryptedText = "";

		for (int loop = 0; loop < original.length(); loop++) {
			// obtain next character to be encrypted
			ch = original.charAt(loop);

			// apply the key to encrypt
			ch = (char) (ch + key);

			// append encrypted character to end of string
			encryptedText += ch;
		}
		return encryptedText;
	}

	/**
	 * Decode or decrypts a given string
	 * 
	 * @param original
	 * @param key
	 *            1 - 10
	 * @return
	 */
	public static String decode(String original, int key) {

		char ch;
		String encryptedText = "";

		for (int loop = 0; loop < original.length(); loop++) {
			// obtain next character to be encrypted
			ch = original.charAt(loop);

			ch = (char) (ch - key);

			// append decrypted character to end of string
			encryptedText += ch;
		}

		return encryptedText;

	}

	/**
	 * Tester class
	 * 
	 * password = teww{svh
	 * nursepass = ryvwiteww
	 * doctorpass = hsgxsvteww
	 */
	public static void main(String[] args) {
		
	//	TextField = 
		
		

		System.out.println(encode("doctorpass"));
		System.out.println(decode("ryvwiteww", 4));

//		// code breaker
//		for (int loop = 1; loop < 10; loop++) {
//			System.out
//					.println("Attempt with key : "
//							+ loop
//							+ " : "
//							+ decode(
//									"Fi$xli$jmvwx$xs$iqemp$qi$xli${svhw$Iewxiv$Ikk$erh${mr$e$tvm~i2$[mrriv$errsyrgih$ex$xli$ri|x$pigxyvi",
//									loop));
//		}
	}
}
