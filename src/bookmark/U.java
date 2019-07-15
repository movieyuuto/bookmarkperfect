package bookmark;

/** ブックマークのデータを表すクラス */
public class U {
	private int number; // 番号
	private String urls;//リンク
	// 以下getterとsetter

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getUrl() {
		return urls;
	}

	public void setUrl(String urls) {
		this.urls = urls;
	}
}