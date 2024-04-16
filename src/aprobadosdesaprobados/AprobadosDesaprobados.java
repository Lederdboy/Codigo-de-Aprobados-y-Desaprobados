/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aprobadosdesaprobados;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author jkale
 */

public class AprobadosDesaprobados {

    public static void main(String[] args) {
        int n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de estudiantes"));
        List<Double> nota1 = new ArrayList<>();
        List<Double> nota2 = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            double nota;
            do {
                nota = getDoubleInput("Ingrese la primera nota del estudiante " + (i + 1) + " (0 y 20)");
                if (nota < 0 || nota > 20) {
                    JOptionPane.showMessageDialog(null, "La nota debe estar entre 0 y 20");
                }
            } while (nota < 0 || nota > 20);
            nota1.add(nota);
            do {
                nota = getDoubleInput("Ingrese la segunda nota del estudiante " + (i + 1) + " (0 y 20)");
                if (nota < 0 || nota > 20) {
                    JOptionPane.showMessageDialog(null, "La nota debe estar entre 0 y 20");
                }
            } while (nota < 0 || nota > 20);
            nota2.add(nota);
        }
        
        List<Double> promedios = calculateAverage(nota1, nota2);
        List<String> aprobados = getApprovedStudents(promedios);
        List<String> desaprobados = getFailedStudents(promedios);
        
        Collections.sort(aprobados);
        Collections.sort(desaprobados);
        
        JOptionPane.showMessageDialog(null, "Aprobados:\n" + String.join("\n", aprobados));
        JOptionPane.showMessageDialog(null, "Desaprobados:\n" + String.join("\n", desaprobados));
    }
    
    public static double getDoubleInput(String message){
        return Double.parseDouble(JOptionPane.showInputDialog(message));
    }
    
    public static List<Double> calculateAverage(List<Double> nota1, List<Double> nota2){
        List<Double> promedios = new ArrayList<>();
        for (int i = 0; i < nota1.size(); i++) {
            double promedio = (nota1.get(i) + nota2.get(i))/ 2;
            promedios.add(promedio);
        }
        return promedios;
    }
    
    public static List<String> getApprovedStudents(List<Double> promedios){
        List<String> aprobados = new ArrayList<>();
        for (int i = 0; i < promedios.size(); i++) {
            if (promedios.get(i) >= 10) {
                aprobados.add("Estudiante " + (i + 1) + ": " + promedios.get(i));
            }
        }
        return aprobados;
    }
    
    public static List<String> getFailedStudents(List<Double> promedios){
        List<String> desaprobados = new ArrayList<>();
        for (int i = 0; i < promedios.size(); i++) {
            if (promedios.get(i) < 10) {
                desaprobados.add("Estudiante " + (i + 1) + ": " + promedios.get(i));
            }
        }
        return desaprobados;
    }
}
