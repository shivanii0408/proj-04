
package in.co.rays.proj4.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

//DataUtility class format data into correct format or into another format
public class DataUtility {

	public static final String APP_DATE_FORMAT = "yyyy-MM-dd";
	public static final String APP_TIME_FORMAT = "MM/dd/yyyy HH:mm:ss";
	private static final SimpleDateFormat formatter = new SimpleDateFormat(APP_DATE_FORMAT);
	private static final SimpleDateFormat timeFormatter = new SimpleDateFormat(APP_TIME_FORMAT);

	// user defined method
	// argument type is String
	// Converts String value into a trimmed String.
	// If value is null, it returns null.
	public static String getString(String val) {
		if (DataValidator.isNotNull(val)) {
			return val.trim();
		} else {
			return val;
		}
	}

	// Converts an Object value into String.
	// If value is null, it returns an empty String ("").
	public static String getStringData(Object val) {
		if (val != null) {
			return val.toString();
		} else {
			return "";
		}
	}

	// Converts String value into int.
	// If the String is a valid integer, it returns the integer value.
	// Otherwise, it returns 0.
	public static int getInt(String val) {
		if (DataValidator.isInteger(val)) {
			return Integer.parseInt(val);
		} else {
			return 0;
		}
	}

	// Converts String value into long.
	// If the String is a valid long value, it returns the long value.
	// Otherwise, it returns 0.
	public static long getLong(String val) {
		if (DataValidator.isLong(val)) {
			return Long.parseLong(val);
		} else {
			return 0;
		}
	}

	// Converts a String date into a Date object.
	// The String must follow the format "yyyy-MM-dd".
	// If the date cannot be parsed, it returns null.
	public static Date getDate(String val) {
		Date date = null;
		try {
			date = formatter.parse(val);
		} catch (Exception e) {

		}
		return date;
	}

	// Converts a Date object into a String.
	// The returned String follows the format "yyyy-MM-dd".
	// If formatting fails, it returns an empty String ("").
	public static String getDateString(Date date) {
		try {
			return formatter.format(date);
		} catch (Exception e) {
		}
		return "";
	}

	// Converts a String containing date and time into a Timestamp.
	// The String must follow the format "MM/dd/yyyy HH:mm:ss".
	// If conversion fails, it returns null.
	public static Timestamp getTimestamp(String val) {

		Timestamp timeStamp = null;
		try {
			timeStamp = new Timestamp((timeFormatter.parse(val)).getTime());
		} catch (Exception e) {
			return null;
		}
		return timeStamp;
	}
	
	
	// Converts milliseconds (long value) into a Timestamp object.
	// The long value represents time in milliseconds since January 1, 1970.
	// If conversion fails, it returns null.
	public static Timestamp getTimestamp(long l) {

		Timestamp timeStamp = null;
		try {
			timeStamp = new Timestamp(l);
		} catch (Exception e) {
			return null;
		}
		return timeStamp;
	}

	// Returns the current date and time as a Timestamp.
	// It is commonly used for createdDateTime or modifiedDateTime.
	public static Timestamp getCurrentTimestamp() {
		Timestamp timeStamp = null;
		try {
			timeStamp = new Timestamp(new Date().getTime());
		} catch (Exception e) {
		}
		return timeStamp;

	}

	// Converts a Timestamp into its long millisecond value.
	// If the Timestamp is null or an error occurs, it returns 0.
	public static long getTimestamp(Timestamp tm) {
		try {
			return tm.getTime();
		} catch (Exception e) {
			return 0;
		}
	}
	
	public static double getDouble(String val) {
	    try {
	        return Double.parseDouble(val);
	    } catch (Exception e) {
	        return 0;
	    }
	}
	
	public static boolean getBoolean(String val) {
	    try {
	        return Boolean.parseBoolean(val);
	    } catch (Exception e) {
	        return false;
	    }
	}

}
