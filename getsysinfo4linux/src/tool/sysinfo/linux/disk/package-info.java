/**
 * Can not find a file to read disk information (like memory information read from /proc/meminfo).
 * <br>And using JAVA {@link Runtime} to get a system command invocation may be not advisable [ for me specifically ].
 * <br>However, there is indeed a command named "df" could be invoked.
 * <br>And known from the Internet, this command uses sys/statfs.h to implement.
 * <br>So, Just learning how to use JNI
 * 
 * @author ZHJIE
 *
 */
package tool.sysinfo.linux.disk;