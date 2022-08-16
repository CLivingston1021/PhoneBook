//Christopher Livingston
//07/18/22
//CS 145
//phonebook manager will allow you to either add an entry (name, address, city, phone #)
// to the end and then sort it
import java.util.*;

class PhoneBook {

    String name;
    String address;
    String city;
    String PhoneNumber;
    PhoneBook next;
    void add(PhoneBook pb)

    {

    }
    @Override

    public String toString() {
        return "PhoneBook [name=" + name + ", address=" + address + ", city="
                + city + ", PhoneNumber=" + PhoneNumber+ "]";
    }

    public PhoneBook(String name, String address, String city, String phoneNumber) {
        super();
        this.name = name;
        this.address = address;
        this.city = city;
        PhoneNumber = phoneNumber;
        this.next = null;

    }
}

class PhoneBookManager {
    PhoneBook start;
    void display()
    {
        PhoneBook temp=start;
        boolean isEmpty=true;
        if(temp!=null)
            System.out.format("%-15s%-15s%-15s%-15s\n", "Name","Address","City","Number");
        while(temp!=null) {
            System.out.format("%-15s%-15s%-15s%-15s\n", temp.name,temp.address, temp.city, temp.PhoneNumber);
            temp=temp.next;
            isEmpty=false;
        }
        if(isEmpty)
            System.out.println("Phonebook is empty");
    }

//this function adds the node in sorted order of Name of the contact
    void add(PhoneBook pb)
    {
        PhoneBook current;
        /* Special case for head node */
        if (start == null || start.name.compareTo(pb.name)>=0)
        {
            pb.next = start;
            start = pb;
        }
        else {
            /* Locate the node before point of insertion. */
            current = start;
            while (current.next != null && current.next.name.compareTo(pb.name)<=-1)
                current = current.next;
            pb.next = current.next;
            current.next = pb;
        }
    }
    void modify(String PhoneNumber)
    {
        PhoneBook temp=start;
        boolean found=false;
        while(temp!=null)
        {
            if(temp.PhoneNumber.equals(PhoneNumber)) {
                found=true;
                break;
            }
            temp=temp.next;
        }
        if(found)
        {
            Scanner sc=new Scanner(System.in);
            System.out.println(temp.toString());
            System.out.println("enter new Details");
            String name=sc.next();
            String address=sc.next();
            String city=sc.next();
            String phonenumber=sc.next();
            temp.name=name;
            temp.address=address;
            temp.city=city;
            temp.PhoneNumber=phonenumber;
            System.out.println("Successfully updated");
        } else {
            System.out.println("Given details not found!");
        }
    }
    void sortList() {

    }
    void delete(String PhoneNumber)
    {
//if the contact is starting node.
        if(start.PhoneNumber.equals(PhoneNumber))
        {
            start=start.next;
            return;
        }
        PhoneBook temp=start;
        PhoneBook prev=null;
        boolean found=false;
        while(temp!=null)
        {
            if(temp.PhoneNumber.equals(PhoneNumber))
            {
                found=true;
                break;
            }
            prev=temp;
            temp=temp.next;
        }
        if(found)
        {
            if(start.next!=null)
                prev.next=temp.next;
            else
                start=null;
            System.out.println("Deleted Successfully");
        }
        else
        {
            System.out.println("Given details not found!");
        }
    }
}
class demo
{
    public static void main(String[] args)
    {
        PhoneBookManager pbManager=new PhoneBookManager();
        Scanner sc=new Scanner(System.in);
        System.out.println("1.Add new contact\n2.View contacts\n3.Modify contact\n4.Delete Contact\n5.To exit");
        int choice=sc.nextInt();
        while(true)
        {
            if(choice==1)
            {
                System.out.println("Enter details");
                String name=sc.next();
                String address=sc.next();
                String city=sc.next();
                String phonenumber=sc.next();
                PhoneBook pbook=new PhoneBook(name,address,city,phonenumber);
                pbManager.add(pbook);

            } else if(choice==2) {
                pbManager.display();
            } else if(choice==3) {
                System.out.println("enter phonenumber to edit");
                String number=sc.next();
                pbManager.modify(number);
            } else if(choice==4) {
                System.out.println("Enter number to be deleted");
                String number=sc.next();
                pbManager.delete(number);
            } else {
                break;
            }
            System.out.println("1.Add new contact\n2.View contacts\n3.Modify contact\n4.Delete Contact\n5.To exit");
            choice=sc.nextInt();
        }

    }

}