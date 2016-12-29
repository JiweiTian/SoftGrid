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
 * Represents a select and call qualifier (SCQ) information element.
 * 
 * @author Stefan Feuerhahn
 * 
 */
public class IeSelectAndCallQualifier extends InformationElement {

	private final int action;
	private final int notice;

	public IeSelectAndCallQualifier(int action, int notice) {
		this.action = action;
		this.notice = notice;
	}

	IeSelectAndCallQualifier(DataInputStream is) throws IOException {
		int b1 = is.read();
		action = b1 & 0x0f;
		notice = (b1 >> 4) & 0x0f;
	}

	@Override
	int encode(byte[] buffer, int i) {
		buffer[i] = (byte) (action | (notice << 4));
		return 1;
	}

	public int getRequest() {
		return action;
	}

	public int getFreeze() {
		return notice;
	}

	@Override
	public String toString() {
		return "Select and call qualifier, action: " + action + ", notice: " + notice;
	}
}
