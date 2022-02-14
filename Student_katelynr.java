// Student_katelynr.java: sample implementation for Student
// COS 445 HW1, Spring 2018
// Created by Katelyn and Aliya

import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class Student_katelynr implements Student {
    public int[] getApplications(
      int N,
      double S,
      double T,
      double W, // 
      double aptitude, // A_s
      List<Double> schools, // qualities best --> worst
      List<Double> synergies){

        // create copy of synergies
        double[] syns = new double[synergies.size()];
        for (int i=0; i < synergies.size(); i++){
          syns[i] = synergies.get(i);
        }

        int n = schools.size();
        int orig_index = (int) Math.floor((1 - (aptitude / S)) * n) - 1;

        int[] top_schools = new int[10];

        double[] top_synergies = new double[10];
        int index = orig_index;
        for (int i=0; i < 10; i++){
          top_synergies[i] = syns[index];
          index++;
        }

        Arrays.sort(top_synergies);

        int k = 0;
        for (int i = (top_synergies.length - 1); i >= 0; i--){
          for(int j = orig_index; j < orig_index+10; j++){
            if (top_synergies[i] == syns[j]){
              top_schools[k] = j;
              syns[j] = -1;
              break;
            }
          }
          k++;
        }
        return top_schools;
      }
}