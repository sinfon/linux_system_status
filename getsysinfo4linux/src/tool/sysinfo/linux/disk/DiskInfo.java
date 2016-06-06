package tool.sysinfo.linux.disk;

/**
 * Linux Disk Information
 * @author ZHJIE
 *
 */
public interface DiskInfo {
	
	/**
	 * Disk usage rate
	 * @return
	 */
	public double getDiskUsage();
	
	/**
	 * Disk usage rate in format: used/total - 111/1111 - unit(MB)
	 * @return
	 */
	public String getDiskUsageStr();
	
}
