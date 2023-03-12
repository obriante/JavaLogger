/*
 * Copyright (c) 2022 Orazio Briante <orazio.briante@hotmail.it>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License version 2 as
 * published by the Free Software Foundation;
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
package com.github.kernelmonkey.java.logger;

public enum Level {
	VERBOSE(0), DEBUG(1), INFO(2), WARN(3), ERROR(4);

	private final int value;

	private Level(int value) {
		this.value = value;
	}

	public int value() {
		return value;
	}

	@Override
	public String toString() {
		return this.name().toUpperCase();
	}

	public static final Level valueOf(final int id) throws Exception {
		for (Level level : values()) {
			if (level.value() == id) {
				return level;
			}
		}
		throw new Exception("value not found");
	}
}