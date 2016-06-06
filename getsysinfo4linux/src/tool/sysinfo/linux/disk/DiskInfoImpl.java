package tool.sysinfo.linux.disk;

public class DiskInfoImpl implements DiskInfo {

	public double getDiskUsage() {
		Handler4StatFS dd = new Handler4StatFS(true);
		long freeSize = dd.getFreeDisk();
		long totalSize = dd.getTotalDisk();
		return 1 - (double)freeSize/(double)totalSize;
	}

	public String getDiskUsageStr() {
		Handler4StatFS dd = new Handler4StatFS(true);
		long freeSize = dd.getFreeDisk();
		long totalSize = dd.getTotalDisk();
		return (totalSize - freeSize) + "/" + totalSize;
	}
	


}
