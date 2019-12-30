package crudjavaeejdbc.dao.util;

import java.sql.Date;
import java.time.LocalDate;

public class JDBCUtil {

	public static Date getSQLDate(LocalDate data) {
		return java.sql.Date.valueOf(data);
	}
	
	public static LocalDate getUtilDate(Date sqlDate) {
		return sqlDate.toLocalDate();
	}
}
