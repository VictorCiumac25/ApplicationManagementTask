import com.google.gson.Gson;
import model.Status;
import model.User;
import model.Users;
import util.FileUtil;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;


public class Application {

    public static void main(String[] args) {
        final String FILE_NAME = "users.json";
        FileUtil fileUtil;

        long timestamp = System.currentTimeMillis();

        User user = new User("Andrew", "Rhyell", Status.NEW, timestamp, 18, "andrew18@gmail.com");
        User user1 = new User("James", "Smith", Status.NEW, timestamp, 22, "james22@gmail.com");
        User user2 = new User("Roberta", "Williams", Status.NEW, timestamp, 21, "roberta21@gmail.com");
        User user3 = new User("Michelle", "Horton", Status.NEW, timestamp, 33, "michelle33@gmail.com");
        User user4 = new User("Rob", "Walters", Status.NEW, timestamp, 20, "rob20@gmail.com");

        ArrayList<User> userList = new ArrayList();

        userList.add(user);
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        Gson gson = new Gson();
        String json = gson.toJson(new Users(userList));

        fileUtil = new FileUtil();
        fileUtil.createFile(json, FILE_NAME);
        Users users = gson.fromJson(fileUtil.readFile(FILE_NAME), Users.class);
        for (User currentUser : users.getUsers()) {
            System.out.println(currentUser);
        }
        compareToYesterday(Instant.now(), users);
        compareToMonth(Instant.now(), users);
    }

    private static void compareToYesterday(Instant today, Users users) {
        /*iterates through the users list and change status from NEW to ACTIVE for
        those whose registered date is older than yesterday*/
        Instant yesterday = today.minus(1, ChronoUnit.DAYS);
        Date yesterdayDate = Date.from(yesterday);
        for (User currentUser : users.getUsers()) {
            Date registeredDate = new Date(currentUser.getTimestamp());
            if (currentUser.getStatus() == Status.NEW && registeredDate.after(yesterdayDate)) {
                currentUser.setStatus(Status.ACTIVE);
            }
        }
    }

    private static void compareToMonth(Instant today, Users users) {
        /*iterates through the users list and change status from INACTIVE to BLOCKED for
        those whose registered date is older than one month ago*/
        Instant monthAgo = today.minus(1,ChronoUnit.MONTHS);
        Date monthAgoDate = Date.from(monthAgo);
        for (User currentUser : users.getUsers()) {
            Date registeredDate = new Date(currentUser.getTimestamp());
            if (currentUser.getStatus() == Status.INACTIVE && registeredDate.before(monthAgoDate)) {
                currentUser.setStatus(Status.BLOCKED);
            }
        }
    }
}
