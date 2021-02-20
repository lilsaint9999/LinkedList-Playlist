package com.company;

import java.util.*;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<>();

    private static void play(LinkedList<Song> playList){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;

        ListIterator<Song> listIterator = playList.listIterator();
        if (playList.size() ==0){
            System.out.println("No songs in playlist!");
        } else {
            System.out.println("Now playing: " + listIterator.next().toString());
        }

        while (!quit){
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action){
                case 0:
                    System.out.println("Playlist completed. Last song was: "+ playList.getLast());
                    quit = true;
                    break;
                case 1:
                    if (!forward){
                        if (listIterator.hasNext()){
                            listIterator.next();
                        } forward = true;
                    } if (listIterator.hasNext()){
                    System.out.println("Now playing " + listIterator.next().toString());
                }else {
                    System.out.println("We`ve reached the end of playlist!");
                    forward = false;
                }
                    break;
                case 2:
                    if (forward){
                        if (listIterator.hasPrevious()){
                            listIterator.previous();
                        } forward = false;
                    }if (listIterator.hasPrevious()){
                    System.out.println("Now playing " + listIterator.previous().toString());
                }else {
                    System.out.println("We are at the start of the playlist");
                    forward = true;
                }   break;
                case 3:
                    if (forward){
                        if (listIterator.hasPrevious()){
                            System.out.println("Now replaying: " + listIterator.previous().toString());
                            forward = false;
                        }else {
                            System.out.println("we are at the start of the playlist");
                        }
                    }else
                        if(listIterator.hasNext()){
                            System.out.println("Now replaying " + listIterator.next().toString());
                            forward = true;
                        } else  {
                            System.out.println("We are at the end of the playlist");
                        }

                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if (playList.size()>0) {
                        listIterator.remove();
                        if (listIterator.hasNext()) {
                            System.out.println("Now playing " + listIterator.next());
                        } else if (listIterator.hasPrevious()) {
                            System.out.println("Now playing " + listIterator.previous());
                        } else {
                            System.out.println("No more songs in this playlist");
                        }
                    }
                    break;
            }
        }

    }
    private static void printMenu(){
        System.out.println("Available options:\npress");
        System.out.println("0 - to quit\n" +
                "1- to go forward\n" +
                "2- to go back\n" +
                "3- to replay this song\n" +
                "4- list all songs in this playlist\n" +
                "5- print available options\n" +
                "6- delete current song.");
    }
    private static void printList(LinkedList<Song> playlist){
        Iterator<Song> iterator = playlist.iterator();
        System.out.println("=====================");
        while (iterator.hasNext()){
            System.out.println(iterator.next());

        } System.out.println("=====================");
    }

    public static void main(String[] args) {

        Album album = new Album("This is 50", "50 Cent");
        album.addSong("In Da Club",3.44);
        album.addSong("Wanksta",4.01);
        album.addSong("Many Man", 4.08);

        albums.add(album);
         album = new Album("G-Unit", "50 cent");
         album.addSong("Friends", 4.40);
         album.addSong("So seductive", 4.55);
         album.addSong("High", 2.59);
         albums.add(album);

        LinkedList<Song> playlist = new LinkedList<Song>();
        albums.get(0).addToPlaylist("In Da Club", playlist);
        albums.get(0).addToPlaylist("Many Man", playlist);
        albums.get(1).addToPlaylist(3,playlist);
        albums.get(1).addToPlaylist(2,playlist);
        albums.get(1).addToPlaylist(5,playlist);
        play(playlist);





    }
}
