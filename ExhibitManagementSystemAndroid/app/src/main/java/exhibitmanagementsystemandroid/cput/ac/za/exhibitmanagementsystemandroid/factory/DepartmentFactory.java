package exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.factory;

import exhibitmanagementsystemandroid.cput.ac.za.exhibitmanagementsystemandroid.domain.Department;

/**
 * Created by Bonga on 5/8/2016.
 */
public class DepartmentFactory {

    public static Department CreateDept(String name, String location) {
        Department department = new Department.Builder()
                .name(name)
                .location(location)
                .build();
        return department;
    }
}