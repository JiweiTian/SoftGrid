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

package org.openmuc.josistack.internal.acse.asn1;

import java.io.IOException;
import java.io.InputStream;

import org.openmuc.jasn1.ber.BerByteArrayOutputStream;
import org.openmuc.jasn1.ber.BerIdentifier;

public final class ACSE_apdu {

	public byte[] code = null;
	public AARQ_apdu aarq = null;

	public AARE_apdu aare = null;

	public RLRQ_apdu rlrq = null;

	public RLRE_apdu rlre = null;

	public ACSE_apdu() {
	}

	public ACSE_apdu(byte[] code) {
		this.code = code;
	}

	public ACSE_apdu(AARQ_apdu aarq, AARE_apdu aare, RLRQ_apdu rlrq, RLRE_apdu rlre) {
		this.aarq = aarq;
		this.aare = aare;
		this.rlrq = rlrq;
		this.rlre = rlre;
	}

	public int encode(BerByteArrayOutputStream berOStream, boolean explicit) throws IOException {
		if (code != null) {
			for (int i = code.length - 1; i >= 0; i--) {
				berOStream.write(code[i]);
			}
			return code.length;

		}
		int codeLength = 0;
		if (rlre != null) {
			codeLength += rlre.encode(berOStream, true);
			return codeLength;

		}

		if (rlrq != null) {
			codeLength += rlrq.encode(berOStream, true);
			return codeLength;

		}

		if (aare != null) {
			codeLength += aare.encode(berOStream, true);
			return codeLength;

		}

		if (aarq != null) {
			codeLength += aarq.encode(berOStream, true);
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
		if (berIdentifier.equals(AARQ_apdu.identifier)) {
			aarq = new AARQ_apdu();
			codeLength += aarq.decode(iStream, false);
			return codeLength;
		}

		if (berIdentifier.equals(AARE_apdu.identifier)) {
			aare = new AARE_apdu();
			codeLength += aare.decode(iStream, false);
			return codeLength;
		}

		if (berIdentifier.equals(RLRQ_apdu.identifier)) {
			rlrq = new RLRQ_apdu();
			codeLength += rlrq.decode(iStream, false);
			return codeLength;
		}

		if (berIdentifier.equals(RLRE_apdu.identifier)) {
			rlre = new RLRE_apdu();
			codeLength += rlre.decode(iStream, false);
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
