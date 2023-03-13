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
package com.github.java.logger;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

abstract class ALogger {

	protected static final String pattern = "yyyy-MM-dd HH:mm:ss.SSS";

	synchronized private int println(@Nonnull final PrintStream stream, @Nonnull final Level level, @Nonnull final String date,
			@Nullable final String tag, @Nullable final String msg) {

		if (msg != null) {
			String TAG=(tag != null) ? tag : "";
			stream.println(date + " " + level.name().substring(0, 1) + "   " + TAG + ": " + msg);
			return 0;
		}
		return 1;
	}

	synchronized private int printThrowable(@Nonnull final PrintStream stream, @Nonnull final Level level, @Nonnull final String date,
			@Nullable final String tag, @Nullable Throwable tr) {

		if (tr != null) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			tr.printStackTrace(pw);

			for (String str : sw.toString().split("\n")) {
				println(stream, level, date, tag, str);
			}
			return 0;
		}
		return 1;
	}

	synchronized protected int log(@Nonnull final PrintStream stream, @Nonnull final Level level, @Nonnull final Date date, @Nullable final String tag,
			@Nonnull final String msg, @Nullable Throwable tr) {

		DateFormat df = new SimpleDateFormat(pattern);
		String d=df.format(date);

		int ret=println(stream, level, d, tag, msg);
		ret=ret&printThrowable(stream, level, d, tag,tr);
		return ret;
	}

	public abstract int v(@Nullable final String tag, @Nonnull final String msg);

	public abstract int v(@Nullable final String tag, @Nonnull final String msg, @Nullable final Throwable tr);

	public abstract int d(@Nullable String tag, @Nonnull String msg);

	public abstract int d(@Nullable final String tag, @Nonnull final String msg, @Nullable final Throwable tr);

	public abstract int i(@Nullable String tag, @Nonnull String msg) ;

	public abstract int i(@Nullable final String tag, @Nonnull final String msg, @Nullable final Throwable tr);

	public abstract int w(@Nullable String tag, @Nonnull String msg);

	public abstract int w(@Nullable final String tag, @Nonnull final String msg, @Nullable final Throwable tr);

	public abstract int e(@Nullable String tag, @Nonnull String msg);

	public abstract int e(@Nullable final String tag, @Nonnull final String msg, @Nullable final Throwable tr) ;

}
