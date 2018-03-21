import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;
import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailHelper {
    //didn't managed to make it working on gmail/outlook
    private String userName = "";
    private String userPassword = "";
    private Properties props = new Properties();
    private Session session;
    //private Message message;

    public MailHelper(){
        //populating connection properties
        this.props.put("mail.smtp.auth", true);
        this.props.put("mail.smtp.starttls.enable", true);
        this.props.put("mail.smtp.host", "smtp.gmail.com");
        this.props.put("mail.smtp.port", "465");
        this.props.put("mail.smtp.ssl.enable", true);

        //creating connection
        this.session = Session.getInstance(this.props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(userName, userPassword);
                    }
                });
            }



    public void sendMessage(Path attachmentPath, String subject, String attachmentName){
        //generating message with attachment
        try {
            Message message = prepareMessage(subject);

            MimeBodyPart messageBodyPart;

            Multipart multipart = new MimeMultipart();

            messageBodyPart = new MimeBodyPart();
            String file = attachmentPath.toString();
            DataSource source = new FileDataSource(file);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(attachmentName);
            multipart.addBodyPart(messageBodyPart);

            message.setContent(multipart);

            Transport.send(message);

        } catch (MessagingException|NullPointerException e) {
            System.err.print(e);
        }

    }

    private Message prepareMessage(String subject){
        //generating message
        try {
            Message message = new MimeMessage(this.session);
            message.setFrom(new InternetAddress(userName));
            for (String address: getEmailsfromFile()){
                message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(address));
            }
            message.setSubject(subject);
            message.setText("");
            return message;

        } catch (MessagingException|IOException e) {
            System.err.print(e);
            return null;
        }
    }

    private List<String> getEmailsfromFile() throws IOException {
        //obtaing email addresses to send test files/reports from separate file
        Path dir = Paths.get(System.getProperty("user.dir")+ File.separator + "TestFiles" + File.separator
                + "emails.txt");
        return Files.readAllLines(dir);
    }

}
