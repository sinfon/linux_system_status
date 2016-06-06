package tool.sysinfo.linux.disk;

public class Handler4StatFS {
	private StatFS statFS = new StatFS("/");	
	
	/**
	 * willInit is true - initialize once new a instance
	 * willInit is false - manually invoke {@link #setDiskInfo()}
	 * @param willInit
	 */
	public Handler4StatFS(boolean willInit) {
		if (willInit) {
			setDiskInfo();
		}
	}
	
	/**
	 * Get and set disk information once be called
	 */
	public void setDiskInfo() {
		/*
		 *  TODO 此处暂时只获取了挂载到根目录的文件系统的基本信息，理论上貌似要获取全部挂载点然后求和才对
		 *       因为这样已经暂时满足了我的需求，暂不进行下一步，恩，对，我懒
		 *       获取所有挂载点记得在哪看到过可以从文件获取
		 *       此外df命令貌似普遍是进一法计算的结果
		 *       再此外，百分比为什么不匹配，df的百分比是什么鬼？
		 */
		statFS.setAll();
	}
	
	
	/**
	 * Total size of all file systems, include whole mount points
	 * Unit: MB
	 * @param path
	 * @return
	 */
	public long getTotalDisk() {
		return (statFS.getF_bsize() * statFS.getF_blocks()) >> 20;
	}
	
	/**
	 * Total free size of all file systems, include whole mount points
	 * Unit: MB
	 * @param path
	 * @return
	 */
	public long getFreeDisk() {
		return (statFS.getF_bsize() * statFS.getF_bfree()) >> 20;
	}
}
