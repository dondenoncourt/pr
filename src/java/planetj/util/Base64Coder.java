package planetj.util;

/*
 *===========================================================================
 * Licensed Materials - Property of PlanetJ Corporation
 * PlanetJ Core Classes
 *
 * (C) Copyright PlanetJ Corporation 2003 All Rights Reserved.
 * ===========================================================================
 */

/**
 *	Encodes/decodes using the base64 alogrithm
 */
class Base64Coder extends CoderUtility {
	
	protected static char[] enc64 = new char[64];
	protected static int[] dec64 = new int[123];
	static {
		initDec64();
		initEnc64();
	}
	public static Base64Coder cSingleton = new Base64Coder();
/**
 * Base64Coder constructor
 */
protected Base64Coder() {
	super();
}
/**
 *	Decodes an object
 */
public Object decode(Object o) throws Exception {
	if (! (o instanceof String)) {
		throw new Exception ("This decoder can only decode String values");
	}
	return decodeBase64 ((String) o);
}
/**
 *	Decodes four chars of base64 encoding into three chars
 */
protected void decode4Chars (char[] source, int sourceOffset, char[] destination, int destinationOffset) {

	// use local var for better performance
	int[] decode = dec64;
	int completeValue = 0;
	final int mask = 0x00FF0000;

	// built a single int from the 4 chars
	for (int i = 0; i < 4; i++) {
		completeValue |= decode[source[(int) (i + sourceOffset)]] << (18 - 6 * i);
	}

	// break the int into chars
	for (int j = 0; j < 3; j++) {
		int j8 = j * 8;
		destination[j + destinationOffset] = (char) ((completeValue & (mask >> j8)) >> (16 - j8));
	}
}
/**
 *	Decodes a String base64 encoded String of characters as described at http://www.freesoft.org/CIE/RFC/1521/7.htm
 */
protected Object decodeBase64 (String s) throws Exception {

	int length = s.length();
	if (length == 0)
		return s;
	if (length % 4 != 0)
		throw new Exception ("Can't decode \"" + s + "\" because the number of characters it contains is not a multiple of 4");


	// create char arrays
	char[] source = s.toCharArray();
	int resultLength = 3 * length / 4;
	char[] destination = new char[resultLength];

	int j = 0;

	// do the decoding
	for (int i = 0; i < length; i+=4) {
		decode4Chars (source, i, destination, j);
		j += 3;
	}

	// eliminate padding chars
	if (source[length - 1] == '=')
		resultLength--;

	if (source[length - 2] == '=')
		resultLength--;

	return new String (destination, 0, resultLength);	
}

/**
 *	Encodes an object
 */
public Object encode (Object o) throws Exception {
	if (!( (o instanceof String) || (o instanceof byte[]))) {
		throw new Exception ("This encoder can only encode String and byte array values");
	}
	if (o instanceof String) {
		return encodeBase64 ((String) o);
	}
	
	return encodeBase64((byte[]) o);
}
/**
 *	Encodes a String into a base64 String of characters as described at http://www.freesoft.org/CIE/RFC/1521/7.htm
 */
private String encodeBase64 (String s) {
	if (s == null)
		return null;

	return encodeBase64 (s.getBytes());

}
/**
 *	Encodes an array of bytes into a base64 String of characters as described at http://www.freesoft.org/CIE/RFC/1521/7.htm
 */
private String encodeBase64 (byte[] bytesIn) {
	// use local var for better performance
	char[] enc = enc64;
		
	int bitCount = bytesIn.length * 8;

	// figure out how many chars out there will be
	int charsOut = (int) Math.ceil (bitCount / 6.0);

	// there might be padding chars requried
	int paddingCount = (3 - ((bitCount % 24) / 8)) % 3;
	charsOut += paddingCount;

	char[] result = new char[charsOut];

	// fill in padding chars with '='.  There may be 0, 1, or 2 padding chars required
	if (paddingCount > 0) {

		result[charsOut - 1] = '=';

		if (paddingCount == 2) {
			result[charsOut - 2] = '=';
		}
	}

	// translate the bits into chars
	int i = 0;
	for (int i6 = 0; i6 < bitCount; i6+=6) {
		result[i++] = enc[getNextBits (bytesIn, i6, 6)];
	}	

	return new String(result);
}

	
/**
 *	Encodes an user id and password.  The encoded user id and password are
 *	returned in an encoded Object 
 */
public Object encodeUserIdAndPassword (String userId, String password) throws Exception {
	if (userId == null || password == null) {
		throw new Exception ("Cannot encode a null userid or password");
	}

	if (userId.indexOf (':') > 0)
		throw new Exception ("The userid cannot contain a colon");
	
	return encode (userId + ":" + password);
}
/**
 *	Initializes the char array for base64 decoding
 */
private static final void initDec64() {
	dec64[(int) '='] = 0;
	dec64[(int) 'A'] = 0;
	dec64[(int) 'B'] = 1;
	dec64[(int) 'C'] = 2;
	dec64[(int) 'D'] = 3;
	dec64[(int) 'E'] = 4;
	dec64[(int) 'F'] = 5;
	dec64[(int) 'G'] = 6;
	dec64[(int) 'H'] = 7;
	dec64[(int) 'I'] = 8;
	dec64[(int) 'J'] = 9;
	dec64[(int) 'K'] = 10;
	dec64[(int) 'L'] = 11;
	dec64[(int) 'M'] = 12;
	dec64[(int) 'N'] = 13;
	dec64[(int) 'O'] = 14;
	dec64[(int) 'P'] = 15;
	dec64[(int) 'Q'] = 16;
	dec64[(int) 'R'] = 17;
	dec64[(int) 'S'] = 18;
	dec64[(int) 'T'] = 19;
	dec64[(int) 'U'] = 20;
	dec64[(int) 'V'] = 21;
	dec64[(int) 'W'] = 22;
	dec64[(int) 'X'] = 23;
	dec64[(int) 'Y'] = 24;
	dec64[(int) 'Z'] = 25;
	dec64[(int) 'a'] = 26;
	dec64[(int) 'b'] = 27;
	dec64[(int) 'c'] = 28;
	dec64[(int) 'd'] = 29;
	dec64[(int) 'e'] = 30;
	dec64[(int) 'f'] = 31;
	dec64[(int) 'g'] = 32;
	dec64[(int) 'h'] = 33;
	dec64[(int) 'i'] = 34;
	dec64[(int) 'j'] = 35;
	dec64[(int) 'k'] = 36;
	dec64[(int) 'l'] = 37;
	dec64[(int) 'm'] = 38;
	dec64[(int) 'n'] = 39;
	dec64[(int) 'o'] = 40;
	dec64[(int) 'p'] = 41;
	dec64[(int) 'q'] = 42;
	dec64[(int) 'r'] = 43;
	dec64[(int) 's'] = 44;
	dec64[(int) 't'] = 45;
	dec64[(int) 'u'] = 46;
	dec64[(int) 'v'] = 47;
	dec64[(int) 'w'] = 48;
	dec64[(int) 'x'] = 49;
	dec64[(int) 'y'] = 50;
	dec64[(int) 'z'] = 51;
	dec64[(int) '0'] = 52;
	dec64[(int) '1'] = 53;
	dec64[(int) '2'] = 54;
	dec64[(int) '3'] = 55;
	dec64[(int) '4'] = 56;
	dec64[(int) '5'] = 57;
	dec64[(int) '6'] = 58;
	dec64[(int) '7'] = 59;
	dec64[(int) '8'] = 60;
	dec64[(int) '9'] = 61;
	dec64[(int) '+'] = 62;
	dec64[(int) '/'] = 63;
}
/**
 *	Initializes the char array for base64 encoding
 */
private static final void initEnc64() {
	enc64[0] = 'A';
	enc64[1] = 'B';
	enc64[2] = 'C';
	enc64[3] = 'D';
	enc64[4] = 'E';
	enc64[5] = 'F';
	enc64[6] = 'G';
	enc64[7] = 'H';
	enc64[8] = 'I';
	enc64[9] = 'J';
	enc64[10] = 'K';
	enc64[11] = 'L';
	enc64[12] = 'M';
	enc64[13] = 'N';
	enc64[14] = 'O';
	enc64[15] = 'P';
	enc64[16] = 'Q';
	enc64[17] = 'R';
	enc64[18] = 'S';
	enc64[19] = 'T';
	enc64[20] = 'U';
	enc64[21] = 'V';
	enc64[22] = 'W';
	enc64[23] = 'X';
	enc64[24] = 'Y';
	enc64[25] = 'Z';
	enc64[26] = 'a';
	enc64[27] = 'b';
	enc64[28] = 'c';
	enc64[29] = 'd';
	enc64[30] = 'e';
	enc64[31] = 'f';
	enc64[32] = 'g';
	enc64[33] = 'h';
	enc64[34] = 'i';
	enc64[35] = 'j';
	enc64[36] = 'k';
	enc64[37] = 'l';
	enc64[38] = 'm';
	enc64[39] = 'n';
	enc64[40] = 'o';
	enc64[41] = 'p';
	enc64[42] = 'q';
	enc64[43] = 'r';
	enc64[44] = 's';
	enc64[45] = 't';
	enc64[46] = 'u';
	enc64[47] = 'v';
	enc64[48] = 'w';
	enc64[49] = 'x';
	enc64[50] = 'y';
	enc64[51] = 'z';
	enc64[52] = '0';
	enc64[53] = '1';
	enc64[54] = '2';
	enc64[55] = '3';
	enc64[56] = '4';
	enc64[57] = '5';
	enc64[58] = '6';
	enc64[59] = '7';
	enc64[60] = '8';
	enc64[61] = '9';
	enc64[62] = '+';
	enc64[63] = '/';
}
/**
 *	Gets the singleton instance
 */
static final Base64Coder singleton() {
	return cSingleton;
}
}
