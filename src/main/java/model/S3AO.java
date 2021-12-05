package model;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;

public class S3AO {
	private static final String S3_ACCESS_KEY           = "";
    private static final String S3_SECRET_KEY           = "";
    private static final String S3_SERVICE_END_POINT    = "";
    private static final String S3_REGION               = "";
    private static final String S3_BUCKET_NAME          = "";
	public static Object Auth() {
		System.out.println("auth start");

        // AWSの認証情報
        AWSCredentials credentials = new BasicAWSCredentials(S3_ACCESS_KEY, S3_SECRET_KEY);

        // クライアント設定
        ClientConfiguration clientConfig = new ClientConfiguration();
        clientConfig.setProxyHost("[proxyHost]");
        clientConfig.setProxyPort([portNo]);

        // エンドポイント設定
        EndpointConfiguration endpointConfiguration = new EndpointConfiguration(S3_SERVICE_END_POINT,  S3_REGION);

        // S3アクセスクライアントの生成
        AmazonS3 client = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withClientConfiguration(clientConfig)
                .withEndpointConfiguration(endpointConfiguration).build();

        System.out.println("auth end");
        return client;
	}
}