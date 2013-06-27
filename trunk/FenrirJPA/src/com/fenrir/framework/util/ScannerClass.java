package com.fenrir.framework.util;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;

import com.fenrir.framework.EtexProperties;

/**
 * 
 * 
 * @author Felipe de Andrade Batista
 * @version 1.0.0
 */
public class ScannerClass {
	
	private static List<String> classes = new ArrayList<String>();
	
	private static Map<String, Object> mapDiretorios = new HashMap<String, Object>();
	
	public static List<String> getAllClassApp() {

		if(getClasses().size() == 0) {
			return scan(Thread.currentThread().getContextClassLoader(),Collections.EMPTY_SET, Collections.EMPTY_SET);
		} else {
			return getClasses();
		}
		
	}
	
	private static List<String> scan(ClassLoader classLoader, Set<String> locations,
			Set<String> packages) {
		if (!(classLoader instanceof URLClassLoader)) {
			return null;
		}

		URLClassLoader urlLoader = (URLClassLoader) classLoader;
		URL[] urls = urlLoader.getURLs();

		for (URL url : urls) {
			String path = url.getFile();
			
			File location = null;
			try {
				location = new File(url.toURI());
			} catch (URISyntaxException e) {
				e.printStackTrace();
				return null;
			}

			// Only process the URL if it matches one of our filter strings
			if (matchesAny(path, locations)) {
				if (location.isDirectory()) {
					getClassesInDirectory(null, location, packages);
				} 
//				else {
//					getClassesInJar(location, packages);
//				}
			}
		}
		
		return getClasses();
	}

	private static void getClassesInDirectory(String parent, File location, Set<String> packagePatterns) {
		
		File[] files = location.listFiles();
		StringBuilder builder = null;

		for (File file : files) {
			builder = new StringBuilder(100);
			
			//TODO : pega o diretorio meta META-INF ou configuration.properties
			if (file.isDirectory() || file.getName().equals(EtexProperties.CONFIGURATION_PROPERTIES)) {
				getMapDiretorios().put(file.getName(), file);
			}
			
			builder.append(parent).append("/").append(file.getName());
			String packageOrClass = (parent == null ? file.getName() : builder
					.toString());

			if (file.isDirectory()) {
				getClassesInDirectory(packageOrClass, file, packagePatterns);
			} else if (file.getName().endsWith(".class")) {
				if (matchesAny(packageOrClass, packagePatterns)) {
					getClasses().add(packageOrClass);
				}
			}
		}
	}

//	private static void getClassesInJar(File location,
//			Set<String> packagePatterns) {
//		try {
//			JarFile jar = new JarFile(location);
//			Enumeration entries = jar.entries();
//
//			while (entries.hasMoreElements()) {
//				ZipEntry entry = (ZipEntry) entries.nextElement();
//				String name = entry.getName();
//				
//				if (!entry.isDirectory() && name.endsWith(".class")) {
//					if (matchesAny(name, packagePatterns)) {
//						getClasses().add(name);
//					}
//				}
//			}
//		} catch (IOException ioe) {
//			ioe.printStackTrace();
//		}
//	}

	private static boolean matchesAny(String text, Set<String> filters) {
		if (filters == null || filters.size() == 0) {
			return true;
		}
		for (String filter : filters) {
			if (text.indexOf(filter) != -1) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		List<String> classes = getAllClassApp();
		
		
//		for (String classe : classes) {
//			System.out.println(classe.replace("/", "."));
//		}
		
		File file = (File) getMapDiretorios().get(EtexProperties.CONFIGURATION_PROPERTIES);
		
		System.out.println(file.getAbsolutePath());
		
	}

	private static List<String> getClasses() {
		return classes;
	}

	public static Map<String, Object> getMapDiretorios() {
		return mapDiretorios;
	}

	public static void setMapDiretorios(Map<String, Object> mapDiretorios) {
		ScannerClass.mapDiretorios = mapDiretorios;
	}
}
