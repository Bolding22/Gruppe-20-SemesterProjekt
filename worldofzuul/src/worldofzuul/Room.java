package worldofzuul;

import java.util.ArrayList;
import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;

public class Room {

    private String description;
    private HashMap<String, Room> exits;
    private ArrayList<Item> items = new ArrayList<Item>();
    private ArrayList<Npc> npcs = new ArrayList<>();

    public Room(String description) {
        this.description = description;
        exits = new HashMap<String, Room>();
    }

    public void setExit(String direction, Room neighbor) {
        exits.put(direction, neighbor);
    }

    public String getShortDescription() {
        return description;
    }

    public String getLongDescription() {
        return description + "\n" + getExitString();
    }

    public ArrayList<Npc> getNpcs() {
        return npcs;
    }

    private String getExitString() {
        String returnString = "Routes available:";
        Set<String> keys = exits.keySet();
        for (Iterator iter = keys.iterator(); iter.hasNext();) {
            returnString += " " + iter.next();
        }

        return returnString;
    }

    public Room getExit(String direction) {
        return exits.get(direction);
    }

    /*
    * Find items in room
     */
    public Item getItem(int index) {
        return items.get(index);
    }

    public Item getItem(String itemName) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equals(itemName)) {
                return items.get(i);
            }
        }
        return null;
        /*
    * Add item to the room
         */
    }

    public void setItem(Item newitem) {
        items.add(newitem);
    }

    /*
    *Remove item from the room
     */
    public void removeItem(String itemName) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equals(itemName)) {
                items.remove(i);
            }
        }
    }

    /*
    * What is in the room?
     */
    public void getItemsRoom() {
        String output = "";
        for (int i = 0; i < items.size(); i++) {
            output += items.get(i).getName() + " ";
        }
        System.out.println(output);
    }

    public void addNpc(Npc n) {
        npcs.add(n);
    }

    public void getNpcsRoom() {
        String output = "";
        for (int i = 0; i < npcs.size(); i++) {
            output += "[" + npcs.get(i).getName() + npcs.get(i).getDescription() + "]";
        }
        System.out.println("Do you want to talk to: " + output + "?");
    }

    public void removeNpc(String npcName) {
        for (int i = 0; i < npcs.size(); i++) {
            if (npcs.get(i).getName().equals(npcName)) {
                npcs.remove(i);
            }
        }
    }

}
