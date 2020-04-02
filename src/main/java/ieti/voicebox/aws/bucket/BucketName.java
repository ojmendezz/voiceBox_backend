package ieti.voicebox.aws.bucket;

public enum BucketName {
	
	PROFILE_IMAGE("voicebox-files");
	
	private final String bucketName;
	
	BucketName(String bucketName){
		this.bucketName = bucketName;
	}
	
	public String getBucketName() {
		return bucketName;
	}

}
