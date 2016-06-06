#include <jni.h>
#include <sys/statfs.h>
#include <stdio.h>
#include <stdlib.h>
#include "tool_sysinfo_linux_disk_SyncDiskInfoJNI.h"


/*
 * Class:     tool_sysinfo_linux_disk_SyncDiskInfoJNI
 * Method:    syncDiskInfo
 * Signature: (Ljava/lang/String;[J)V
 * 
 * unit: B
 */
JNIEXPORT void JNICALL Java_tool_sysinfo_linux_disk_SyncDiskInfoJNI_syncDiskInfo(JNIEnv *env, jobject obj, jstring path, jlongArray infoArray)
{
	jint length;
	length = (*env)->GetArrayLength(env, infoArray);

	if (length != 8) {
		printf("Array length is illegal, it should be EIGHT!\n");
		return;
	}
	
	const char *pathChar = (*env)->GetStringUTFChars(env, path, 0);
	struct statfs diskInfo;
	statfs(pathChar, &diskInfo);
	(*env)->ReleaseStringUTFChars(env, path, pathChar);

	long type = diskInfo.f_type;
	long blockSize = diskInfo.f_bsize;
	long totalBlocks = diskInfo.f_blocks;
	long freeBlocks = diskInfo.f_bfree;
	long availBlocks = diskInfo.f_bavail;
	long totalFileNodes = diskInfo.f_files;
	long freeFileNodes = diskInfo.f_ffree;
	long maxNameLen = diskInfo.f_namelen;
	
//	printf("0 - type: %d\n", type);
//	printf("1 - blockSize: %d\n", blockSize);
//  printf("2 - totalBlocks: %d\n", totalBlocks);
//	printf("3 - freeBlocks: %d\n", freeBlocks);
//	printf("4 - availBlocks: %d\n", availBlocks);
//	printf("5 - totalFileNodes: %d\n", totalFileNodes);
//	printf("6 - freeFileNodes: %d\n", freeFileNodes);
//	printf("7 - maxNameLen: %d\n", maxNameLen);
	
	long buffer[8] = {type, blockSize, totalBlocks, freeBlocks, availBlocks, totalFileNodes, freeFileNodes, maxNameLen};
	(*env)->SetLongArrayRegion(env, infoArray , 0 , length , buffer);

	return;
}

