package ieti.voicebox.aws.bucket;

public enum BucketName {
	
	PROFILE_IMAGE("voicebox-files"),
	AUDIO_FILE("voicebox-audios");
	
	private final String bucketName;
	
	BucketName(String bucketName){
		this.bucketName = bucketName;
	}
	
	public String getBucketName() {
		return bucketName;
	}

}
