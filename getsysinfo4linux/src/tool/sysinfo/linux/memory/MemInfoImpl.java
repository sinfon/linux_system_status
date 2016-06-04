package tool.sysinfo.linux.memory;

/**
 * Use linux file /proc/meminfo
 * @author ZHJIE
 *
 */
public class MemInfoImpl implements MemInfo {

	public double getMemUsage() {
		Handle4meminfo handle4meminfo = new Handle4meminfo(true);
		long memFree = handle4meminfo.getMemFree();
		long memTotal = handle4meminfo.getMemTotal();
		return 1 - (double)memFree/(double)memTotal;
	}

	public String getMemUsageStr() {
		Handle4meminfo handle4meminfo = new Handle4meminfo(true);
		long memFree = handle4meminfo.getMemFree();
		long memTotal = handle4meminfo.getMemTotal();
		return (memTotal - memFree) + "/" + memTotal;
	}

}
