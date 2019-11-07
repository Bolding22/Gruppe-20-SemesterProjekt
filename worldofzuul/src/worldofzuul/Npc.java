/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldofzuul;

import java.util.HashMap;
import java.util.jar.Attributes;

/**
 *
 * @author wbold
 */
public class Npc {

private String name;
private String dialog;
private String description;

public Npc(String name, String dialog, String description){
    this.name = name;
    this.dialog = dialog;
    this.description = description;
}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDialog() {
        return dialog;
    }

    public void setDialog(String dialog) {
        this.dialog = dialog;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }


    
}
