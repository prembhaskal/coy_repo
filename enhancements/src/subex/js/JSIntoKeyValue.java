package subex.js;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class JSIntoKeyValue {

	private final String matchVarLine = "var .*_messages_en_GB.*";
	private final String replaceVarLine = "_messages_en_GB";
	private final String matchKeyValPair = ".*[\"| \"]:[\"| \"].*";

	// print each var name and the corresponding key-value pairs for the file on the jsFilePath.
	public void printVarKeyValuePair(String jsFilePath) {
		File jsFile = new File(jsFilePath);
		try
			(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(jsFile)));
			) {

			String line;
			while ((line=reader.readLine()) != null) {
				line = line.trim();

				if (line.isEmpty())
					continue;

				boolean isVarLine = isVarLine(line);
				if (isVarLine) {
					System.out.println("");
					System.out.println("New Var --> " + getVarName(line));
				} else if (isKeyValuePair(line)) {
					String[] keyVal = getKeyValuePair(line);
					System.out.println("key --> " + keyVal[0] + " value --> " + keyVal[1]);
				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void createVarKeyValuePair(String jsFilePath) {

		Map<String, Map<String, String>> varKeyValMap = new HashMap<>();
		Map<String, String> keyValMap = null;

		File jsFile = new File(jsFilePath);
		try
				(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(jsFile)));
				) {

			String line;
			while ((line=reader.readLine()) != null) {
				line = line.trim();

				if (line.isEmpty())
					continue;

				boolean isVarLine = isVarLine(line);
				if (isVarLine) {
					keyValMap = new HashMap<>();
					String varName = getVarName(line);
					varKeyValMap.put(varName, keyValMap);

					System.out.println("");
					System.out.println("New Var --> " + varName);

				} else if (isKeyValuePair(line)) {
					String[] keyVal = getKeyValuePair(line);
					keyValMap.put(keyVal[0], keyVal[1]);
					System.out.println("key --> " + keyVal[0] + " value --> " + keyVal[1]);
				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String getVarName(String line) {
		String[] lines = line.split(" ");
		int idx = lines[1].lastIndexOf(replaceVarLine);
		String varName = lines[1].substring(0, idx);

		return varName;
	}

	private boolean isKeyValuePair(String line) {
		return line.matches(matchKeyValPair);
	}

	private String[] getKeyValuePair(String line) {
		String[] lines = line.split(":");

		lines[0] = lines[0].trim();
		lines[0] = lines[0].replaceAll("^[\"]", "");
		lines[0] = lines[0].replaceAll("[\"]$", "");

		lines[1] = lines[1].trim();
		lines[1] = lines[1].replaceAll("^[\"]", "");
		lines[1] = lines[1].replaceAll("[\",|\"]$", "");
		lines[1] = lines[1].replaceAll("[\",|\"]$", "");

		return lines;
	}

	private boolean isVarLine(String line) {
		return line.matches(matchVarLine);
	}
}
