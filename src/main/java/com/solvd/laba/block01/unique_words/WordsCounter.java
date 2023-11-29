package com.solvd.laba.block01.unique_words;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class WordsCounter {
	private String[] allWords;
	private HashMap<String, Integer> words = new HashMap<String, Integer>();

	public WordsCounter(String content) {
		this.setAllWords(content);
		this.countWords();
	}

	public void setAllWords(String content) {
		content = content.replaceAll("\\p{Punct}", "");
		this.allWords = StringUtils.split(content.toLowerCase());
	}

	public void countWords() {
		for (String w : allWords) {
			if (this.words.containsKey(w)) {
				this.words.replace(w, this.words.get(w) + 1);
			} else {
				this.words.put(w, 1);
			}
		}
	}

	public int uniqueWordsAmount() {
		return this.words.size();
	}

	@Override
	public String toString() {
		String out = "";

		for (Map.Entry<String, Integer> entry : this.words.entrySet()) {
			String key = entry.getKey();
			Integer value = entry.getValue();
			out += key + " - " + value + "\n";
		}

		out += out + "\n Total unique words: " + uniqueWordsAmount();
		return out;
	}
}
