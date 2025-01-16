
import java.util.*;

class Node {

    String pName;
    String pDisease;
    String pAdmissionDate;

    public Node(String pName, String pDisease, String pAdmissionDate) {
        this.pName = pName;
        this.pDisease = pDisease;
        this.pAdmissionDate = pAdmissionDate;

    }

}

public class patient {

    public static void main(String[] args) {

        HashMap<String, Node> pRecords = new HashMap<String, Node>();
        HashMap<String, Node> pDischarge = new HashMap<String, Node>();

        System.out.println("Welcome to patient management system");

        while (true) {

            Scanner scan = new Scanner(System.in);

            System.out.println("\nKindly choose any of the option given below");
            System.out.println("1.Show the list of Patients:");
            System.out.println("2.Add new patient details:");
            System.out.println("3.Display the disease and admission date of the patient:");
            System.out.println("4.Discharge a patient:");

            System.out.print("Enter Your Choice: ");
            int input = scan.nextInt();
            scan.nextLine();

            switch (input) {
                case 1:
                    if (pRecords.isEmpty()) {
                        System.out.println("\nThere is no patients");
                        break;
                    } else {
                        System.out.println("\nPatients list");
                        for (String value : pRecords.keySet()) {

                            System.out.println(value);
                        }

                        break;
                    }

                case 2:

                    System.out.print("\nEnter the patient's name: ");
                    String addPname = scan.nextLine();
                    System.out.print("\nEnter patient's disease name:");
                    String addDname = scan.nextLine();
                    System.out.print("\nEnter patient's admission date:");
                    String addAdate = scan.nextLine();
                    Node pNode = new Node(addPname, addDname, addAdate);
                    pRecords.put(addPname, pNode);

                    break;

                case 3:
                    System.out.print("\nEnter the patient's name: ");
                    String getPname = scan.nextLine();
                    if (pRecords.get(getPname) != null) {
                        Node getNode = pRecords.get(getPname);
                        System.out.println("\nPatient's details:\n" + "Name:" + getNode.pName + "\nDisease name:"
                                + getNode.pDisease + "\nAdmission date:" + getNode.pAdmissionDate);
                        break;
                    } else {
                        System.out.println("\nThere is no patients with this name");
                        break;
                    }

                case 4:
                    System.out.print("\nEnter the patient's name: ");
                    String removeP = scan.nextLine();
                    if (pRecords.get(removeP) != null) {
                        Node removeNode = pRecords.get(removeP);
                        pDischarge.put(removeP, removeNode);
                        pRecords.remove(removeP);

                        System.out.println("\nPatient is discharged");
                        break;
                    } else {
                        System.out.println("\nThere is no patients with this name");
                        break;
                    }

                case 5:

                    return;

                default:
                    System.out.println("\nInvaild Choice");

            }

        }

    }

}