import java.net.*;
import java.io.*;
import java.util.*;

public class DNS {
    public static void main(String[] args) {
        int n;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.println("\n Menu: \n 1. DNS 2.Exit \n");
            System.out.println("\n Enter your choice");
            n = Integer.parseInt(System.console().readLine());
            if (n == 1) {
                try {
                    System.out.println("\n Enter Host Name ");
                    String hname = in .readLine();
                    InetAddress address;
                    address = InetAddress.getByName(hname);
                    System.out.println("Host Name: " + address.getHostName());
                    System.out.println("IP: " + address.getHostAddress());
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        } while (!(n == 2));
    }
}

/*

OUTPUT
-------
Menu: 
 1. DNS 2.Exit 
Enter your choice
1
Enter Host Name 
www.gprec.ac.in
Host Name: www.gprec.ac.in
IP: 182.50.132.59
 Menu: 
 1. DNS 2.Exit 
 Enter your choice
1
Enter Host Name 
www.gmail.com
Host Name: www.gmail.com
IP: 172.253.119.19
 Menu: 
1.DNS 2.Exit  Enter your choice 2


*/
