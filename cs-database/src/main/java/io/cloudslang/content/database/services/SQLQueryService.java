/*******************************************************************************
 * (c) Copyright 2017 Hewlett-Packard Development Company, L.P.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Apache License v2.0 which accompany this distribution.
 *
 * The Apache License is available at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 *******************************************************************************/
package io.cloudslang.content.database.services;

import io.cloudslang.content.database.utils.SQLInputs;
import io.cloudslang.content.database.utils.SQLUtils;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

/**
 * Created by victor on 13.01.2017.
 */
public class SQLQueryService {

    public static void executeSqlQuery(@NotNull final SQLInputs sqlInputs) throws Exception {
        if (StringUtils.isEmpty(sqlInputs.getSqlCommand())) {
            throw new Exception("command input is empty.");
        }
        ConnectionService connectionService = new ConnectionService();
        try (final Connection connection = connectionService.setUpConnection(sqlInputs)) {

            connection.setReadOnly(true);
            Statement statement = connection.createStatement(sqlInputs.getResultSetType(), sqlInputs.getResultSetConcurrency());
            statement.setQueryTimeout(sqlInputs.getTimeout());
            final ResultSet results = statement.executeQuery(sqlInputs.getSqlCommand());

            final ResultSetMetaData mtd = results.getMetaData();

            int iNumCols = mtd.getColumnCount();

            final StringBuilder strColumns = new StringBuilder(sqlInputs.getStrColumns());

            for (int i = 1; i <= iNumCols; i++) {
                if (i > 1) {
                    strColumns.append(sqlInputs.getStrDelim());
                }
                strColumns.append(mtd.getColumnLabel(i));
            }
            sqlInputs.setStrColumns(strColumns.toString());

            while (results.next()) {
                final StringBuilder strRowHolder = new StringBuilder();
                for (int i = 1; i <= iNumCols; i++) {
                    if (i > 1) strRowHolder.append(sqlInputs.getStrDelim());
                    String value = results.getString(i).trim();
                    if (sqlInputs.isNetcool())
                        value = SQLUtils.processNullTerminatedString(value);

                    strRowHolder.append(value);
                }
                sqlInputs.getlRows().add(strRowHolder.toString());
            }
        }
    }
}
