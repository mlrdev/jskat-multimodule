/*

@ShortLicense@

Authors: @JS@
         @MJL@

Released: @ReleaseDate@

*/

package jskat.share;

import java.io.File;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Vector;
import java.util.HashSet;
import java.util.Iterator;

import org.apache.log4j.Appender;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.RollingFileAppender;

/**
 * @author Markus J. Luzius <markus@luzius.de>
 * @author Jan Sch&auml;fer <jan.schaefer@b0n541.net>
 * 
 */
public class Tools {

	/**
	 * Makes sure that a log4j appender exists. If no appenders can be found,
	 * then a simple console logger is created.
	 * 
	 */
	public static void checkLog() {
		if (log.getAllAppenders() == null
				|| !log.getAllAppenders().hasMoreElements()) {

			try {
				PropertyConfigurator.configure(ClassLoader
						.getSystemResource("jskat/config/log4j.properties"));
				log.debug("log4j initialized using property file.");
			} catch (Exception e) {
				Logger rootLog = Logger.getRootLogger();
				ConsoleAppender ca = new ConsoleAppender();
				ca.setName("console");
				PrintWriter pw = new PrintWriter(System.out);
				ca.setWriter(pw);
				PatternLayout layout = new PatternLayout();
				layout
						.setConversionPattern("[%-5p] %d{yyMMdd HH:mm:ss.SSS} %-30.30c - %m\n");
				ca.setLayout(layout);
				rootLog.addAppender(ca);
				log
						.debug("New appender created as log4j wasn't properly initialized.");
			}
		}
	}

	/**
	 * Converts an int array to a String
	 * 
	 * @param values
	 *            int array
	 * @return string
	 */
	public static String dump(int[] values) {
		StringBuffer sb = new StringBuffer("{");
		for (int i = 0; i < values.length; i++) {
			sb.append(values[i]).append(",");
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.append("}").toString();
	}

	/**
	 * Converts a HashSet array of Cards to a String
	 * 
	 * @param values
	 *            int array
	 * @return string
	 */
	public static String dumpCards(HashSet<Card>[] values) {
		StringBuffer sb = new StringBuffer("{");
		for (int i = 0; i < values.length; i++) {
			Iterator<Card> iter = values[i].iterator();
			sb.append("[");
			while (iter.hasNext()) {
				sb.append(iter.next().toString()).append(",");
			}
			sb.deleteCharAt(sb.length() - 1);
			sb.append("],");
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.append("}").toString();
	}

	/**
	 * Converts a HashSet Vector of Cards to a String
	 * 
	 * @param values
	 *            int array
	 * @return string
	 */
	public static String dumpCards(Vector values) {
		
		StringBuffer sb = new StringBuffer("\n{");
		
		for (int i = 0; i < values.size(); i++) {
		
			Iterator iter = ((CardVector)values.get(i)).iterator();
			sb.append("\n[");
			
			while (iter.hasNext()) {
				sb.append(((Card) iter.next()).toString()).append(",");
			}
			
			sb.deleteCharAt(sb.length() - 1);
			sb.append("]");
		}
		
		return sb.append("\n}").toString();
	}

	public static void setNewLogfile(String filename) {
		Logger logCheck = Logger.getRootLogger();
		Enumeration allAppenders = logCheck.getAllAppenders();
		while (allAppenders.hasMoreElements()) {
			Appender app = (Appender) allAppenders.nextElement();
			if (app instanceof RollingFileAppender) {
				RollingFileAppender app2 = (RollingFileAppender) app;
				log.debug("RollingFileAppender: " + app2.getName()
						+ ": old file " + app2.getFile() + ", new file "
						+ filename);
				app2.setFile(filename);
				app2.activateOptions();
			}
		}
	}

	public static boolean checkPath(String path, boolean doCreate) {
		boolean result = false;
		File testFile = new File(path);

		if (!testFile.exists()) {
			if (doCreate) {
				log.debug("Path " + path
						+ " doesn't exist yet - creating it...");

				if (!testFile.mkdir()) {
					log.warn("Problem in creating the path!");
				} else {
					log.debug("Path " + path + " successfully created");
					result = true;
				}
			}
		} else {
			log.debug("Path " + path + " ok...");
			result = true;
		}

		return result;
	}
	
	/**
	 * Checks whether a number is in a given set of numbers 
	 * @param toCheck the number that should be checked
	 * @param list a list, usually defined by new int[] {a, b, c, ...}
	 * @return
	 */
	public static boolean isIn(int toCheck, int[] list) {
		for(int i=0;i<list.length;i++) {
			if(toCheck==list[i]) return true;
		}
		return false;
	}

	private static Logger log = Logger.getLogger(Tools.class);
}
