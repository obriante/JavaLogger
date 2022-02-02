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

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LogTest {

	@Before
	public void init() {

	}

	@Test
	public void VerboseTest() {
		Log.level=Level.VERBOSE;
		String TAG="VerboseTest";
		assertEquals(0,Log.v(TAG, "This is a test message."));
		assertEquals(0,Log.d(TAG, "This is a test message."));
		assertEquals(0,Log.i(TAG, "This is a test message."));
		assertEquals(0,Log.w(TAG, "This is a test message."));
		assertEquals(0,Log.e(TAG, "This is a test message."));
	}

	@Test
	public void DebugTest() {
		Log.level=Level.DEBUG;
		String TAG="DebugTest";
		assertEquals(1,Log.v(TAG, "This is a test message."));
		assertEquals(0,Log.d(TAG, "This is a test message."));
		assertEquals(0,Log.i(TAG, "This is a test message."));
		assertEquals(0,Log.w(TAG, "This is a test message."));
		assertEquals(0,Log.e(TAG, "This is a test message."));
	}
	@Test
	public void InfoTest() {
		Log.level=Level.INFO;
		String TAG="InfoTest";
		assertEquals(1,Log.v(TAG, "This is a test message."));
		assertEquals(1,Log.d(TAG, "This is a test message."));
		assertEquals(0,Log.i(TAG, "This is a test message."));
		assertEquals(0,Log.w(TAG, "This is a test message."));
		assertEquals(0,Log.e(TAG, "This is a test message."));
	}
	@Test
	public void WarningTest() {
		Log.level=Level.WARN;
		String TAG="WarningTest";
		assertEquals(1,Log.v(TAG, "This is a test message."));
		assertEquals(1,Log.d(TAG, "This is a test message."));
		assertEquals(1,Log.i(TAG, "This is a test message."));
		assertEquals(0,Log.w(TAG, "This is a test message."));
		assertEquals(0,Log.e(TAG, "This is a test message."));
	}

	@Test
	public void ErrorTest() {
		Log.level=Level.ERROR;
		String TAG="ErrorTest";
		assertEquals(1,Log.v(TAG, "This is a test message."));
		assertEquals(1,Log.d(TAG, "This is a test message."));
		assertEquals(1,Log.i(TAG, "This is a test message."));
		assertEquals(1,Log.w(TAG, "This is a test message."));
		assertEquals(0,Log.e(TAG, "This is a test message."));
	}

	@Test
	public void NoneTest() {
		Log.level=Level.NONE;
		String TAG="NoneTest";
		assertEquals(1,Log.v(TAG, "This is a test message."));
		assertEquals(1,Log.d(TAG, "This is a test message."));
		assertEquals(1,Log.i(TAG, "This is a test message."));
		assertEquals(1,Log.w(TAG, "This is a test message."));
		assertEquals(1,Log.e(TAG, "This is a test message."));
	}

	@Test
	public void StreamTest() {
		Log.level=Level.VERBOSE;
		String TAG="StreamTest";
		Log.stream=System.out;
		assertEquals(0,Log.v(TAG, "This is a test message."));
		assertEquals(0,Log.d(TAG, "This is a test message."));
		assertEquals(0,Log.i(TAG, "This is a test message."));
		assertEquals(0,Log.w(TAG, "This is a test message."));
		assertEquals(0,Log.e(TAG, "This is a test message."));
		Log.stream=null;
		assertEquals(1,Log.v(TAG, "This is a test message."));
		Log.stream=System.err;
		
	}

	@Test
	public void ThrowableTest() {
		Log.level=Level.VERBOSE;
		String TAG="ThrowableTest";
		Exception e=new Exception("This is a test exception.");
		assertEquals(0,Log.v(TAG, "This is a test message.",e));
		assertEquals(0,Log.d(TAG, "This is a test message.",e));
		assertEquals(0,Log.i(TAG, "This is a test message.",e));
		assertEquals(0,Log.w(TAG, "This is a test message.",e));
		assertEquals(0,Log.e(TAG, "This is a test message.",e));
	}

	@After
	public void deinit() {

	}

}
