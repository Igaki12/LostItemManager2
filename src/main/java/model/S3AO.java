package model;

import java.io.File;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;


public class S3AO {
	private static final String S3_ACCESS_KEY           = "AKIAV6SFZ4FIUDM7N2HS";
    private static final String S3_SECRET_KEY           = "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";
    
	public static void PutPhotoObject(String fileName, File file) {
		AWSCredentials credentials = new BasicAWSCredentials(S3_ACCESS_KEY,S3_SECRET_KEY);
	    // S3クライアントの生成
	    AmazonS3 s3Client = AmazonS3ClientBuilder
	            .standard()
	            .withCredentials(new AWSStaticCredentialsProvider(credentials))
	            .withRegion(Regions.AP_NORTHEAST_1)
	            .build();
	    // ファイルをアップロード
	    s3Client.putObject(
	        // アップロード先バケット名
	        "BucketName",
	        // アップロード先のパス（キー名）
	        "dir/" + fileName + ".png",
	        // ファイルの実体
	        file
	    );
	}
	public static File GetPhotoObject(String fileName) {
	    AWSCredentials credentials = new BasicAWSCredentials(S3_ACCESS_KEY,S3_SECRET_KEY);
	    // S3クライアントの生成
	    AmazonS3 s3Client = AmazonS3ClientBuilder
	            .standard()
	            .withCredentials(new AWSStaticCredentialsProvider(credentials))
	            .withRegion(Regions.AP_NORTHEAST_1)
	            .build();
	    // バケット名とS3のファイルパス（キー値）を指定
	    GetObjectRequest request = new GetObjectRequest("Photo", "dir/" + fileName + ".png");
	    // ファイル保存先
	    File file = new File("c:/temp/sample.png");
	    // ファイルダウンロード
	    s3Client.getObject(request, file);
	    return file;
	}
}