package writers;

@FunctionalInterface
public interface FileOutputWriter {
	
	/**
	 * Write in file
	 * @return a List with the File content
	 */
	void write();
	
}
