package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core;

import java.io.File;
import java.io.IOException;
import java.security.CodeSource;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

/**
 * You are free to use this code however you
 * like but I assume no responsibility for it's
 * correctness and provide no warranty of any kind.
 *
 * @author Michael Connor
 */
public class Classpath {
    
    public static interface FileFilter {
        /**
         * All paths will be represented
         * using forward slashes and no
         * files will begin with a slash
         */
        public boolean accept(String filename);
    }

    /** 
     * Returns a list of the classes on the
     * classpath.  The names returned will
     * be appropriate for using Class.forName(String)
     * in that the slashes will be changed to dots
     * and the .class file extension will be removed.
     */
    public static String[] getClasspathClassNames() 
    throws ZipException, IOException { 
        String[] classes = getClasspathFileNamesWithExtension(".class");
        for ( int i = 0; i < classes.length; i++ ) {
            classes[i] = classes[i].substring(0, classes[i].length() - 6).replace("/",".");
        }
        return classes;
    }
    
    public static String[] getClasspathFileNamesWithExtension(final String extension) 
    throws ZipException, IOException {
        return getClasspathFileNames( new FileFilter() {
            public boolean accept(String filename) {
                return filename.endsWith(extension);
            }
        });        
    }
    
    public static String[] getClasspathFileNames(FileFilter filter)
    throws ZipException, IOException {
        List filenames = new ArrayList();
        for ( String filename : getClasspathFileNames() ) {
            if ( filter.accept(filename) ) {
                filenames.add(filename);
            }
        }
        return (String[]) filenames.toArray(new String[filenames.size()]);
    }
    
    /**
     * Returns the fully qualified class names of
     * all the classes in the classpath.  Checks 
     * directories and zip files.  The FilenameFilter
     * will be applied only to files that are in the 
     * zip files and the directories.  In other words,
     * the filter will not be used to sort directories.
     */
    public static String[] getClasspathFileNames() throws ZipException, IOException {
    	String javaCp = System.getProperty("java.class.path");
    	
    	CodeSource src = Classpath.class.getProtectionDomain().getCodeSource();
		if (src != null){
			System.out.println("src=" + src.getLocation());
			javaCp = javaCp + File.pathSeparator + src.getLocation();
		} else {
		}
    	System.out.println(" --> Scanning: " + javaCp);
    	
        StringTokenizer tokenizer = new StringTokenizer(javaCp, File.pathSeparator, false);
        Set<String> filenames = new LinkedHashSet();
        
        while ( tokenizer.hasMoreTokens() ) {
            String classpathElement = tokenizer.nextToken();
            File classpathFile = new File(classpathElement);
            
            if ( classpathFile.exists() && classpathFile.canRead() ) {
//        		System.out.println("--> getClasspathFileNames: " + classpathElement);
                if ( classpathElement.toLowerCase().endsWith(".jar") ) {
                    ZipFile zip = new ZipFile(classpathFile);
                    Enumeration entries = zip.entries();
                    
                    while( entries.hasMoreElements() ) {
                        ZipEntry entry = (ZipEntry) entries.nextElement();
                        if ( ! entry.isDirectory() ) {
                            filenames.add(entry.getName());
                        }
                    }
                    
                } else if ( classpathFile.isDirectory() ) {
                    // lets go through and find all of the subfolders
                    Set<File> directoriesToSearch = new HashSet();
                    Set<File> newDirectories = new HashSet();
                    directoriesToSearch.add(classpathFile);
                    String basePath = classpathFile.getAbsolutePath();
                    
                    while ( directoriesToSearch.size() > 0 ) {
                        for ( File searchDirectory : directoriesToSearch ) {
                            File[] directoryFiles = searchDirectory.listFiles();
                            for ( File directoryFile : directoryFiles ) {
                                if ( directoryFile.isDirectory() ) {
                                    newDirectories.add(directoryFile);
                                } else {
                                    filenames.add(directoryFile.getAbsolutePath().substring(basePath.length() + 1));
                                }
                            }
                        }
                        directoriesToSearch.clear();
                        directoriesToSearch.addAll(newDirectories);
                        newDirectories.clear();
                    }
                }
            }
        }
        
        String[] uniqueNames = new String[filenames.size()];
        int index = 0;
        
        for ( String name : filenames ) {
            uniqueNames[index++] = name.replace("\\", "/");
        }
            
        return uniqueNames;
    }
    
    public static void main (String[] args) throws Exception {
        String[] names = getClasspathClassNames();
        for ( String name : names ) {
            System.out.println(name);
        }
    }
}