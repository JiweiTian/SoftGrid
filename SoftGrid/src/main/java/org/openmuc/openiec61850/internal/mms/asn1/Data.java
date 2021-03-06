/* Copyright (C) 2016 Advanced Digital Science Centre

        * This file is part of Soft-Grid.
        * For more information visit https://www.illinois.adsc.com.sg/cybersage/
        *
        * Soft-Grid is free software: you can redistribute it and/or modify
        * it under the terms of the GNU General Public License as published by
        * the Free Software Foundation, either version 3 of the License, or
        * (at your option) any later version.
        *
        * Soft-Grid is distributed in the hope that it will be useful,
        * but WITHOUT ANY WARRANTY; without even the implied warranty of
        * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
        * GNU General Public License for more details.
        *
        * You should have received a copy of the GNU General Public License
        * along with Soft-Grid.  If not, see <http://www.gnu.org/licenses/>.

        * @author Prageeth Mahendra Gunathilaka
*/
/**
 * This class file was automatically generated by jASN1 (http://www.openmuc.org)
 */

package org.openmuc.openiec61850.internal.mms.asn1;

import java.io.IOException;
import java.io.InputStream;

import org.openmuc.jasn1.ber.BerByteArrayOutputStream;
import org.openmuc.jasn1.ber.BerIdentifier;
import org.openmuc.jasn1.ber.types.BerBitString;
import org.openmuc.jasn1.ber.types.BerBoolean;
import org.openmuc.jasn1.ber.types.BerInteger;
import org.openmuc.jasn1.ber.types.BerOctetString;
import org.openmuc.jasn1.ber.types.string.BerUTF8String;
import org.openmuc.jasn1.ber.types.string.BerVisibleString;

public final class Data {

	public byte[] code = null;
	public DataSequence array = null;

	public DataSequence structure = null;

	public BerBoolean boolean_ = null;

	public BerBitString bit_string = null;

	public BerInteger integer = null;

	public BerInteger unsigned = null;

	public BerOctetString floating_point = null;

	public BerOctetString octet_string = null;

	public BerVisibleString visible_string = null;

	public BerOctetString binary_time = null;

	public BerUTF8String mms_string = null;

	public BerOctetString utc_time = null;

	public Data() {
	}

	public Data(byte[] code) {
		this.code = code;
	}

	public Data(DataSequence array, DataSequence structure, BerBoolean boolean_, BerBitString bit_string,
			BerInteger integer, BerInteger unsigned, BerOctetString floating_point, BerOctetString octet_string,
			BerVisibleString visible_string, BerOctetString binary_time, BerUTF8String mms_string,
			BerOctetString utc_time) {
		this.array = array;
		this.structure = structure;
		this.boolean_ = boolean_;
		this.bit_string = bit_string;
		this.integer = integer;
		this.unsigned = unsigned;
		this.floating_point = floating_point;
		this.octet_string = octet_string;
		this.visible_string = visible_string;
		this.binary_time = binary_time;
		this.mms_string = mms_string;
		this.utc_time = utc_time;
	}

	public int encode(BerByteArrayOutputStream berOStream, boolean explicit) throws IOException {
		if (code != null) {
			for (int i = code.length - 1; i >= 0; i--) {
				berOStream.write(code[i]);
			}
			return code.length;

		}
		int codeLength = 0;
		if (utc_time != null) {
			codeLength += utc_time.encode(berOStream, false);
			codeLength += (new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 17))
					.encode(berOStream);
			return codeLength;

		}

