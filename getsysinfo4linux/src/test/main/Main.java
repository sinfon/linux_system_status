package test.main;

import tool.sysinfo.linux.cpu.CPUInfoImpl;
import tool.sysinfo.linux.memory.MemInfoImpl;

public class Main {
	public static void main(String[] args) {
		int interval = Integer.valueOf(args[0]);
		CPUInfoImpl cpuInfoImpl = new CPUInfoImpl();
		MemInfoImpl memInfoImpl = new MemInfoImpl();
		while (true) {
			try {
				System.out.println("Cpu Usage: " + cpuInfoImpl.getCPUUsage(interval));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("Mem Usage: " + memInfoImpl.getMemUsage());
			System.out.println("Mem Usage: " + memInfoImpl.getMemUsageStr());
		}
	}
}
