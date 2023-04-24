package org.launchcode.techjobs.oo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    public Job() {
        this.id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }


    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    public String capitalize(String k){
        String capitalizedString;
        if(k != "id"){
            capitalizedString = k.substring(0, 1).toUpperCase() + k.substring(1);
        }else {
            capitalizedString = k.substring(0, 2).toUpperCase() + k.substring(2);
        }
        return capitalizedString;
    }
    public String addSpaceBetweenWords(String k){
        String spacedOutString;
        if(k.equals("ID")){
            return k;
        } else {
            String[] splitString = k.split("(?=[A-Z])");
            spacedOutString = String.join(" ", splitString);
            return spacedOutString;
        }
    }

    public boolean doesJobExist(String finalDisplay){
        String jobDoesntExist = "\nID: "+ this.id+
                "\nName: Data not available" +
                "\nEmployer: Data not available" +
                "\nLocation: Data not available" +
                "\nPosition Type: Data not available" +
                "\nCore Competency: Data not available\n";
        if(finalDisplay.equals(jobDoesntExist)){
            return false;
        }
        return true;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() throws IllegalArgumentException {
        String display = "\n";
        Field[] fields = this.getClass().getDeclaredFields();
        try {
            for (Field field : fields) {
                String key = addSpaceBetweenWords(capitalize(field.getName()));
                Object value = field.get(this);
                if(!key.equals("Next Id") && value != null && !value.toString().equals("")) {
                    display = display.concat(key + ": " + value + "\n");
                } else if(value == null || value.toString().equals("")){
                    display = display.concat(key + ": Data not available\n");
                }
            }
        }catch (Exception e){
            System.out.println("not gonna work");
        }
        if(doesJobExist(display)){
            return display;
        }
        return "OOPS! This job does not seem to exist.";
    }

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.


    public int getId() {
        return id;
    }

    public void setNextId(int number){
        nextId = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }
}
