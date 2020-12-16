package main;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Optional;
import utils.LoadConfig;

/**
 * createAt Dec 16, 2020
 *
 * @author Đỗ Tuấn Anh <daclip26@gmail.com>
 */
public class BackupData {

    static LoadConfig cfg = LoadConfig.getIntanse();
    String dbHost, dbPort, dbName, dbUser, dbPass, folderPath, mysqlDumpPath, mysqlPath;
    String otp = "--add-drop-database --skip-comments";

    public BackupData() {
        dbName = cfg.getProperty("database.name");
        dbUser = cfg.getProperty("database.username");
        dbHost = cfg.getProperty("database.host");
        dbPort = cfg.getProperty("database.port");
        dbPass = cfg.getProperty("database.password");
        folderPath = cfg.getProperty("path.backup");
        mysqlDumpPath = cfg.getProperty("path.mysqldump");
        mysqlPath = cfg.getProperty("path.mysql");
        File dir = new File(folderPath);
        dir.mkdir(); //Tạo thư mục nếu chưa tồn tại
    }

    public void backup() throws IOException, InterruptedException {
        String fileName = generateBackupFileName();
        String filePath = folderPath + "\\" + fileName;
        String executeCmd = String.format("%s %s --host=%s --port=%s --user=%s --password=%s --databases %s -r %s", mysqlDumpPath, otp, dbHost, dbPort, dbUser, dbPass, dbName, filePath);
        Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
        int processComplete = runtimeProcess.waitFor();
        if (processComplete == 0) {
            System.out.println("Backup Thành Công: " + fileName);
        } else {
            System.out.println("Backup Thất Bại");
        }
    }

    public void restore() throws IOException, InterruptedException {
        restore(getLastestBackupFile());
    }

    public String getLastestBackupFile() {
        File dir = new File(folderPath);
        if (dir.isDirectory()) {
            Optional<File> opFile = Arrays.stream(dir.listFiles(File::isFile))
                    .max((f1, f2) -> Long.compare(f1.lastModified(), f2.lastModified()));

            if (opFile.isPresent()) {
                return opFile.get().getName();
            }
        }
        return "backup.sql";
    }

    public void restore(String fileName) throws IOException, InterruptedException {
        String filePath = folderPath + "\\" + fileName;
        String executeCmd = String.format("%s %s --host=%s --port=%s --user=%s --password=%s < %s", mysqlPath, dbName, dbHost, dbPort, dbUser, dbPass, filePath);
        Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
        int processComplete = runtimeProcess.waitFor();
        if (processComplete == 0) {
            System.out.println("Restore Thành Công: " + fileName);
        } else {
            System.out.println("Restore Thất Bại");
        }
    }

    private String generateBackupFileName() {
        String timeStamp = new SimpleDateFormat("dd-MM-yyyy-HH-mm").format(new Timestamp(System.currentTimeMillis()));
        return String.format("backup-%s.sql", timeStamp);
    }

    public static void main(String[] args) {
        try {
//            new BackupData().restore();
            new BackupData().backup();
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
