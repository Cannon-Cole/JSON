/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package json;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Cole
 */
public class JSON {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        holder objToJ = new holder();
        objToJ.name = "Cole";
        objToJ.className = "CIT360";
        objToJ.weekNumber = 5;

        JSONObject stringify = new JSONObject();

        stringify.put("name", objToJ.name);
        stringify.put("class", objToJ.className);
        stringify.put("week", Integer.toString(objToJ.weekNumber));

        String needsParsing = stringify.toJSONString();

        System.out.println(needsParsing);

        JSONParser parser = new JSONParser();

        holder restored = new holder();

        try {
            JSONObject parsed = (JSONObject) parser.parse(needsParsing);

            restored.name = (String) parsed.get("name");
            restored.className = (String) parsed.get("class");
            //inexplicable conversion error so I added this line
            String convert = (String) parsed.get("week");
            restored.weekNumber = Integer.parseInt(convert);
        } catch (ParseException pe) {
            System.out.println("position: " + pe.getPosition());
            System.out.println(pe);
        }
        System.out.println(restored.name);
        System.out.println(restored.className);
        System.out.println(restored.weekNumber);
    }

}
