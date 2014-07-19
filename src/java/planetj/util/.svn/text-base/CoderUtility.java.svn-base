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
 *	Used for encoding/decoding objects
 */
public abstract class CoderUtility {
/**
 * PasswordEncoder constructor
 */
protected CoderUtility() {
	super();
}
/**
 *	Decodes an object
 */
public abstract Object decode (Object o) throws Exception;
/**
 *	Encodes an object
 */
public abstract Object encode (Object o) throws Exception;
/**
 *	Encodes an user id and password.  The encoded user id and password are
 *	returned in an encoded Object 
 */
public abstract Object encodeUserIdAndPassword (String userId, String password) throws Exception;
/**
 *	Returns a default instance of EncodeUtility
 */
public static CoderUtility getInstance () {
	return getInstance (null);
}
/**
 *	Returns an instance of EncodeUtility for the specified encoding scheme
 */
public static CoderUtility getInstance (Object encoding) {

	// right now there is only one encoding scheme
	return Base64Coder.singleton();
}
/**
 *	Gets the next x bits of an array of bytes
 *
 *	@param bytes The array of byte to extract bits from
 *	@param bitIndex The index of the bit within the byte array to begin with (leftmost = 0)
 *	@param bitCount The number of bits to return (should be 8 or less)
 *
 *	@return An integer of the specified length, containing the specified number of bits from the array.  The value
 *	is right padded with zeros if necessary
 */
static int getNextBits (final byte[] bytes, int bitIndex, final int bitCount) {

	int result = 0;
	int bit = 0;

	// get the current byte to work with
	int byteIndex = bitIndex / 8;	
	byte currentByte = bytes[byteIndex];

	// adjust the bitIndex so it becomes the index within the current byte
	bitIndex -= byteIndex * 8;

	for (int resultIndex = bitCount - 1; resultIndex >= 0; resultIndex--) {

		// grab the next bit
		bit = (currentByte & (0x80 >> bitIndex)) >> (7 - bitIndex);
		result |= (bit << resultIndex);

		if (bitIndex == 7) {
			// goto next byte
			
			if (byteIndex == bytes.length - 1) {
				// assume next byte is 0 if there are no more
				currentByte = 0;
			}

			else {
				currentByte = bytes[++byteIndex];
			}

			// reset bit index
			bitIndex = 0;
		}

		else {
			// goto next bit
			bitIndex++;
		}
	}
	return result;	
}

	
}
