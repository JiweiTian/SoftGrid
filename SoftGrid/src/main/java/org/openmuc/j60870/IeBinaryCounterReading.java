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
/*
 * Copyright 2014 Fraunhofer ISE
 *
 * This file is part of j60870.
 * For more information visit http://www.openmuc.org
 *
 * j60870 is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * j60870 is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with j60870.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package org.openmuc.j60870;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Represents a binary counter reading (BCR) information element.
 * 
 * @author Stefan Feuerhahn
 * 
 */
public class IeBinaryCounterReading extends InformationElement {

	private final int counterReading;
	private final int sequenceNumber;
	private final boolean carry;
	private final boolean counterAdjusted;
	private final boolean invalid;

	public IeBinaryCounterReading(int counterReading, int sequenceNumber, boolean carry, boolean counterAdjusted,
			boolean invalid) {

		this.counterReading = counterReading;
		this.sequenceNumber = sequenceNumber;
		this.carry = carry;
		this.counterAdjusted = counterAdjusted;
		this.invalid = invalid;

	}

	IeBinaryCounterReading(DataInputStream is) throws IOException {

		int b1 = is.read();
		int b2 = is.read();
		int b3 = is.read();
		int b4 = is.read();
		int b5 = is.read();

		carry = ((b5 & 0x20) == 0x20);
		counterAdjusted = ((b5 & 0x40) == 0x40);
		invalid = ((b5 & 0x80) == 0x80);

		sequenceNumber = b5 & 0x1f;

		counterReading = (b4 << 24) | (b3 << 16) | (b2 << 8) | b1;

	}

	@Override
	int encode(byte[] buffer, int i) {

		buffer[i++] = (byte) counterReading;
		buffer[i++] = (byte) (counterReading >> 8);
		buffer[i++] = (byte) (counterReading >> 16);
		buffer[i++] = (byte) (counterReading >> 24);

		buffer[i] = (byte) sequenceNumber;
		if (carry) {
			buffer[i] |= 0x20;
		}
		if (counterAdjusted) {
			buffer[i] |= 0x40;
		}
		if (invalid) {
			buffer[i] |= 0x80;
		}

		return 5;

	}

	public int getCounterReading() {
		return counterReading;
	}

	public int getSequenceNumber() {
		return sequenceNumber;
	}

	public boolean isCarry() {
		return carry;
	}

	public boolean isCounterAdjusted() {
		return counterAdjusted;
	}

	public boolean isInvalid() {
		return invalid;
	}

	@Override
	public String toString() {
		return "Binary counter reading: " + counterReading + ", seq num: " + sequenceNumber + ", carry: " + carry
				+ ", counter adjusted: " + counterAdjusted + ", invalid: " + invalid;
	}
}