		if (mms_string != null) {
			codeLength += mms_string.encode(berOStream, false);
			codeLength += (new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 16))
					.encode(berOStream);
			return codeLength;

		}

		if (binary_time != null) {
			codeLength += binary_time.encode(berOStream, false);
			codeLength += (new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 12))
					.encode(berOStream);
			return codeLength;

		}

		if (visible_string != null) {
			codeLength += visible_string.encode(berOStream, false);
			codeLength += (new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 10))
					.encode(berOStream);
			return codeLength;

		}

		if (octet_string != null) {
			codeLength += octet_string.encode(berOStream, false);
			codeLength += (new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 9))
					.encode(berOStream);
			return codeLength;

		}

		if (floating_point != null) {
			codeLength += floating_point.encode(berOStream, false);
			codeLength += (new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 7))
					.encode(berOStream);
			return codeLength;

		}

		if (unsigned != null) {
			codeLength += unsigned.encode(berOStream, false);
			codeLength += (new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 6))
					.encode(berOStream);
			return codeLength;

		}

		if (integer != null) {
			codeLength += integer.encode(berOStream, false);
			codeLength += (new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 5))
					.encode(berOStream);
			return codeLength;

		}

		if (bit_string != null) {
			codeLength += bit_string.encode(berOStream, false);
			codeLength += (new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 4))
					.encode(berOStream);
			return codeLength;

		}

		if (boolean_ != null) {
			codeLength += boolean_.encode(berOStream, false);
			codeLength += (new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 3))
					.encode(berOStream);
			return codeLength;

		}

		if (structure != null) {
			codeLength += structure.encode(berOStream, false);
			codeLength += (new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 2))
					.encode(berOStream);
			return codeLength;

		}

		if (array != null) {
			codeLength += array.encode(berOStream, false);
			codeLength += (new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 1))
					.encode(berOStream);
			return codeLength;

		}

		throw new IOException("Error encoding BerChoice: No item in choice was selected.");
	}

	public int decode(InputStream iStream, BerIdentifier berIdentifier) throws IOException {
		int codeLength = 0;
		BerIdentifier passedIdentifier = berIdentifier;
		if (berIdentifier == null) {
			berIdentifier = new BerIdentifier();
			codeLength += berIdentifier.decode(iStream);
		}
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 1)) {
			array = new DataSequence();
			codeLength += array.decode(iStream, false);
			return codeLength;
		}

		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 2)) {
			structure = new DataSequence();
			codeLength += structure.decode(iStream, false);
			return codeLength;
		}

		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 3)) {
			boolean_ = new BerBoolean();
			codeLength += boolean_.decode(iStream, false);
			return codeLength;
		}

		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 4)) {
			bit_string = new BerBitString();
			codeLength += bit_string.decode(iStream, false);
			return codeLength;
		}

		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 5)) {
			integer = new BerInteger();
			codeLength += integer.decode(iStream, false);
			return codeLength;
		}

		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 6)) {
			unsigned = new BerInteger();
			codeLength += unsigned.decode(iStream, false);
			return codeLength;
		}

		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 7)) {
			floating_point = new BerOctetString();
			codeLength += floating_point.decode(iStream, false);
			return codeLength;
		}

		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 9)) {
			octet_string = new BerOctetString();
			codeLength += octet_string.decode(iStream, false);
			return codeLength;
		}

		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 10)) {
			visible_string = new BerVisibleString();
			codeLength += visible_string.decode(iStream, false);
			return codeLength;
		}

		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 12)) {
			binary_time = new BerOctetString();
			codeLength += binary_time.decode(iStream, false);
			return codeLength;
		}

		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 16)) {
			mms_string = new BerUTF8String();
			codeLength += mms_string.decode(iStream, false);
			return codeLength;
		}

		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 17)) {
			utc_time = new BerOctetString();
			codeLength += utc_time.decode(iStream, false);
			return codeLength;
		}

		if (passedIdentifier != null) {
			return 0;
		}
		throw new IOException("Error decoding BerChoice: Identifier matched to no item.");
	}

	public void encodeAndSave(int encodingSizeGuess) throws IOException {
		BerByteArrayOutputStream berOStream = new BerByteArrayOutputStream(encodingSizeGuess);
		encode(berOStream, false);
		code = berOStream.getArray();
	}
}
