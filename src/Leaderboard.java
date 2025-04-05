package src;

public class Leaderboard {
    public static void main(String[] args) {
        // Sample users
        User[] users = new User[5];
        users[0] = new User("Silly Billy", 120);
        users[1] = new User("John Doe", 300);
        users[2] = new User("John Pork", 220);
        users[3] = new User("Travis Scott", 150);
        users[4] = new User("IShowSpeed", 180);

        // Sort users by score using insertion sort
        insertionSort(users);

        // Display the leaderboard
        displayLeaderboard(users);
    }

    // Insertion sort to sort users by score in descending order
    public static void insertionSort(User[] users) {
        for (int i = 1; i < users.length; i++) {
            User key = users[i];
            int j = i - 1;

            // Move elements of users[0..i-1], that are smaller than key, to one position ahead
            while (j >= 0 && users[j].getScore() < key.getScore()) {
                users[j + 1] = users[j];
                j = j - 1;
            }
            users[j + 1] = key;
        }
    }

    // Display the leaderboard
    public static void displayLeaderboard(User[] users) {
        System.out.println("Leaderboard:");
        System.out.println("Rank | Username  | Score");
        System.out.println("--------------------------");
        for (int i = 0; i < users.length; i++) {
            System.out.println((i + 1) + "    | " + users[i].getUsername() + " | " + users[i].getScore());
        }
    }
}
