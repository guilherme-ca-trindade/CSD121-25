import javax.imageio.ImageIO; // 5. Package javax.imageio: for read/write image files
import javax.swing.*; //5. Package javax.swing: for GUI components (i.e. JFrame)
import java.awt.*; //5. Package javax.awt: for colors and layout
import java.io.IOException; //5. Package javax.io: for Input/Output (IO) Streams and Exceptions
import java.io.InputStream;
import java.net.URI;        //5. Package javax.net: for HTTP requests and responses
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

void main() {
    try {
        var avatarStream = getRandomAvatarStream(); //6. avatarStream is reference type (InputStream)
        showAvatar(avatarStream); //7. avatarStream is an argument for the showAvatar method, and it's a reference type (InputStream)
    } catch (IOException | InterruptedException e) { //1. IOException and InterruptedException are public classes and e a Exception object (reference type)
        e.printStackTrace(); //1. e.printStackTrace is an Instance method
        /*
    2. We have three method calls.
        2.1. getRandomAvatarStream () will return an InputStream. This method will generate a random avatar.
        2.2 showAvatar () take an InputStream imageStream as parameter. This method will display the avatar generated for the Input Stream
        2.3 e.printStackTrace() will occur when an Exception is raised, and it will print the stack trace of the exception.
    4. IOException belongs to java.io.IOException
    */
    }

}

InputStream getRandomAvatarStream() throws IOException, InterruptedException {
    // Pick a random style
    String[] styles = { "adventurer", "adventurer-neutral", "avataaars", "big-ears", "big-ears-neutral", "big-smile", "bottts", "croodles", "croodles-neutral", "fun-emoji", "icons", "identicon", "initials", "lorelei", "micah", "miniavs", "open-peeps", "personas", "pixel-art", "pixel-art-neutral" };
    var style = styles[(int)(Math.random() * styles.length)];
    /*
    6. styles and style are reference type (both String)
    1. Math.random(): .random( ) is a class method of the Math class (public final class)
    1.styles.length: .length is an instance variable for styles (an array String[ ])
     4. InputStream belongs to java.io
     */

    // Generate a random seed
    var seed = (int)(Math.random() * 10000);
    /*
    6. seed is a primitive type (int)
    1. Math.random: .random( ) is a class method of the Math class (public final class)
     */

    // Create an HTTP request for a random avatar
    var uri = URI.create("https://api.dicebear.com/9.x/%s/png?seed=%d".formatted(style, seed));
    /*
    6. uri is a reference type (URI)
    2. URI.create() creates a URI by parsing the given string.
    1. URI.create(): .create() is a class method of URI class (public final class)
    1. .formatted is an instance method of the String
    4. URI belongs to java.net
     */
    var request = HttpRequest.newBuilder(uri).build();
    /*
    6. request is a reference type (HttpRequest)
    2. HttpRequest.newBuilder() creates an HttpRequest builder with the given URI
    1. HttpRequest.newBuilder(): .newBuilder() is class method of the HttpRequest (public abstract class)
    1. .build() is an instance method
    4. HttpRequest belongs to java.net.http
     */

    // Send the request
    try (var client = HttpClient.newHttpClient()) {
        /*
        6. client is a reference type (HttpClient)
        2. HttpClient.newHttpClient() returns a new HttpClient with default settings
        1. HttpClient.newHttpClient(): .newHttpClient() is a class method of the HttpClient (public abstract class)
        4. HttpClient belongs to java.net.http
         */
        var response = client.send(request, HttpResponse.BodyHandlers.ofInputStream());
        /*
        6. response is a reference (HttpResponse<InputStream>)
        2. client.send() sends request and gets response
        1. client.send(): .send() is an instance method
        2. HttpResponse.BodyHandlers.ofInputStream() returns an image stream
        1. HttpResponse.BodyHandlers is a class variable
        1. HttpResponse.BodyHandlers.ofInputStream() is a class method
        4. HttpResponse belongs to java.net.http
         */
        return response.body(); // 1. response.body() is an instance method and returns the body (InputStream)
    }
}

void showAvatar(InputStream imageStream) { //7. the argument in showAvatar (InputStream imageStream) is a reference type
    JFrame frame = new JFrame("PNG Viewer");
    /*
    6. frame is a reference type (JFrame)
    3. JFrame has a constructor method and creates a new, initially invisible Frame with the specified title.
    4. JFrame belongs to javax.swing
    4. InputStream belongs to java.io
     */
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    /*
    1. frame.setDefaultCloseOperation() is an instance method
    2. frame.setDefaultCloseOperation() sets the operation that will happen by default when the user initiates a "close" on this frame
    1. JFrame.EXIT_ON_CLOSE) is class variable
    4. JFrame belongs to javax.swing
     */
    frame.setResizable(false); //1. frame.setResizable() is an instance method and 2. sets whether this frame is resizable by the user
    frame.setSize(200, 200); //1. frame.setSize() is an instance method and 2.resizes this component so that it has width and height
    frame.getContentPane().setBackground(Color.BLACK);
    /*
    1.frame.getContentPane() is an instance method and 2. returns the contentPane object for this frame
    1. frame.getContentPane().setBackground() is an instance method and 2. sets the background color of this component
    1. Color.BLACK is a class variable
    4. Color belongs to java.awt
     */

    try {
        // Load the PNG image
        Image image = ImageIO.read(imageStream);
        /*
        6. image is a reference type (Image)
        1. ImageIO.read() is a class method
        2. ImageIO.read() returns a BufferedImage containing the decoded contents of the input
        4. ImageIo belongs to javax.imageio
        4. Image belong to java.awt
         */
        // Create a JLabel to display the image
        JLabel imageLabel = new JLabel(new ImageIcon(image));
        /*
        3. JLabel has a constructor method and creates a JLabel instance with the specified image
        6. imageLabel is a reference type (JLabel)
        3. ImageIcon has a constructor method and creates an ImageIcon from an image object
        4. JLabel belongs to javax.swing
        4. ImageIcon belongs to javax.swing
         */
        frame.add(imageLabel, BorderLayout.CENTER);
        /*
        1. frame.add() is an instance method
        2. frame.add() adds the specified component to the end of this container.
        1. BorderLayout.CENTER is a class variable
        4. BorderLayout belongs to java.awt
         */

    } catch (IOException e) {
        e.printStackTrace(); //1. e.printStackTrace is an instance method and 2. will occur when an Exception is raised, and it will print the stack trace of the exception.
    }

    frame.setVisible(true); //1. frame.setVisible() is an instance method and 2. shows or hides this Window depending on the value of parameter (boolean)
}
