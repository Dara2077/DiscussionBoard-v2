import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        boolean message = false;
        System.out.print("What is your username? ");
        String author = scan.nextLine();
        System.out.println("What do you want to post?");
        System.out.print("Your options are: \n Post a message (m) or a photo (p): ");
        String decision = scan.nextLine();
        if (decision.equals("m")){
            message = true;
        }
        String text = "";
        String filename = "";
        String caption = "";
        MessagePost myMessage = null;
        PhotoPost myPhoto = null;
        NewsFeed myNewsFeed = new NewsFeed();
        if (message){
            System.out.println("What do you want to say?");
            text = scan.nextLine();
            myMessage = new MessagePost(author, text);
            myNewsFeed.addPost(myMessage);
        }
        else{
            System.out.print("What is the filename? ");
            filename = scan.nextLine();
            System.out.print("What is the caption? ");
            caption = scan.nextLine();
            myPhoto = new PhotoPost(author, filename, caption);
            myNewsFeed.addPost(myPhoto);
        }

        myNewsFeed.show();
        String action = "";
        while (! (action.equals("q"))){
            if (message) {
                System.out.print("Would you like to \n like(l) \n unlike(ul) \n add comment (ac) \n get text (gt) \n get time stamp (gs) \n quit (q) ");
                String answer = scan.nextLine();
                if (answer.equals("l")){
                    myMessage.like();
                }
                else if (answer.equals("ul")){
                    myMessage.unlike();
                }
                else if (answer.equals("ac")){
                    System.out.print("What is your comment? ");
                    String comment = scan.nextLine();
                    myMessage.addComment(comment);
                }
                else if (answer.equals("gt")){
                    System.out.println(myMessage.getText());
                }
                else if (answer.equals("gs")){
                    System.out.println(myMessage.getTimeStamp());
                }
                else if (answer.equals("q")){
                    action = "q";
                }
                else{
                    System.out.println("That is not an action!");
                }
            }
            else{
                System.out.print("Would you like to \n like(l) \n unlike(ul) \n add comment (ac) \n get image file (gif) \n get caption (gc) \n get time stamp (gs) \n quit (q) ");
                String answer = scan.nextLine();
                if (answer.equals("l")){
                    myPhoto.like();
                }
                else if (answer.equals("ul")){
                    myPhoto.unlike();
                }
                else if (answer.equals("ac")){
                    System.out.print("What is your comment? ");
                    String comment = scan.nextLine();
                    myPhoto.addComment(comment);
                }
                else if (answer.equals("gif")){
                    System.out.println(myPhoto.getImageFile());
                }
                else if (answer.equals("gc")){
                    System.out.println(myPhoto.getCaption());
                }

                else if (answer.equals("gs")){
                    System.out.println(myPhoto.getTimeStamp());
                }
                else if (answer.equals("q")){
                    action = "q";
                }
                else{
                    System.out.println("That is not an action!");
                }
            }
            if (! action.equals("q")){
                System.out.println();
                myNewsFeed.show();
            }
        }
        System.out.println("Thanks for posting!");
    }
}

