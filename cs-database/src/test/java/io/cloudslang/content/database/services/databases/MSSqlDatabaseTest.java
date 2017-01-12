/*******************************************************************************
 * (c) Copyright 2017 Hewlett-Packard Development Company, L.P.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Apache License v2.0 which accompany this distribution.
 *
 * The Apache License is available at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 *******************************************************************************/
package io.cloudslang.content.database.services.databases;

import io.cloudslang.content.database.utils.Constants;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.sql.SQLException;
import java.util.ArrayList;

import static io.cloudslang.content.database.utils.Constants.JTDS_JDBC_DRIVER;
import static junit.framework.Assert.assertEquals;

/**
 * Created by vranau on 12/10/2014.
 */
public class MSSqlDatabaseTest {

    public static final String DB_NAME = "/dbName";
    public static final String DB_SERVER = "dbServer";
    public static final String INSTANCE = "instance";
    public static final String DB_SERVER_WITH_INSTANCE = DB_SERVER + Constants.ESCAPED_BACKSLASH + INSTANCE;
    public static final String DB_PORT = "30";
    public static final String DB_SERVER_IPV6_LITERAL = "2001-0db8-85a3-0042-1000-8a2e-0370-7334.ipv6-literal.net";
    public static final String AUTH_TYPE = "authType";
    public static final String INVALID_AUTH_TYPE = "authType";
    public static final String WINDOWS_DOMAIN = "windowsDomain";

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();
    private ArrayList<String> dbUrls = null;

    @Before
    public void setUp() {
        dbUrls = new ArrayList<>();
    }

    @Test
    public void testSetUpInvalidAuthType() throws ClassNotFoundException, SQLException {
        expectedEx.expect(SQLException.class);
        expectedEx.expectMessage("Invalid authentication type for MS SQL : " + AUTH_TYPE);
        MSSqlDatabase mSSqlDatabase = new MSSqlDatabase();
        mSSqlDatabase.setUp("", DB_SERVER, DB_PORT, dbUrls, INVALID_AUTH_TYPE, INSTANCE, WINDOWS_DOMAIN, JTDS_JDBC_DRIVER);
        assertEquals(1, dbUrls.size());
    }

    @Test
    public void testSetUpNoDbName() throws ClassNotFoundException, SQLException {
        MSSqlDatabase mSSqlDatabase = new MSSqlDatabase();
        mSSqlDatabase.setUp("", DB_SERVER, DB_PORT, dbUrls, Constants.AUTH_WINDOWS, INSTANCE, WINDOWS_DOMAIN, JTDS_JDBC_DRIVER);
        assertEquals("jdbc:jtds:sqlserver://dbServer:30;instance=instance;domain=windowsDomain;useNTLMv2=true", dbUrls.get(0));
        assertEquals(1, dbUrls.size());
    }

    @Test
    public void testSetUpNullDbName() throws ClassNotFoundException, SQLException {
        expectedEx.expect(SQLException.class);
        expectedEx.expectMessage("No database provided!");
        MSSqlDatabase mSSqlDatabase = new MSSqlDatabase();
        mSSqlDatabase.setUp(null, DB_SERVER, DB_PORT, dbUrls, Constants.AUTH_WINDOWS, INSTANCE, WINDOWS_DOMAIN, JTDS_JDBC_DRIVER);
    }

    @Test
    public void testSetUpNoServerName() throws ClassNotFoundException, SQLException {
        expectedEx.expect(IllegalArgumentException.class);
        expectedEx.expectMessage("host   not valid");
        MSSqlDatabase mSSqlDatabase = new MSSqlDatabase();
        mSSqlDatabase.setUp(DB_NAME, null, DB_PORT, dbUrls, AUTH_TYPE, INSTANCE, WINDOWS_DOMAIN, JTDS_JDBC_DRIVER);
    }

    @Test
    public void testSetUpNoDbPort() throws ClassNotFoundException, SQLException {
        expectedEx.expect(SQLException.class);
        expectedEx.expectMessage("No port provided!");
        MSSqlDatabase mSSqlDatabase = new MSSqlDatabase();
        mSSqlDatabase.setUp(DB_NAME, DB_SERVER, null, dbUrls, Constants.AUTH_WINDOWS, INSTANCE, WINDOWS_DOMAIN, JTDS_JDBC_DRIVER);
    }

    @Test
    public void testSetUpAllAuthWindows() throws ClassNotFoundException, SQLException {
        MSSqlDatabase mSSqlDatabase = new MSSqlDatabase();
        mSSqlDatabase.setUp(DB_NAME, DB_SERVER, DB_PORT, dbUrls, Constants.AUTH_WINDOWS, INSTANCE, WINDOWS_DOMAIN, JTDS_JDBC_DRIVER);
        assertEquals("jdbc:jtds:sqlserver://dbServer:30/dbName;instance=instance;domain=windowsDomain;useNTLMv2=true", dbUrls.get(0));
        assertEquals(1, dbUrls.size());
    }

    @Test
    public void testSetUpAllAuthSQL() throws ClassNotFoundException, SQLException {
        MSSqlDatabase mSSqlDatabase = new MSSqlDatabase();
        mSSqlDatabase.setUp(DB_NAME, DB_SERVER, DB_PORT, dbUrls, Constants.AUTH_SQL, INSTANCE, WINDOWS_DOMAIN, JTDS_JDBC_DRIVER);
        assertEquals("jdbc:jtds:sqlserver://dbServer:30/dbName;instance=instance;", dbUrls.get(0));
        assertEquals(1, dbUrls.size());
    }

    @Test
    public void testSetUpAllIPV6LIteral() throws ClassNotFoundException, SQLException {
        MSSqlDatabase mSSqlDatabase = new MSSqlDatabase();
        mSSqlDatabase.setUp(DB_NAME, DB_SERVER_IPV6_LITERAL, DB_PORT, dbUrls, Constants.AUTH_SQL, INSTANCE, WINDOWS_DOMAIN, JTDS_JDBC_DRIVER);
        assertEquals("jdbc:jtds:sqlserver://2001-0db8-85a3-0042-1000-8a2e-0370-7334.ipv6-literal.net:30/dbName;instance=instance;", dbUrls.get(0));
        assertEquals(1, dbUrls.size());
    }

    @Test
    public void testSetUpAllAuthWindowsAndHostWithInstance() throws ClassNotFoundException, SQLException {
        MSSqlDatabase mSSqlDatabase = new MSSqlDatabase();
        mSSqlDatabase.setUp(DB_NAME, DB_SERVER_WITH_INSTANCE, DB_PORT, dbUrls, Constants.AUTH_WINDOWS, INSTANCE, WINDOWS_DOMAIN, JTDS_JDBC_DRIVER);
        assertEquals("jdbc:jtds:sqlserver://dbServer:30/dbName;instance=instance;domain=windowsDomain;useNTLMv2=true", dbUrls.get(0));
        assertEquals(1, dbUrls.size());
    }

    @Test
    public void testSetUpAllAuthWindowsAndHostWithNoInstance() throws ClassNotFoundException, SQLException {
        MSSqlDatabase mSSqlDatabase = new MSSqlDatabase();
        mSSqlDatabase.setUp(DB_NAME, DB_SERVER, DB_PORT, dbUrls, Constants.AUTH_WINDOWS, null, WINDOWS_DOMAIN, JTDS_JDBC_DRIVER);
        assertEquals("jdbc:jtds:sqlserver://dbServer:30/dbName;domain=windowsDomain;useNTLMv2=true", dbUrls.get(0));
        assertEquals(1, dbUrls.size());
    }
}
