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

public class LoggerTest {

	
	Logger logger;
	
	@Before
	public void init() {
		logger=new Logger();
	}

	@Test
	public void printTest() {
		String TAG="printTest";
		assertEquals(0,logger.v(TAG, "This is a test message."));
		assertEquals(0,logger.d(TAG, "This is a test message."));
		assertEquals(0,logger.i(TAG, "This is a test message."));
		assertEquals(0,logger.w(TAG, "This is a test message."));
		assertEquals(0,logger.e(TAG, "This is a test message."));
	}

	@Test
	public void StreamTest() {
		String TAG="StreamTest";
		logger=new Logger(System.out);
		assertEquals(0,logger.v(TAG, "This is a test message."));
		assertEquals(0,logger.d(TAG, "This is a test message."));
		assertEquals(0,logger.i(TAG, "This is a test message."));
		assertEquals(0,logger.w(TAG, "This is a test message."));
		assertEquals(0,logger.e(TAG, "This is a test message."));
		logger=new Logger();
	}
	
	@Test
	public void tagTest() {
		String TAG="";
		assertEquals(0,logger.v(TAG, "This is a test message."));
		assertEquals(0,logger.d(TAG, "This is a test message."));
		assertEquals(0,logger.i(TAG, "This is a test message."));
		assertEquals(0,logger.w(TAG, "This is a test message."));
		assertEquals(0,logger.e(TAG, "This is a test message."));
		TAG=null;
		assertEquals(0,logger.v(TAG, "This is a test message."));
		assertEquals(0,logger.d(TAG, "This is a test message."));
		assertEquals(0,logger.i(TAG, "This is a test message."));
		assertEquals(0,logger.w(TAG, "This is a test message."));
		assertEquals(0,logger.e(TAG, "This is a test message."));
	}

	@Test
	public void ThrowableTest() {
		String TAG="ThrowableTest";
		Exception e=new Exception("This is a test exception.");
		assertEquals(0,logger.v(TAG, "This is a test message.",e));
		assertEquals(0,logger.d(TAG, "This is a test message.",e));
		assertEquals(0,logger.i(TAG, "This is a test message.",e));
		assertEquals(0,logger.w(TAG, "This is a test message.",e));
		assertEquals(0,logger.e(TAG, "This is a test message.",e));
	}

	@After
	public void deinit() {

	}

}
