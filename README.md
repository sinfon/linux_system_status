
Use "/proc/stat" to calculate the CPU usage rate.

Use "/proc/meminfo" to calculate the memory usage rate.

See "man proc" to see why.

2016-06-06
"libSyncDiskInfoJNI.so" under directory "getsysinfo4linux" is not universal.
Its source files are just under "getsysinfo4linux/resources/native_code", 
and there is a file named README which tells you how to generate such a dynamic-link library file.

what's more?
There are something wrong when calculating disk information. I don't wanna say too much detail, 
just see annotations under some source files.
