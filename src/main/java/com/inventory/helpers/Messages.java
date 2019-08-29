package com.inventory.helpers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

public final class Messages {
	private static final String MESSAGES_PATH = "messages.properties"; //$NON-NLS-1$
	private static Properties prop;

	private Messages() {
	}

	private static void initialize() throws IOException {
		if (Messages.prop == null) {
			InputStream input = null;
			try {
				input = Messages.class.getClassLoader().getResourceAsStream(Messages.MESSAGES_PATH);
				Messages.prop = new Properties();
				if (input == null) {
					System.out.println("Sorry, unable to find " + Messages.MESSAGES_PATH);
					return;
				}
				Messages.prop.load(input);
				input.close();
			} catch (IOException e) {
				if (input != null)
					input.close();
				throw e;
			} finally {
				if (input != null)
					input.close();
			}
		}
	}

	public static String getString(String key) {
		try {
			Messages.initialize();
			return Messages.prop.getProperty(key);
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}

	public static Optional<Integer> getInteger(String key) {
		try {
			Messages.initialize();
			return Optional.ofNullable(Integer.parseInt(Messages.prop.getProperty(key)));
		} catch (IOException e) {
			e.printStackTrace();
			return Optional.empty();
		}
	}
}
