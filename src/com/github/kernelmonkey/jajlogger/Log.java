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
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class Log {

	private static final String pattern = "yyyy-MM-dd HH:mm:ss.SSS";

	@Nonnull
	public static Level level = Level.DEBUG;
	@Nullable
	public static PrintStream stream = System.err;

	synchronized private static void printlog(@Nonnull final String l, @Nonnull final String date,
			@Nullable final String tag, @Nonnull final String msg) {

		stream.println(date + " " + l + " " + tag + ": " + msg);
	}

	synchronized private static int log(@Nonnull final Level l, @Nonnull final Date date, @Nullable final String tag,
			@Nonnull final String msg, @Nullable Throwable tr) {
		if (level.value() <= l.value() && stream != null) {

			DateFormat df = new SimpleDateFormat(pattern);

			final String d = df.format(date);
			final String lev = l.name().substring(0, 1) + "  ";

			printlog(lev, d, tag, msg);

			if (tr != null) {
				StringWriter sw = new StringWriter();
				PrintWriter pw = new PrintWriter(sw);
				tr.printStackTrace(pw);

				for (String str : sw.toString().split("\n")) {
					printlog(lev, d, tag, str);
				}
			}
			return 0;
		}
		return 1;
	}

	public static int v(@Nullable final String tag, @Nonnull final String msg) {
		return log(Level.VERBOSE, Calendar.getInstance().getTime(), tag, msg, null);
	}

	public static int v(@Nullable final String tag, @Nonnull final String msg, @Nullable final Throwable tr) {
		return log(Level.VERBOSE, Calendar.getInstance().getTime(), tag, msg, tr);
	}

	public static int d(@Nullable String tag, @Nonnull String msg) {
		return log(Level.DEBUG, Calendar.getInstance().getTime(), tag, msg, null);
	}

	public static int d(@Nullable final String tag, @Nonnull final String msg, @Nullable final Throwable tr) {
		return log(Level.DEBUG, Calendar.getInstance().getTime(), tag, msg, tr);
	}

	public static int i(@Nullable String tag, @Nonnull String msg) {
		return log(Level.INFO, Calendar.getInstance().getTime(), tag, msg, null);
	}

	public static int i(@Nullable final String tag, @Nonnull final String msg, @Nullable final Throwable tr) {
		return log(Level.INFO, Calendar.getInstance().getTime(), tag, msg, tr);
	}

	public static int w(@Nullable String tag, @Nonnull String msg) {
		return log(Level.WARN, Calendar.getInstance().getTime(), tag, msg, null);
	}

	public static int w(@Nullable final String tag, @Nonnull final String msg, @Nullable final Throwable tr) {
		return log(Level.WARN, Calendar.getInstance().getTime(), tag, msg, tr);
	}

	public static int e(@Nullable String tag, @Nonnull String msg) {
		return log(Level.ERROR, Calendar.getInstance().getTime(), tag, msg, null);
	}

	public static int e(@Nullable final String tag, @Nonnull final String msg, @Nullable final Throwable tr) {
		return log(Level.ERROR, Calendar.getInstance().getTime(), tag, msg, tr);
	}
}
