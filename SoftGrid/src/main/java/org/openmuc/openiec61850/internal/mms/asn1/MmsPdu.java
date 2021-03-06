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
import org.openmuc.jasn1.ber.types.BerNull;

public final class MmsPdu {

	public byte[] code = null;
	public ConfirmedRequestPdu confirmedRequestPdu = null;

	public ConfirmedResponsePdu confirmedResponsePdu = null;

	public ConfirmedErrorPdu confirmedErrorPdu = null;

	public UnconfirmedPdu unconfirmedPdu = null;

	public RejectPdu rejectPdu = null;

	public InitiateRequestPdu initiateRequestPdu = null;

	public InitiateResponsePdu initiateResponsePdu = null;

	public ServiceError initiateErrorPdu = null;

	public BerNull conclude_RequestPDU = null;

	public MmsPdu() {
	}

	public MmsPdu(byte[] code) {
		this.code = code;
	}

	public MmsPdu(ConfirmedRequestPdu confirmedRequestPdu, ConfirmedResponsePdu confirmedResponsePdu,
			ConfirmedErrorPdu confirmedErrorPdu, UnconfirmedPdu unconfirmedPdu, RejectPdu rejectPdu,
			InitiateRequestPdu initiateRequestPdu, InitiateResponsePdu initiateResponsePdu,
			ServiceError initiateErrorPdu, BerNull conclude_RequestPDU) {
		this.confirmedRequestPdu = confirmedRequestPdu;
		this.confirmedResponsePdu = confirmedResponsePdu;
		this.confirmedErrorPdu = confirmedErrorPdu;
		this.unconfirmedPdu = unconfirmedPdu;
		this.rejectPdu = rejectPdu;
		this.initiateRequestPdu = initiateRequestPdu;
		this.initiateResponsePdu = initiateResponsePdu;
		this.initiateErrorPdu = initiateErrorPdu;
		this.conclude_RequestPDU = conclude_RequestPDU;
	}

	public int encode(BerByteArrayOutputStream berOStream, boolean explicit) throws IOException {
		if (code != null) {
			for (int i = code.length - 1; i >= 0; i--) {
				berOStream.write(code[i]);
			}
			return code.length;

		}
		int codeLength = 0;
		if (conclude_RequestPDU != null) {
			codeLength += conclude_RequestPDU.encode(berOStream, false);
			codeLength += (new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 11))
					.encode(berOStream);
			return codeLength;

		}

		if (initiateErrorPdu != null) {
			codeLength += initiateErrorPdu.encode(berOStream, false);
			codeLength += (new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 10))
					.encode(berOStream);
			return codeLength;

		}

		if (initiateResponsePdu != null) {
			codeLength += initiateResponsePdu.encode(berOStream, false);
			codeLength += (new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 9))
					.encode(berOStream);
			return codeLength;

		}

		if (initiateRequestPdu != null) {
			codeLength += initiateRequestPdu.encode(berOStream, false);
			codeLength += (new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 8))
					.encode(berOStream);
			return codeLength;

		}

		if (rejectPdu != null) {
			codeLength += rejectPdu.encode(berOStream, false);
			codeLength += (new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 4))
					.encode(berOStream);
			return codeLength;

		}

		if (unconfirmedPdu != null) {
			codeLength += unconfirmedPdu.encode(berOStream, false);
			codeLength += (new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 3))
					.encode(berOStream);
			return codeLength;

		}

		if (confirmedErrorPdu != null) {
			codeLength += confirmedErrorPdu.encode(berOStream, false);
			codeLength += (new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 2))
					.encode(berOStream);
			return codeLength;

		}

		if (confirmedResponsePdu != null) {
			codeLength += confirmedResponsePdu.encode(berOStream, false);
			codeLength += (new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 1))
					.encode(berOStream);
			return codeLength;

		}

		if (confirmedRequestPdu != null) {
			codeLength += confirmedRequestPdu.encode(berOStream, false);
			codeLength += (new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 0))
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
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 0)) {
			confirmedRequestPdu = new ConfirmedRequestPdu();
			codeLength += confirmedRequestPdu.decode(iStream, false);
			return codeLength;
		}

		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 1)) {
			confirmedResponsePdu = new ConfirmedResponsePdu();
			codeLength += confirmedResponsePdu.decode(iStream, false);
			return codeLength;
		}

		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 2)) {
			confirmedErrorPdu = new ConfirmedErrorPdu();
			codeLength += confirmedErrorPdu.decode(iStream, false);
			return codeLength;
		}

		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 3)) {
			unconfirmedPdu = new UnconfirmedPdu();
			codeLength += unconfirmedPdu.decode(iStream, false);
			return codeLength;
		}

		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 4)) {
			rejectPdu = new RejectPdu();
			codeLength += rejectPdu.decode(iStream, false);
			return codeLength;
		}

		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 8)) {
			initiateRequestPdu = new InitiateRequestPdu();
			codeLength += initiateRequestPdu.decode(iStream, false);
			return codeLength;
		}

		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 9)) {
			initiateResponsePdu = new InitiateResponsePdu();
			codeLength += initiateResponsePdu.decode(iStream, false);
			return codeLength;
		}

		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 10)) {
			initiateErrorPdu = new ServiceError();
			codeLength += initiateErrorPdu.decode(iStream, false);
			return codeLength;
		}

		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 11)) {
			conclude_RequestPDU = new BerNull();
			codeLength += conclude_RequestPDU.decode(iStream, false);
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
