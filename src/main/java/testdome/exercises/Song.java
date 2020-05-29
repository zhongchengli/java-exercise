package testdome.exercises;

/*
A playlist is considered a repeating playlist if any of the songs contain a reference to a previous song in the playlist. Otherwise, the playlist will end with the last song which points to null.

Implement a function isRepeatingPlaylist that, efficiently with respect to time used, returns true if a playlist is repeating or false if it is not.

For example, the following code prints "true" as both songs point to each other.
 */

public class Song {
    private String name;
    private Song nextSong;

    public Song(String name) {
        this.name = name;
    }

    public void setNextSong(Song nextSong) {
        this.nextSong = nextSong;
    }

    // TODO: https://www.testdome.com/questions/java/song/36020?visibility=3&skillId=4

    public boolean isRepeatingPlaylist() {
        Song next = this.nextSong;
        while (next != null) {
            if (next.name.equalsIgnoreCase(name)) {
                return true;
            }
            next = next.nextSong;
        }
        return false;
    }

    public static void main(String[] args) {
        Song first = new Song("Hello");
        Song second = new Song("Eye of the tiger");
        Song third = new Song("AA");
        Song forth = new Song("bb");

        first.setNextSong(second);
        second.setNextSong(third);
        third.setNextSong(forth);
        forth.setNextSong(first);


        System.out.println(second.isRepeatingPlaylist());
    }
}
