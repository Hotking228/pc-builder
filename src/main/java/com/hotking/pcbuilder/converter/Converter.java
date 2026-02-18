package com.hotking.pcbuilder.converter;

import java.io.*;

public class Converter {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/input.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/output.txt"));
        String s = "";
        while((s = reader.readLine()) != null){
            StringBuilder sb = new StringBuilder();
            int index = 0;
            while(s.charAt(index) != '.'){
                index++;
            }
            index++;
            while(index < s.length()){
                sb.append(s.charAt(index++));
            }
            s += " := Mcs_Simulation_VG." + sb.toString() + ";\n";
            writer.write(s);
        }

        writer.close();
        reader.close();
    }
}
