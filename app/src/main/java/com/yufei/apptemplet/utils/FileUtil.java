package com.yufei.apptemplet.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by wangyufei on 16/9/5.
 */
public class FileUtil {

    private static final int BUFFER_SIZE = 512 * 8;

    /**
     * cannot be instantiated
     */
    private FileUtil() {

        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * create path
     *
     * @param filePath
     */
    public static File createPath(String filePath) {

        File file = new File(filePath);

        try {

            if (!file.exists())
                file.mkdirs();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return file;
    }

    /**
     * create file
     *
     * @param filePath
     * @param fileName
     * @throws IOException
     */
    public static File createFile(String filePath, String fileName) throws IOException {

        File file = new File(filePath, fileName);

        file.createNewFile();

        return file;
    }

    /**
     * determine whether a file exists
     *
     * @param filePath
     * @param fileName
     */
    public static boolean isFileExist(String filePath, String fileName) {

        boolean result = false;
        File file = new File(filePath + fileName);

        try {

            if (file.exists())
                result = true;
            else
                result = false;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return result;
    }

    /**
     * delete the directory and all of the following files
     *
     * @param filePath
     */
    public static void deleteFiles(String filePath) {

        try {

            if (filePath == null)
                return;

            File file = new File(filePath); //Define the file path

            if (file.exists()) {

                //directory or file
                if (file.isDirectory()) {

                    //if no files directly delete directory
                    if (file.listFiles().length == 0) {

                        file.delete();
                    } else {

                        //put the file into the array, and determine whether there is a lower directory
                        File files[] = file.listFiles();

                        int len = file.listFiles().length;

                        for (int i = 0; i < len; i++) {

                            //recursive call deleteFiles method and obtain the sub directory path
                            if (files[i].isDirectory())
                                deleteFiles(files[i].getAbsolutePath());

                            files[i].delete();//delete file
                        }
                    }
                } else {

                    file.delete();
                }
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    /**
     * write a InputStream data to the path
     *
     * @param filePath
     * @param fileName
     * @param inputStream
     */
    public static File writeFileFromInputStream(String filePath, String fileName, InputStream inputStream) {

        File file = null;
        OutputStream outputStream = null;

        createPath(filePath);

        try {

            if (inputStream != null) {

                file = createFile(filePath, fileName);
                outputStream = new FileOutputStream(file);

                byte buffer[] = new byte[BUFFER_SIZE];
                int index = 0;

                while ((index = inputStream.read(buffer)) != -1) {

                    outputStream.write(buffer, 0, index);
                }

                outputStream.flush();
            }
        } catch (Exception e) {

            e.printStackTrace();
        } finally {

            try {

                if(outputStream != null)
                    outputStream.close();

            } catch (Exception e) {

                e.printStackTrace();
            }
        }

        return file;
    }

    /**
     * copy file
     *
     * @param resPath
     * @param savePath
     * @param fileName
     */
    public static void copyFile(String resPath, String savePath, String fileName) {

        if (!isFileExist(resPath, fileName))
            return;

        InputStream inputStream = null;
        OutputStream outputStream = null;

        createPath(savePath);

        try {

            File resFile = new File(resPath, fileName);
            File saveFile = createFile(savePath, fileName);

            byte buffer[] = new byte[BUFFER_SIZE];
            int index = 0;

            inputStream = new FileInputStream(resFile);
            outputStream = new FileOutputStream(saveFile);

            while ((index = inputStream.read(buffer)) != -1) {

                outputStream.write(buffer, 0, index);
            }

            outputStream.flush();
        } catch (Exception e) {

            e.printStackTrace();
        } finally {

            try {

                if (inputStream != null)
                    inputStream.close();

                if (outputStream != null)
                    outputStream.close();
            } catch (Exception e) {

                e.printStackTrace();
            }

        }
    }
}
