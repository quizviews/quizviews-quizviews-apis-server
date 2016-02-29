package com.viewquiz.backend.app.quiz.s3;

import java.time.LocalDateTime;

public class S3_VersionDirectory {

	private int version;
	private LocalDateTime date;
	private S3 s3;

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public S3 getS3() {
		return s3;
	}

	public void setS3(S3 s3) {
		this.s3 = s3;
	}

	public static class S3 {

		private String app_Name;
		private String s3_Name;

		public S3(String s3_Name, String app_Name) {
			this.s3_Name=s3_Name;
			this.app_Name=app_Name;
		}

		public String getAppName() {
			return app_Name;
		}

		public void setAppName(String appName) {
			this.app_Name = appName;
		}

		public String getS3_Name() {
			return s3_Name;
		}

		public void setS3_Name(String s3_Name) {
			this.s3_Name = s3_Name;
		}
	}

}
