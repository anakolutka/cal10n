/*
 * Copyright (c) 2009 QOS.ch All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS  IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package ch.qos.cal10n.ant;

import junit.framework.TestSuite;
import org.apache.ant.antunit.junit3.AntUnitSuite;
import org.apache.ant.antunit.junit4.AntUnitSuiteRunner;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;

@RunWith(AntUnitSuiteRunner.class)
public class VerifyTaskTest {
    public static TestSuite suite() throws URISyntaxException {
        setProperties();
        URL resource = VerifyTask.class.getResource("/ch/qos/cal10n/ant/VerifyTaskTest.xml");
        File file = new File(resource.toURI());
        return new AntUnitSuite(file, VerifyTask.class);
    }

    /**
     * Set system properties for use in the AntUnit files.
     */
    private static void setProperties() {
        String name = VerifyTask.class.getName();
        final String resourceName = "/" + name.replace('.', '/') + ".class";
        String absoluteFilePath = VerifyTask.class.getResource(resourceName).getFile();
        try {
            absoluteFilePath = URLDecoder.decode(absoluteFilePath, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Missing UTF-8 encoding in JVM.", e);
        }
        String classesDir = absoluteFilePath.substring(0, absoluteFilePath.length() - resourceName.length());
        System.setProperty("ch.qos.cal10n.ant.VerifyTaskTest.classes.dir", classesDir);
    }
}
