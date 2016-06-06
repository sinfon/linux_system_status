package tool.sysinfo.linux.disk;

/**
 * Copy from linux structure [statfs]
 * @author ZHJIE
 *
 */
public class StatFS {
	private long f_type; /* type of file system */
	private long f_bsize; /* optimal transfer block size */
	private long f_blocks; /* total data blocks in file system */
	private long f_bfree; /* free blocks in file system */
	private long f_bavail; /* free blocks avail to non-superuser */
	private long f_files; /* total file nodes in file system */
	private long f_ffree; /* free file nodes in file system */
	private long f_namelen; /* maximum length of filenames */
	
	private String path;
	
	public StatFS(String path) {
		this.path = path;
	}
	
	public long getF_type() {
		return f_type;
	}
	
	public long getF_bsize() {
		return f_bsize;
	}
	
	public long getF_blocks() {
		return f_blocks;
	}
	
	public long getF_bfree() {
		return f_bfree;
	}
	
	public long getF_bavail() {
		return f_bavail;
	}
	
	public long getF_files() {
		return f_files;
	}
	
	
	public long getF_ffree() {
		return f_ffree;
	}
	
	public long getF_namelen() {
		return f_namelen;
	}
	
	/**
	 * Call native method and set members
	 */
	public void setAll() {
		if (path == null)
			throw new NullPointerException("path is null, illegal");
		
		SyncDiskInfoJNI jni = new SyncDiskInfoJNI();
		long[] buffer = new long[8];
		jni.syncDiskInfo(path, buffer);
		
		setF_type(buffer[0]);
		setF_bsize(buffer[1]);
		setF_blocks(buffer[2]);
		setF_bfree(buffer[3]);
		setF_bavail(buffer[4]);
		setF_files(buffer[5]);
		setF_ffree(buffer[6]);
		setF_namelen(buffer[7]);
		
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void setF_type(long f_type) {
		this.f_type = f_type;
	}

	public void setF_bsize(long f_bsize) {
		this.f_bsize = f_bsize;
	}

	public void setF_blocks(long f_blocks) {
		this.f_blocks = f_blocks;
	}

	public void setF_bfree(long f_bfree) {
		this.f_bfree = f_bfree;
	}

	public void setF_bavail(long f_bavail) {
		this.f_bavail = f_bavail;
	}

	public void setF_files(long f_files) {
		this.f_files = f_files;
	}

	public void setF_ffree(long f_ffree) {
		this.f_ffree = f_ffree;
	}

	public void setF_namelen(long f_namelen) {
		this.f_namelen = f_namelen;
	}
	
	
	
}
