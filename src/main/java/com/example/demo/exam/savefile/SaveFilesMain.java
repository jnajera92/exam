package com.example.demo.exam.savefile;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SaveFilesMain {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingresa el texto a guardar: ");
        String text = sc.nextLine();

        System.out.print("Ingresa el directorio y nombre del archivo: ");
        String path = sc.nextLine();
        saveFile(text,path);
    }

    private static void saveFile(String text, String path){

        try {
            FileWriter myWriter = new FileWriter(path.contains(".txt")?path:path+".txt");
            myWriter.write(text);
            myWriter.close();
            System.out.println("Se guardo el archivo exitosamente");
        } catch (IOException e) {
            System.out.println("No se pudo guardar el archivo");
        }
    }
}
