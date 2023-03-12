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

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LogTest {
	
	@Before
	public void init() {
		
	}

	@Test
	public void printTest() {
		String TAG="printTest";
		assertEquals(0,Log.v(TAG, "This is a test message."));
		assertEquals(0,Log.d(TAG, "This is a test message."));
		assertEquals(0,Log.i(TAG, "This is a test message."));
		assertEquals(0,Log.w(TAG, "This is a test message."));
		assertEquals(0,Log.e(TAG, "This is a test message."));
	}

	@Test
	public void StreamTest() {
		String TAG="StreamTest";
		Log.setStream(System.out);
		assertEquals(0,Log.v(TAG, "This is a test message."));
		assertEquals(0,Log.d(TAG, "This is a test message."));
		assertEquals(0,Log.i(TAG, "This is a test message."));
		assertEquals(0,Log.w(TAG, "This is a test message."));
		assertEquals(0,Log.e(TAG, "This is a test message."));
		Log.setStream(null);
	}
	
	@Test
	public void tagTest() {
		String TAG="";
		assertEquals(0,Log.v(TAG, "This is a test message."));
		assertEquals(0,Log.d(TAG, "This is a test message."));
		assertEquals(0,Log.i(TAG, "This is a test message."));
		assertEquals(0,Log.w(TAG, "This is a test message."));
		assertEquals(0,Log.e(TAG, "This is a test message."));
		TAG=null;
		assertEquals(0,Log.v(TAG, "This is a test message."));
		assertEquals(0,Log.d(TAG, "This is a test message."));
		assertEquals(0,Log.i(TAG, "This is a test message."));
		assertEquals(0,Log.w(TAG, "This is a test message."));
		assertEquals(0,Log.e(TAG, "This is a test message."));
	}

	@Test
	public void ThrowableTest() {
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
