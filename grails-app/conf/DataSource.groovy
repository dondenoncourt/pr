dataSource {
    pooled = true
    driverClassName = "org.hsqldb.jdbcDriver"
    username = "sa"
    password = ""
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = true
    cache.provider_class = 'net.sf.ehcache.hibernate.EhCacheProvider'
}
// environment specific settings
hr.schema='hrixpgle'
gl.schema='hrixpgle'
environments {
    development {
        dataSource {
            url = "jdbc:mysql://localhost/hrixpgle"
            driverClassName = "com.mysql.jdbc.Driver"
            dialect = org.hibernate.dialect.MySQLDialect
            username = "donat"
            password = "vo2max"
            dbCreate = "create"
            logSql = false
        }

    }
    test {
		dataSource {
			dbCreate = "update"
			url = "jdbc:h2:mem:hrixpgle"
            driverClassName = "org.h2.Driver"
		}
		hr.schema=null
		gl.schema=null

    }
    production {
        dataSource {
			pooled = true
			url = "jdbc:as400://10.2.0.211/hrixpgle;transaction isolation=none"
			driverClassName = "com.ibm.as400.access.AS400JDBCDriver"
			dialect = org.hibernate.dialect.DB2400Dialect.class
			username = "daffrcv"
			password = "DARKWOW"
        }
    }
}
