package com.santhana.logger.remote;

public class Test {


    /*private static final String SERVER = "10.101.130.4";//"ftpserver";
    private static final String SOURCE_PATH = "C:/Users/dsadmin/AppData/Local/CCiServer/log/CCiServer.log";
    private static final String SOURCE_PATH_1 = "C$\\Users\\dsadmin\\AppData\\Local\\CCiServer\\log\\CCiServer.log";

    private static final String DES_PATH = "C:/Users/Raghavendra/Desktop/TouchScreen/Logs/CCiServer.log";


    public static void main(String[] arg) {
        try {
            getTerm();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getTerm() throws IOException {
        File f = new File(DES_PATH); //Takes the default path, else, you can specify the required path
        if (f.exists()) {
            f.delete();
        }
        f.createNewFile();
        FileObject destn = VFS.getManager().resolveFile(f.getAbsolutePath());
        UserAuthenticator auth = new StaticUserAuthenticator("LNGAMING-130", "myusername", "secret_password");
        FileSystemOptions opts = new FileSystemOptions();
        DefaultFileSystemConfigBuilder.getInstance().setUserAuthenticator(opts, auth);
        FileObject fo = VFS.getManager().resolveFile("\\10.101.130.4:5555\\" + SOURCE_PATH_1, opts);
        destn.copyFrom(fo, Selectors.SELECT_SELF);
        destn.close();
    }*/
}
