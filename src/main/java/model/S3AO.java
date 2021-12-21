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
	        "lostitemmanager",
	        // アップロード先のパス（キー名）
	        "dir/" + fileName + ".png",
	        // ファイルの実体
	        file
	    );
	}
	public static File GetPhotoObject(String fromS3Path , String toWebappPath) {
	    AWSCredentials credentials = new BasicAWSCredentials(S3_ACCESS_KEY,S3_SECRET_KEY);
	    // S3クライアントの生成
	    AmazonS3 s3Client = AmazonS3ClientBuilder
	            .standard()
	            .withCredentials(new AWSStaticCredentialsProvider(credentials))
	            .withRegion(Regions.AP_NORTHEAST_1)
	            .build();
	    // バケット名とS3のファイルパス（キー値）を指定
	    GetObjectRequest request = new GetObjectRequest("lostitemmanager", "dir/" + fromS3Path + ".png");	    
	    // ファイル保存先
	    File file = new File(toWebappPath + File.separator + fromS3Path);
	    System.out.println("FileDownloadTo:" + file.getPath());
	    // ファイルダウンロード
	    s3Client.getObject(request, file);
	    return file;
	}
}