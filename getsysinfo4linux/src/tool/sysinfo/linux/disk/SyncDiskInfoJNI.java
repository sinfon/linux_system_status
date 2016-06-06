package tool.sysinfo.linux.disk;

public class SyncDiskInfoJNI {
	static {
		System.loadLibrary("SyncDiskInfoJNI");
	}
	
	/**
	 * 传入infoArray中与硬盘大小相关的字段单位为：字节
	 * @param path
	 * @param infoArray
	 */
	public native void syncDiskInfo(final String path, long infoArray[]);
}
