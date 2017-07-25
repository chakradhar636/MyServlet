/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
DELIMITER $$
CREATE PROCEDURE getStdntName1(IN stdntid BIGINT, OUT stdntname VARCHAR(500))
BEGIN
SELECT name INTO stdntname FROM students WHERE id=stdntid;
END $$
DELIMITER ;
 */
//package databaseapp;
package com.cdk.ServletD;

/**
 *
 * @author ADMIN
 */
//STEP 1. Import required packages
import java.sql.*;

public class CallableStatementEg {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";


    static final String DB_URL = "jdbc:mysql://localhost/cdk";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "CDKcdk11";

    public static void main(String[] args) {
        //end try
        System.out.println("Done!");
    }//end main
}//end JDBCExample
