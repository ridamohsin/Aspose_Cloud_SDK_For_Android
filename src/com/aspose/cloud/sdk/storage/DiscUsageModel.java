package com.aspose.cloud.sdk.storage;

import com.google.gson.annotations.SerializedName;

/**
 * Represents DiscUsage section of the DiscUsageResponse
*/
public class DiscUsageModel {
	@SerializedName("TotalSize")
	public long totalSize;
	@SerializedName("UsedSize")
	public long usedSize;
}