package br.com.samuelklein.dna.json;

public class UtilJson {

	public static boolean testNull(Object o) {
		return o != null;
	}

	public static String getJson(String nome, Object value) {

		StringBuilder sb = new StringBuilder();

		sb.append(getValue(nome));
		sb.append(":");
		sb.append(value.toString());

		return sb.toString();
	}

	public static String getJson(String nome, String value) {
		StringBuilder sb = new StringBuilder();

		sb.append(getValue(nome));
		sb.append(":");
		sb.append(getValue(value));

		return sb.toString();
	}

	public static String getValue(String value) {
		StringBuilder sb = new StringBuilder();
		sb.append("\"");
		sb.append(value);
		sb.append("\"");

		return sb.toString();
	}

	public static String getJson(String nome, Object[] value) {
		StringBuilder sb = new StringBuilder();

		sb.append(getValue(nome));
		sb.append(":[");
		boolean firt = true;
		for (int i = 0; i < value.length; i++) {
			if (!firt) {
				sb.append(",");
			}
			sb.append(value[i].toString());

			firt = false;
		}
		sb.append("]");
		return sb.toString();
	}

	public static String getJson(String nome, String[] value) {
		StringBuilder sb = new StringBuilder();

		sb.append(getValue(nome));
		sb.append(":[");
		boolean firt = true;
		for (int i = 0; i < value.length; i++) {
			if (!firt) {
				sb.append(",");
			}
			sb.append(getValue(value[i]));

			firt = false;
		}
		sb.append("]");
		return sb.toString();
	}

	public static String getJson(String nome, String[][] value) {
		StringBuilder sb = new StringBuilder();

		sb.append(getValue(nome));
		sb.append(":[");
		boolean firt = true;
		for (int i = 0; i < value.length; i++) {
			if (!firt) {
				sb.append(",");
			}
			boolean firt2 = true;
			sb.append("[");
			for (int j = 0; j < value[i].length; j++) {
				if (!firt2) {
					sb.append(",");
				}

				sb.append(getValue(value[i][j]));

				firt2 = false;
			}
			sb.append("]");
		}
		sb.append("]");
		return sb.toString();
	}

	public static String getJson(String nome, Object[][] value) {
		StringBuilder sb = new StringBuilder();

		sb.append(getValue(nome));
		sb.append(":[");

		boolean firt = true;

		for (int i = 0; i < value.length; i++) {

			if (!firt) {
				sb.append(",");
			}
			boolean firt2 = true;
			sb.append("[");
			for (int j = 0; j < value[i].length; j++) {
				if (!firt2) {
					sb.append(",");
				}

				sb.append(value[i][j].toString());

				firt2 = false;
			}
			sb.append("]");
			firt = false;
		}

		sb.append("]");
		return sb.toString();
	}

}