/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaairlines;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 *
 * @author jayia
 */
public class User {
    private String user_id;
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    // private Boolean isNew;
    private String phoneNum;
    private String address;
    private String[] emergency_contact = new String[3];
    
    public User(String user_id, String first_name, String last_name, String email, String password, String address, String phoneNum){
        this.user_id=user_id;
        this.first_name = first_name;
        this.last_name=last_name;
        this.password=password;
        this.email=email;
        // this.isNew=isNew;
        this.phoneNum=phoneNum;
        this.address=address;
    }

    
    // Getters
    public String getUserId() {
        return user_id;
    }

    public String getFirstName() {
        return first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() { // Do not return actual password for security
        return password;
    }

    public Boolean getIsNew() {
        return isNew;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    // Setters (for profile update)
    public void setFirstName(String firstName) {
        this.first_name = firstName;
    }

    public void setLastName(String lastName) {
        this.last_name = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEmergencyContact(String name, String phoneNum,String relation) {
        emergency_contact[0]=name;
        emergency_contact[1]=phoneNum;
        emergency_contact[2]=relation;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    private boolean readUsersFile(User user){
        String line="";

        //reading file to see if userID already exists
        try(BufferedReader readUser = new BufferedReader(new FileReader("users.txt"))){

            while ((line = readUser.readLine())!=null) {
                String[] info = line.split(",");
                String currentUserId=info[0];

                if(currentUserId.equals(user.getUserId())){
                    readUser.close();
                    return true;
                }
            }

            return false;

        }catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return false;
         } catch(IOException e){
             System.out.println(e.getMessage());
            return false;
         }
    }
    
    //register: write new user to file
    public boolean register(User newUser){
        Boolean userExist = readUsersFile(newUser);
            
        if(userExist){
            System.out.println("User ID already taken");
            return false;
        }
        else{
            try {
                FileWriter addUser = new FileWriter("users.txt", true);

                //turning userdetails into string 
                String userDetails =newUser.getUserId()+ ","+ newUser.getFirstName() + "," + newUser.getLastName() + "," + newUser.email + "," + newUser.phoneNum+ "," + newUser.password +","+ newUser.address;
                addUser.append(userDetails);//appending to file
                addUser.close();
            } catch (IOException e) {
                System.out.println("Error in registering: "+ e.getMessage());
                return false;
            }
        }
         

        return true;
        
    }
    
    //login: reads file and returns boolean
    public boolean login(User currentUser) {
        Boolean userExists = readUsersFile(currentUser);
        return userExists;
    }

    //getDetails: get user details
    public String getUserDetails(String user_id) throws IOException, FileNotFoundException{
        String line="";
        BufferedReader readUser = new BufferedReader(new FileReader("users.txt"))
        //reading file to see if userID already exists


            while ((line = readUser.readLine())!=null) {
                String[] info = line.split(",");
                String currentUserId=info[0];

                if(currentUserId.equals(user_id)){
                    return line;
                }
            }
        
    }
    
    //updateProfile: allows the user to edit email, name or address
    public Boolean updateFile (String update, String category){


        return true
    }
    
    //addContact: allows user to add their emergency contact
    
    //change password: 
    
}
