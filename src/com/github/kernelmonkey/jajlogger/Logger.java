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
package com.github.kernelmonkey.jajlogger;

import java.io.PrintStream;
import java.util.Calendar;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class Logger extends ALogger {

	@Nullable
	protected PrintStream stream = System.err;
	
	public Logger() {
		super();
		stream = System.err;
	}
	
	public Logger(PrintStream st) {
		super();
		stream = st;
	}

	@Override
	public int v(@Nullable final String tag, @Nonnull final String msg) {
		return log(stream, Level.VERBOSE, Calendar.getInstance().getTime(), tag, msg, null);
	}

	@Override
	public int v(@Nullable final String tag, @Nonnull final String msg, @Nullable final Throwable tr) {
		return log(stream, Level.VERBOSE, Calendar.getInstance().getTime(), tag, msg, tr);
	}

	@Override
	public int d(@Nullable String tag, @Nonnull String msg) {
		return log(stream, Level.DEBUG, Calendar.getInstance().getTime(), tag, msg, null);
	}

	@Override
	public int d(@Nullable final String tag, @Nonnull final String msg, @Nullable final Throwable tr) {
		return log(stream, Level.DEBUG, Calendar.getInstance().getTime(), tag, msg, tr);
	}

	@Override
	public int i(@Nullable String tag, @Nonnull String msg) {
		return log(stream, Level.INFO, Calendar.getInstance().getTime(), tag, msg, null);
	}

	@Override
	public int i(@Nullable final String tag, @Nonnull final String msg, @Nullable final Throwable tr) {
		return log(stream, Level.INFO, Calendar.getInstance().getTime(), tag, msg, tr);
	}

	@Override
	public int w(@Nullable String tag, @Nonnull String msg) {
		return log(stream, Level.WARN, Calendar.getInstance().getTime(), tag, msg, null);
	}

	@Override
	public int w(@Nullable final String tag, @Nonnull final String msg, @Nullable final Throwable tr) {
		return log(stream, Level.WARN, Calendar.getInstance().getTime(), tag, msg, tr);
	}

	@Override
	public int e(@Nullable String tag, @Nonnull String msg) {
		return log(stream, Level.ERROR, Calendar.getInstance().getTime(), tag, msg, null);
	}

	@Override
	public int e(@Nullable final String tag, @Nonnull final String msg, @Nullable final Throwable tr) {
		return log(stream, Level.ERROR, Calendar.getInstance().getTime(), tag, msg, tr);
	}
}
