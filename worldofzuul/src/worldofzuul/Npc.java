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

public Npc(String name, String dialog){
    this.name = name;
    this.dialog = dialog;
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


    
}
