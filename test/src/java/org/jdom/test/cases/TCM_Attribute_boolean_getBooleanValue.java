/*-- 

Copyright (C) 2000 Brett McLaughlin & Jason Hunter.
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions
are met:

1. Redistributions of source code must retain the above copyright
   notice, this list of conditions, and the following disclaimer.

2. Redistributions in binary form must reproduce the above copyright
   notice, this list of conditions, and the disclaimer that follows 
   these conditions in the documentation and/or other materials 
   provided with the distribution.

3. The name "JDOM" must not be used to endorse or promote products
   derived from this software without prior written permission.  For
   written permission, please contact license@jdom.org.

4. Products derived from this software may not be called "JDOM", nor
   may "JDOM" appear in their name, without prior written permission
   from the JDOM Project Management (pm@jdom.org).

In addition, we request (but do not require) that you include in the 
end-user documentation provided with the redistribution and/or in the 
software itself an acknowledgement equivalent to the following:
	"This product includes software developed by the
	 JDOM Project (http://www.jdom.org/)."
Alternatively, the acknowledgment may be graphical using the logos 
available at http://www.jdom.org/images/logos.

THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED.  IN NO EVENT SHALL THE APACHE SOFTWARE FOUNDATION OR
ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
SUCH DAMAGE.

This software consists of voluntary contributions made by many 
individuals on behalf of the JDOM Project and was originally 
created by Brett McLaughlin <brett@jdom.org> and 
Jason Hunter <jhunter@jdom.org>.  For more information on the 
JDOM Project, please see <http://www.jdom.org/>.

*/

package org.jdom.test.cases;

/**
 * Tests boolean values returned from Attributes.  Checks for
 * case sensitivity (values are not case sensitive) and bogus values
 * 
 * @author Philip Nelson
 * @version 0.1
 */

import org.jdom.Attribute;
import org.jdom.DataConversionException;

public final class TCM_Attribute_boolean_getBooleanValue
extends junit.framework.TestCase
{
	/**
	 *  Construct a new instance. 
	 */
	public TCM_Attribute_boolean_getBooleanValue(String name) {
		super(name);
	}
	/**
	 * This method is called before a test is executed.
	 */
	public void setUp() {
		// your code goes here.
	}
	/**
	 * This method is called after a test is executed.
	 */
	public void tearDown() {
		// your code goes here.
	}
	/**
	 * 
	 */
	public void test() {
				Attribute attr = new Attribute("test", "true");
		try {
			assert("incorrect boolean true value", attr.getBooleanValue());

			attr.setValue("false");
			assert("incorrect boolean false value", !attr.getBooleanValue());

			attr.setValue("TRUE");
			assert("incorrect boolean TRUE value", attr.getBooleanValue());

			attr.setValue("FALSE");
			assert("incorrect boolean FALSE value", !attr.getBooleanValue());

		} catch (DataConversionException e) {
			assert("couldn't convert boolean value", false);
		}

		try {
			attr.setValue("foo");
			assert("incorrectly returned boolean from non boolean value", attr.getBooleanValue());

		} catch (DataConversionException e) {
			assert(true);
		}


	}
}
