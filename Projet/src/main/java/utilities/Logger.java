package utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

	private static String logFilePath = ".\\src\\main\\resources\\logs.txt";
	private static File file;
	private static FileWriter writer;
	private static BufferedWriter bw;
	private static DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	private static Date logDate;

	private Logger() {}
	
	/**
	 * Sets the logs file path
	 * @param s : Logs file path
	 */
	public static void setLogFilePath(String s) {
		logFilePath=s;
	}
	
	/**
	 * Logger
	 * @param s : String to log
	 */
	public static void log(String s) {
		file = new File(logFilePath);
		try {
			writer = new FileWriter(file, true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		bw = new BufferedWriter(writer);

		logDate = new Date();
		try {
			bw.write(df.format(logDate)+","+s+"\n");
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
