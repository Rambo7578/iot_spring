package com.iot.spring.vo;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;


public class NaverMsg {

	/*
	 * { "message":{ "@type":"response", "@service":"naverservice.labs.api",
	 * "@version":"1.0.0", "result":{
	 * "translatedText":"속성 'empSal에 필요한 형식 'int''형식''java.lang.String의 속성 값으로 변환하려고 할;입력 문자열입니다.\"A\"동안 중첩된 예외는 java.lang.NumberFormatException:지 못 했습니다."
	 * , "srcLangType":"en" } } }
	 */
	private Message message;

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public class Message {
		private Result result;

		public Result getResult() {
			return result;
		}

		public void setResult(Result result) {
			this.result = result;
		}

		@JsonIgnoreProperties(ignoreUnknown = true)
		public class Result {
			private String translatedText;

			public String getTranslatedText() {
				return translatedText;
			}

			public void setTranslatedText(String translatedText) {
				this.translatedText = translatedText;
			}
		}
	}

}