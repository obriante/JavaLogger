package com.github.kernelmonkey.java.logger;

import java.io.PrintStream;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class Log {

	private static Logger log=new Logger();

	public static void setStream(@Nullable PrintStream pt) {
		log=new Logger((pt!=null)?pt:System.err);
	}

	public static int v(@Nullable final String tag, @Nonnull final String msg){
		return log.v(tag, msg);
	}

	public static int v(@Nullable final String tag, @Nonnull final String msg, @Nullable final Throwable tr){
		return log.v(tag, msg, tr);
	}

	public static int d(@Nullable String tag, @Nonnull String msg){
		return log.d(tag, msg);
	}

	public static int d(@Nullable final String tag, @Nonnull final String msg, @Nullable final Throwable tr){
		return log.d(tag, msg, tr);
	}

	public static int i(@Nullable String tag, @Nonnull String msg) {
		return log.i(tag, msg);
	}

	public static int i(@Nullable final String tag, @Nonnull final String msg, @Nullable final Throwable tr){
		return log.i(tag, msg, tr);
	}

	public static int w(@Nullable String tag, @Nonnull String msg){
		return log.w(tag, msg);
	}

	public static int w(@Nullable final String tag, @Nonnull final String msg, @Nullable final Throwable tr){
		return log.w(tag, msg, tr);
	}

	public static int e(@Nullable String tag, @Nonnull String msg){
		return log.e(tag, msg);
	}

	public static int e(@Nullable final String tag, @Nonnull final String msg, @Nullable final Throwable tr) {
		return log.e(tag, msg, tr);
	}

}
