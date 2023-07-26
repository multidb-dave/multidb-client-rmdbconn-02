package com.xql.clientmdb;

public class App {
    public static void main(String[] args) {
        String baseUrl = "http://localhost:8080";
        // String baseUrl = "http://api001.multidb.net:8080";

        // List of virtual schemas
        String url = baseUrl + "/api/v1/schemas";
        ListSchemas listSchemas = new ListSchemas();
        listSchemas.setUrl(url);
        listSchemas.getSchemas();
        System.out.println();

        // List of database sources
        url = baseUrl + "/api/v1/dbconns";
        ListDbconns listDbconns = new ListDbconns();
        listDbconns.setUrl(url);
        listDbconns.getDbconns();
        System.out.println();

        RemoveDvschema removeDvschema = new RemoveDvschema();
        removeDvschema.setBaseUrl(baseUrl);

        // correct input
        // 1. remove virtual schema northwind_a
        System.out.println("1. remove a virtual schema: northwind_a");
        url = baseUrl + "/api/v1/rmschema/";
        removeDvschema.setUrl(url);
        removeDvschema.setDvsname("northwind_a");

        removeDvschema.removeDvschema();
        System.out.println();

        RemoveDbconn removeDbconn = new RemoveDbconn();
        removeDbconn.setBaseUrl(baseUrl);

        // incorrect input
        // 2. remove a database source: psql_northwind
        System.out.println("2. remove a database source: psql_northwind");
        url = baseUrl + "/api/v1/rmdbconn/";
        removeDbconn.setUrl(url);
        removeDbconn.setDbconn("psql_northwind");

        removeDbconn.removeDbconn();
        System.out.println();

        // correct input
        // 3. remove virtual schema northwind_b
        System.out.println("3. remove a virtual schema: northwind_b");
        url = baseUrl + "/api/v1/rmschema/";
        removeDvschema.setUrl(url);
        removeDvschema.setDvsname("northwind_b");

        removeDvschema.removeDvschema();
        System.out.println();

        // incorrect input
        // 4. remove a database source: psql_northwind
        System.out.println("4. remove a database source: psql_northwind");
        url = baseUrl + "/api/v1/rmdbconn/";
        removeDbconn.setUrl(url);
        removeDbconn.setDbconn("psql_northwind");

        removeDbconn.removeDbconn();
        System.out.println();

        // incorrect input
        // 5. remove a database source: mysql_northwind
        System.out.println("5. remove a database source: mysql_northwind");
        url = baseUrl + "/api/v1/rmdbconn/";
        removeDbconn.setUrl(url);
        removeDbconn.setDbconn("mysql_northwind");

        removeDbconn.removeDbconn();
        System.out.println();

        // correct input
        // 6. remove virtual schema northwind_c
        System.out.println("6. remove a virtual schema: northwind_c");
        url = baseUrl + "/api/v1/rmschema/";
        removeDvschema.setUrl(url);
        removeDvschema.setDvsname("northwind_c");

        removeDvschema.removeDvschema();
        System.out.println();

        // correct input
        // 7. remove virtual schema northwind
        System.out.println("7. remove a virtual schema: northwind");
        url = baseUrl + "/api/v1/rmschema/";
        removeDvschema.setUrl(url);
        removeDvschema.setDvsname("northwind");

        removeDvschema.removeDvschema();
        System.out.println();

        // ======
        // correct input
        // 8. remove a database source: psql_northwind
        System.out.println("8. remove a database source: psql_northwind");
        url = baseUrl + "/api/v1/rmdbconn/";
        removeDbconn.setUrl(url);
        removeDbconn.setDbconn("psql_northwind");

        removeDbconn.removeDbconn();
        System.out.println();

        // incorrect input
        // 9. remove a database source: mysql_northwind
        System.out.println("9. remove a database source: mysql_northwind");
        url = baseUrl + "/api/v1/rmdbconn/";
        removeDbconn.setUrl(url);
        removeDbconn.setDbconn("mysql_northwind");

        removeDbconn.removeDbconn();
        System.out.println();

        // correct input
        // 10. remove a database source: csv_northwind
        System.out.println("10. remove a database source: csv_northwind");
        url = baseUrl + "/api/v1/rmdbconn/";
        removeDbconn.setUrl(url);
        removeDbconn.setDbconn("csv_northwind");

        removeDbconn.removeDbconn();
        System.out.println();

        // correct input
        // 11. remove a database source: ora_northwind
        System.out.println("11. remove a database source: ora_northwind");
        url = baseUrl + "/api/v1/rmdbconn/";
        removeDbconn.setUrl(url);
        removeDbconn.setDbconn("ora_northwind");

        removeDbconn.removeDbconn();
        System.out.println();

        // correct input
        // 12. remove a database source: msq_northwind
        System.out.println("12. remove a database source: msq_northwind");
        url = baseUrl + "/api/v1/rmdbconn/";
        removeDbconn.setUrl(url);
        removeDbconn.setDbconn("msq_northwind");

        removeDbconn.removeDbconn();
        System.out.println();

        System.out.println("8. remove a database source: psql_northwind");
        url = baseUrl + "/api/v1/rmdbconn/";
        removeDbconn.setUrl(url);
        removeDbconn.setDbconn("psql_northwind");

        removeDbconn.removeDbconn();
        System.out.println();

        // incorrect input
        // 9. remove a database source: mysql_northwind
        System.out.println("9. remove a database source: mysql_northwind");
        url = baseUrl + "/api/v1/rmdbconn/";
        removeDbconn.setUrl(url);
        removeDbconn.setDbconn("mysql_northwind");

        removeDbconn.removeDbconn();
        System.out.println();

        url = baseUrl + "/api/v1/schemas";
        listSchemas.setUrl(url);
        listSchemas.getSchemas();
        System.out.println();

        url = baseUrl + "/api/v1/dbconns";
        listDbconns.setUrl(url);
        listDbconns.getDbconns();
        System.out.println();

    }
}
