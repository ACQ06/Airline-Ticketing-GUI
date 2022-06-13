import java.util.*;


class Infos{
    private String name;
    private int age;
    private int AirlineType;

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public void setName(String newName){
        name = newName;
    }

    public void setAge(int newAge){
        age = newAge;
    }
}

class Test{
    public void test(){
        Scanner input = new Scanner(System.in);
        String name;
        int age;
        Infos []info = new Infos[5];
        for (int i=0; i<=4; i++){
            System.out.print("Enter Name: ");
            name = input.nextLine();
            System.out.print("Enter Age: ");
            age = input.nextInt();

            info[i] = new Infos();
            info[i].setName(name);
            info[i].setAge(age);
        }

        System.out.print(info[0].getName());
        System.out.print(info[0].getAge());
    }
}