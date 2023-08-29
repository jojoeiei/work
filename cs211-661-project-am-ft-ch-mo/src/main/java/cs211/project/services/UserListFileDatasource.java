package cs211.project.services;
import cs211.project.models.User;
import cs211.project.models.UserList;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserListFileDatasource implements Datasource<UserList> {
    private String directoryName;
    private String fileName;

    public UserListFileDatasource(String directoryName, String fileName) {
        this.directoryName = directoryName;
        this.fileName = fileName;
        checkFileIsExisted();
    }

    private void checkFileIsExisted() {
        File file = new File(directoryName);
        if (!file.exists()) {
            file.mkdirs();
        }
        String filePath = directoryName + File.separator + fileName;
        file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public UserList readData() {
        UserList users = new UserList();
        String filePath = directoryName + File.separator + fileName;
        File file = new File(filePath);
        // เตรียม object ที่ใช้ในการอ่านไฟล์
        FileInputStream fileInputStream = null;

        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        InputStreamReader inputStreamReader = new InputStreamReader(
                fileInputStream,
                StandardCharsets.UTF_8
        );
        BufferedReader buffer = new BufferedReader(inputStreamReader);

        String line = "";
        try {
            // ใช้ while loop เพื่ออ่านข้อมูลรอบละบรรทัด
            while ((line = buffer.readLine()) != null) {
                // ถ้าเป็นบรรทัดว่าง ให้ข้าม
                if (line.equals("")) continue;
                // แยกสตริงด้วย ,
                String[] data = line.split(",");
                // อ่านข้อมูลตาม index แล้วจัดการประเภทของข้อมูลให้เหมาะสม
                String username = data[0].trim();
                String name = data[1].trim();
                String password = data[2].trim();
                String rank = data[3].trim();
                String loginTime = data[4].trim();

                // เพิ่มข้อมูลลงใน list
//                users.addNewUser(username, name, password, rank, loginTime);
                users.addNewUser(username, name, password, loginTime); // write data with no rank
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return users;
    }

    @Override
    public void writeData(UserList data) {
        String filePath = directoryName + File.separator + fileName;
        File file = new File(filePath);
        // เตรียม object ที่ใช้ในการเขียนไฟล์
        FileOutputStream fileOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream(file, true);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
                fileOutputStream,
                StandardCharsets.UTF_8
        );
        BufferedWriter buffer = new BufferedWriter(outputStreamWriter);

        try {
            // สร้าง csv ของ Student และเขียนลงในไฟล์ทีละบรรทัด
            for (User user : data.getUsers()) {
                String line = user.getUsername() + "," + user.getName() + "," + user.getPassword() + "," + user.getRank() + "," + user.getLoginTime();
                buffer.append(line);
                buffer.append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                buffer.flush();
                buffer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void replaceLoginTimeData(UserList data) { // todo remove old data(dataซ้ำ ลบให้เหลืออันเดียว)
        String filePath = directoryName + File.separator + fileName;
        File file = new File(filePath);

        // Read the existing data into memory
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading CSV file", e);
        }

        // Create a map to store the latest login time for each user
        Map<String, String> latestLoginTimes = new HashMap<>();

        // Update the latest login time for each user in memory
        for (User user : data.getUsers()) {
            latestLoginTimes.put(user.getUsername(), user.getLoginTime());
        }

        // Replace the loginTime in each line with the latest login time
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] parts = line.split(",");
            String username = parts[0].trim();

            if (latestLoginTimes.containsKey(username)) {
                parts[4] = latestLoginTimes.get(username);
                lines.set(i, String.join(",", parts));
            }
        }

        // Write the modified data back to the CSV file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String modifiedLine : lines) {
                writer.write(modifiedLine);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Error writing to CSV file", e);
        }


    }
}
